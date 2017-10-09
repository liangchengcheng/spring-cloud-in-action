package com.didispace.web;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "HELLO-SERVICE",fallback = HelloServiceFallback.class)
public class HelloService {
    
}
