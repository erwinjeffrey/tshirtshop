package com.turing.tshirtshop.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turing.tshirtshop.entities.Customer;
import com.turing.tshirtshop.models.ResponseLogin;
import com.turing.tshirtshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.turing.tshirtshop.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private CustomerRepository customerRepository;

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx){
        this.authenticationManager = authenticationManager;
        this.customerRepository = ctx.getBean(CustomerRepository.class);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
       try {
           Customer creds = new ObjectMapper()
                   .readValue(request.getInputStream(), Customer.class);

           return authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           creds.getEmail(),
                           creds.getPassword(),
                           new ArrayList<>()
                   )
           );

       }catch(IOException e){
           throw new RuntimeException(e);
       }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

        ObjectMapper mapper = new ObjectMapper();

        ResponseLogin responseLogin = new ResponseLogin();
        String username = ((User) authResult.getPrincipal()).getUsername();
        Customer customer = customerRepository.findByEmail(username);
        responseLogin.setCustomer(customer);
        responseLogin.setAccessToken(TOKEN_PREFIX + token);
        responseLogin.setExpiresIn("24h");

        response.getWriter().append(mapper.writeValueAsString(responseLogin));
        response.setContentType("application/json");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }


}
