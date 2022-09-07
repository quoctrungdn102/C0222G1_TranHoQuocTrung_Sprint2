package com.example.demo.jwt;


import com.example.demo.model.user1.User;
import com.example.demo.repository.IRepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IRepoUser iRepoUser;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  iRepoUser.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("could not find "+username);
        }

        return new CustomUserDetail(user);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = "1234";
        bCryptPasswordEncoder.encode(pass);
        System.out.println( bCryptPasswordEncoder.encode(pass));
    }

}
