package com.example.rate_limiter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rateLimit")
public class RateLimiting {
    @GetMapping("/check")
    public String testLimit(){
        return "Request Successful";
    }
}
