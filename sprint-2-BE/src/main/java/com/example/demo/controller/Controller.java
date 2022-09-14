package com.example.demo.controller;


import com.example.demo.jwt.CustomUserDetail;
import com.example.demo.jwt.JWTTProvider;
import com.example.demo.model.order.Cart;
import com.example.demo.reponse.SignReponse;
import com.example.demo.repository.repositoryUser.IRepoUser;
import com.example.demo.request.SignForm;
import com.example.demo.service.ServiceProduct.IServiceProduct;
import com.example.demo.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class Controller {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IRepoUser iRepoUser;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTTProvider jwttProvider;
    @Autowired
    private IServiceProduct iServiceProduct;

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

    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct(){
        return new  ResponseEntity <>(iServiceProduct.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/findProductById")
    public ResponseEntity<?> getProduct(@RequestParam("id") Integer id){
        return new  ResponseEntity <>(iServiceProduct.findProductById(id), HttpStatus.OK);
    }
    @GetMapping("/searchProduct")
    public ResponseEntity<?> searchProduct(@RequestParam("idCategory") String id){
        System.out.println(id);
        return new  ResponseEntity <>(iServiceProduct.searchProduct(id), HttpStatus.OK);
    }

    @PostMapping("/addCart")
    public ResponseEntity<?> addCard(@RequestBody Cart cart){
        iCartService.createCart(cart);
        return new  ResponseEntity <>(  HttpStatus.OK);
    }
    @PostMapping("/subtractionCart")
    public ResponseEntity<?> subtractionCart(@RequestBody Cart cart){
        iCartService.subtractionCart(cart);
        return new  ResponseEntity <>( HttpStatus.OK);
    }
    @GetMapping("/ListCart")
    public ResponseEntity<?> addCard(){
        return new  ResponseEntity <>( iCartService.listCart(), HttpStatus.OK);
    }

    @PostMapping("/deleteCart")
    public ResponseEntity<?> deleteCart(@RequestBody Cart cart){
        iCartService.deleteCart(cart);
        return new  ResponseEntity <>( HttpStatus.OK);
    }
    @GetMapping("/searchProductCheckbox")
    public ResponseEntity<?> searchProductCheckbox(@RequestParam String id){
        return new  ResponseEntity <>( iServiceProduct.searchProduct(id),HttpStatus.OK);
    }


}
