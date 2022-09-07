package com.example.demo.controller;


import com.example.demo.jwt.CustomUserDetail;
import com.example.demo.jwt.JWTTProvider;
import com.example.demo.reponse.SignReponse;
import com.example.demo.repository.IRepoUser;
import com.example.demo.request.SignForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private IRepoUser iRepoUser;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTTProvider jwttProvider;

    @PostMapping("/sign")
    public ResponseEntity<?> login(@RequestBody SignForm signForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signForm.getUserName(), signForm.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwttProvider.createToken(authentication);
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        SignReponse signReponse = new SignReponse(token,customUserDetail.getUsername(),customUserDetail.getAuthorities());

        return new  ResponseEntity <>(signReponse, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(){
        return new  ResponseEntity <>(iRepoUser.findAll(), HttpStatus.OK);
    }

}
