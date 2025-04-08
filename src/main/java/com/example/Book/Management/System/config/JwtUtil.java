package com.example.Book.Management.System.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 * JwtUtil is responsible for:
 * 1) Generating JWT tokens.
 * 2) Validating and parsing existing tokens.
 */

@Component
public class JwtUtil {

    //A secret key for signing the tokens
    private static final String SECRET_KEY = "896c96f234049adfd71f91c5cd833ae0ec688ca07e7de33b59e9de344ecb54ab5847847f3dd7760c7d5e51e1037c353f4e673e0dfcc2f634d1ab48ceb936b277";

    //Retrieve the signing key as a key object.
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /**
     *  Generate a JWT token for a given username (or any other subject).
     *    - setSubject(): The primary subject (e.g., username).
     *    - setIssuedAt(): The token creation date.
     *    - setExpiration(): When the token should expire.
     *    - signWith(): Sign the token with your secret key using HS256.
     */

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 4) Extract username from the token.
     *    - The 'sub' (subject) claim is used to store the username by default.
     */

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * 5) Extract any specific claim using a function.
     *    - For example, extracting 'sub', 'exp', or any custom claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 6) Check if the token is valid for a given username.
     *    - Compare token’s username with the provided username.
     *    - Ensure token is not expired.
     */
    public boolean isTokenValid(String token, String username){
        final String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * 7) Check if token has expired by comparing expiration date with current date.
     */
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * 8) Parse the token and retrieve all claims.
     *    - If the token is invalid or tampered with, it will throw an exception.
     */
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
