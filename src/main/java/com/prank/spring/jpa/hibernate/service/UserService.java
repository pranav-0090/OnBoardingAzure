package com.prank.spring.jpa.hibernate.service;

import com.prank.spring.jpa.hibernate.Repository.UserRepository;
import com.prank.spring.jpa.hibernate.models.UserInfo;
import com.prank.spring.jpa.hibernate.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service //alias of component only
public class UserService {

    @Autowired
    UserRepository userRepo;

    public UserInfo createUser(@Valid CreateUserRequest userRequest){

        //Convert userRequest(without id) to UserInfo(with id auto incremented from db)
        UserInfo user = userRequest.toUser();
        userRepo.save(user); //save takes UserInfo annotated with @Entity as input

        return user;
    }

    public List<UserInfo> getAllUserInfo(){
        return userRepo.findAll();
    }

    public Optional<UserInfo> getOneUserById(Integer id){
        return userRepo.findById(id);
    }
}
