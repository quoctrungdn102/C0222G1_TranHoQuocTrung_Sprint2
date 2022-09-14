package com.example.demo.repository.repositoryUser;


import com.example.demo.model.user1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoUser extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
