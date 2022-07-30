package com.prank.spring.jpa.hibernate.controller;

import com.prank.spring.jpa.hibernate.models.UserInfo;
import com.prank.spring.jpa.hibernate.requests.CreateUserRequest;
import com.prank.spring.jpa.hibernate.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
//@RequestMapping("/api/v1")  //append this to all other mapping api
public class OnBoardingController implements InitializingBean, DisposableBean {

    /* View -> Controller -> Service -> CreateUserRequest(Creating UserInfo)
    *  -> UserRepository(Saving UserInfo)
    */

    @Autowired
    UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        // from InitializingBean
        log.info("OnBoardingController ---------> afterPropertiesSet");
    }

    @GetMapping("/test")
    public String getAllUsers(){
        log.info("OnBoardingController-----getAllUsers  Hello Moto: ");

        CreateUserRequest user = new CreateUserRequest();
        user.setName("test");
        user.setAddress("test Address");
        user.setEmail("test@mail.com");
        user.setPhoneNum(122333445);

        userService.createUser(user);
        return "Hello test Moto";
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE) //consumes not working here
    public ResponseEntity<List<UserInfo>> getAllUserInfo(){
        log.info("OnBoardingController-------> getAllUserInfo");
        ResponseEntity<List<UserInfo>> res =  new ResponseEntity<List<UserInfo>>(userService.getAllUserInfo(), HttpStatus.OK);
        return res;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<UserInfo>> getOneUserById(@RequestParam(name = "userId", defaultValue= "0") Integer id){
        log.info("OnBoardingController-------> getOneUserById");
        ResponseEntity<Optional<UserInfo>> res =  new ResponseEntity<Optional<UserInfo>>(userService.getOneUserById(id), HttpStatus.OK);
        return res;
    }

    //ResponseEntity is a wraparound to provide status code also
    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createAUser(@Valid @RequestBody CreateUserRequest user){
        log.info("OnBoardingController-------> create user request received user: "+user.getName());
        return new ResponseEntity<UserInfo>(userService.createUser(user), HttpStatus.ACCEPTED);
    }

    @Override
    public void destroy() throws Exception {
        log.info("OnBoardingController ---------> destroy");
    }
}
