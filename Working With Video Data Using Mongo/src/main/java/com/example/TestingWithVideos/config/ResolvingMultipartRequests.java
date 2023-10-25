package com.example.TestingWithVideos.config;

import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

@Component
public class ResolvingMultipartRequests {

    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    public StandardServletMultipartResolver multipartResolver(MultipartProperties multipartProperties) {
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        multipartResolver.setStrictServletCompliance(true);
        multipartResolver.setResolveLazily(multipartProperties.isResolveLazily());
        return multipartResolver;
    }
}
