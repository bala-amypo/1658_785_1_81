package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF (If enabled, POST/PUT/DELETE will always return 403)
            .csrf(csrf -> csrf.disable())
            
            // 2. Configure Authorization
            .authorizeHttpRequests(auth -> auth
                // This line permits all your API endpoints so you get 200 OK
                .requestMatchers("/api/**").permitAll() 
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                
                // Any other request not listed above requires login
                .anyRequest().authenticated()
            )
            
            // 3. Disable Frame Options to allow Swagger/H2 Console if needed
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}