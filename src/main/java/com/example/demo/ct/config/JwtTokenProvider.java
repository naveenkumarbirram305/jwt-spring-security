package com.example.demo.ct.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.ct.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration-in-ms}")
    private long jwtExpirationInMs;
    
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    private final SecretKey secretKey = Keys.secretKeyFor(SIGNATURE_ALGORITHM);

	public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
       // claims.put("id", user.getId());
        claims.put("loginId", user.getLoginId());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getLoginId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(secretKey)
                .compact();
    }
	
	public boolean validateToken(String token) {
	    try {
	        Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
	        return true;
	    } catch (Exception e) {
	        // Log exception or handle it as needed
	        return false;
	    }
	}


	public String getUserIdFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
		return claims.get("loginId", String.class);
	}

}
