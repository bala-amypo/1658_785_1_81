package com.example.demo.security;

import com.example.demo.entity.User; // Ensure this import is correct
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "your_secret_key";

    public String generateToken(User user) {
        // Line 28 usually looks like this:
        return Jwts.builder()
                .setSubject(user.getUsername()) // This is where the error occurs
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}