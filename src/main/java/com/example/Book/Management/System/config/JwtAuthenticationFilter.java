package com.example.Book.Management.System.config;

import com.example.Book.Management.System.security.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    // Constructor to inject JwtUtil and UserDetailsService
    public JwtAuthenticationFilter (JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService){
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1. Get the authorization header from the request
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        //2. Check if the header is present and starts with "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);//Remove the "Bearer " prefix
            try{
                //3. Extract the username from the token using JwtUtil
                username = jwtUtil.extractUsername(token);
            }catch (Exception e){
                //Log or handle token parsing exception (token might be invalid)
                System.out.println("Could not extract username from token: "+ e.getMessage());
            }
        }
        //4. If username is found and SecurityContext is empty, validate the token.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            //Load user details from the database (via your CustomUserDetailsService)
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
            //5. validate the token
            if (jwtUtil.isTokenValid(token,username)){
                //6. Create an authentication token and set it in the SecurityContext
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //7. Continue the Filter chain (allow the request to proceed)
        filterChain.doFilter(request, response);
    }
}
