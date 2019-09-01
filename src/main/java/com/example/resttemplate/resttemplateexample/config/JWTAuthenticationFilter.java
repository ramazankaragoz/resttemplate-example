package com.example.resttemplate.resttemplateexample.config;

import com.example.resttemplate.resttemplateexample.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//Login olan kullanıcılara JWT assign etmek için Authentication Filter
//Bu sınıfımızın iki görevi var.
// Başarılı login’lere JWT atama ve yeni authorized requestlerin JWT’sini kontrol etme.
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    //gelen request’teki Header’i parse edip Token’i alıyoruz.
    // Ardından UsernamePasswordAuthenticationToken sınıfının bir nesnesini oluşturup JWT’mizi set ediyoruz.
    // Nesnesini oluşturduğumuz bu sınıf kullanıcı adı ve parolayı saklar.
    // getCredentials() ve getPrinciples() methodları ile bunlara erişebiliriz.
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            User user=new ObjectMapper().readValue(request.getInputStream(),User.class);

            return  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),new ArrayList<>())
            );

        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    //succesfulAuthentication ile başarılı bir şekilde login olmuş kullanıcıya JWT yollayacağız.
    // Bunun için Jwts sınıfının builder() methodu ile Payload kısmı için subject ve expiration time’i set edip,
    // kendi tanımladığımız SECRET ile imzalayıp Tokenimizi oluşturuyoruz ve Header’a ekliyoruz.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        String token= Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User)authResult.getPrincipal()).getUsername().toString())
                .setExpiration(new Date(System.currentTimeMillis()+JWTSecurityConstant.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,JWTSecurityConstant.SECRET.getBytes()).compact();

        response.addHeader(JWTSecurityConstant.HEADER_STRING,JWTSecurityConstant.TOKEN_PREFIX+token);

    }
}
