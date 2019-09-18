package com.example.resttemplate.resttemplateexample.config;

import com.example.resttemplate.resttemplateexample.service.UserDetailsServiceImpl;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.resttemplate.resttemplateexample.config.JWTSecurityConstant.TOKEN_PREFIX;



//Authenticated kullanıcıların yeni requstlerindeki JWT’leri validate etmek için Authorization Filter
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    //Bu method, korunan bir kaynağa request geldiğinde bu request’i yakalar,
    // JWT’yi validate eder ve herşey uygunsa kullanıcı authentication bilgilerini SecurityContextHolder ile SecurityContext’in içine yazar
    // ve kaynağı client’a sunar.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header=request.getHeader(JWTSecurityConstant.HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }


    //Authorization Header’ından JWT değerini okur ve token’in geçerliliğini onaylar.
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JWTSecurityConstant.HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(JWTSecurityConstant.SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, UserDetailsServiceImpl.roleList);
            }
            return null;
        }
        return null;
    }
}
