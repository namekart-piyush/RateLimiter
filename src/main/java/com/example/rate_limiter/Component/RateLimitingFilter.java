package com.example.rate_limiter.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
public class RateLimitingFilter implements Filter, jakarta.servlet.Filter {
    @Autowired
    private StringRedisTemplate requestsPerIp;
    private static final int max_req = 3;


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        String curr_ip = httpServletRequest.getRemoteAddr();

        Long requests = requestsPerIp.execute((RedisCallback<Long>) connection->{
            byte key[] = requestsPerIp.getStringSerializer().serialize(curr_ip);

            connection.multi();
            connection.incr(key);
            connection.expire(key,5);
            List<Object> res = connection.exec();
            return (Long)res.get(0);

        });

        if (requests != null && requests > max_req) {
            httpServletResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            httpServletResponse.getWriter().write("Too many requests. Please try again later.");
            return;
        }

        chain.doFilter(request,response);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
