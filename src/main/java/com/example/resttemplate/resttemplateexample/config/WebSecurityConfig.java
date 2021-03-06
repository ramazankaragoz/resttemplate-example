package com.example.resttemplate.resttemplateexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    //Kisaca burada hangi methodlara ve path’lere izin verdigimizi belirtiyoruz.
    // Oncelikle CORS’a izin verip CSRF’i disable ediyoruz.
    // Sonrasinda /sign-up path’ine POST request’e izin verip, geri kalan tum kaynaklar icin authentication bekledigimizi soyluyoruz.
    //Ardindan az once yarattigimiz iki Filter’i ekleyip, session olusturmayi kaldiriyoruz. Buni JWT ile saglayacagiz.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and().authorizeRequests()
                //.antMatchers(HttpMethod.PUT, "/user/update").permitAll()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers( "/rest-service/login").permitAll()
                .antMatchers( "/h2-console/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    //Cross Origin Resource Sharing(CORS) izinlerini set ediyoruz,
    // simdilik herhangi kaynaktan gelen requestlere izin verdik.
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        /**final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;*/

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.addAllowedHeader("*");
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.addAllowedMethod("*");
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS);
        web.ignoring().antMatchers("/static/**","/resources/**","/css/**","/images/**","/actuator/**");
    }
}
