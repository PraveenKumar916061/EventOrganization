package com.img.Event_organization.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTService {

    static final String SECRET_KEY="fWf5dM3zSzHpayjzgO0XIIMOwkUUCXnTKJhntor4TAQUDVg58QozXQ9yDhSvv3+iBCnX7B0oqk5rNGxnF4V9jzCyZkfvTspShDaAl5w7jbWvs1Bekb7Zwd4Lqf4r+j7WKgkL4DaHXMpB4wZaV1YfYS70ceuWtNlFkHrgwbmo99dd/AZf2vfhVO839roS84A0OsPA7QKzkB599MWvDu9aDJSgdxdvrfrSQuI1btvDnpTjv0JlJyDZf5PuVMr58WWs42h1EbxuZhQY9wU/OUUkfVAMple682G1f53NXySlYpZyfzIyadrdKHCGVBK5KH7nwPxWH4LlXjbt4hEuKorFgGnb1/oQj29AwjtAbAgOFKQ=\n";
    public String generateToken(String username) {
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(secretKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    private Key secretKey() {
        byte[] keys=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keys);
    }

    public String extractUsername(String token) {
        return extractClaims(token,Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }
}
