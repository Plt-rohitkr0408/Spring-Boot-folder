package com.example.securityP04.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

public class JwtService {

    private final String SECRET_KEY ="mysecretkeymysecretkeymysecretkeymysecretkey" ;

    // generate token -------------------------
    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(getSecretKey())
                .compact();
    }

    // get username from token -----------------------------
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    // get expirationDate ---------------------
    public Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
         Claims claims = extractAllClaim(token);
         return claimsResolver.apply(claims);
    }

    private Claims extractAllClaim(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token){
        return extractExpiration(token).before( new Date());
    }

    public boolean validateToken(String token , UserDetails userDetails){
        return extractUsername(token).equals(userDetails.getUsername()) && isTokenValid(token);
    }


    private Key getSecretKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

}
