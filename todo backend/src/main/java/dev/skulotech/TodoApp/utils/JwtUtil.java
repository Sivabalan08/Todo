package dev.skulotech.TodoApp.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECERT ="sivaskullotechLikeshareSubscribeprogramrelatecontext";
    private final long EXPIRATION =1000*60;         //abc@gmail.com->qadfwfevxe244->token
    private final Key secertKey = Keys.hmacShaKeyFor(SECERT.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secertKey, SignatureAlgorithm.HS256)//digitalcheckup
                .compact();
    }
    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secertKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    public boolean validateJwtToken(String token){
        try{
            extractEmail(token);
            return true;
        }
        catch (JwtException exception){
            return false;
        }
    }
}
