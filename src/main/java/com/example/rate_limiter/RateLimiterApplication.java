package com.example.rate_limiter;

import com.example.rate_limiter.Component.RateLimitingFilter;
import com.example.rate_limiter.Controller.RateLimiting;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.apache.catalina.filters.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<RateLimitingFilter> rateFilter(RateLimitingFilter rateLimitingFilter) {
		FilterRegistrationBean<RateLimitingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(rateLimitingFilter);
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}


	@Bean
	public RateLimitingFilter rateLimitingFilter() {
		return new RateLimitingFilter();
	}
}
