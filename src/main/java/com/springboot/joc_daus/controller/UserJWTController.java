package com.springboot.joc_daus.controller;


import com.springboot.joc_daus.model.UserAdmin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserJWTController {

    @PostMapping("user")
    public UserAdmin login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        if (username.equals("admin") && pwd.equals("1234")) {
            String token = getJWTToken(username);
            UserAdmin userAdmin = new UserAdmin();
            userAdmin.setUser(username);
            userAdmin.setToken(token);
            return userAdmin;
        }else return null;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
