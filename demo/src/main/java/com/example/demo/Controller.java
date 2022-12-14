package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    /*
        @PostMapping("users")
        public User saveUser(@RequestBody User user){
            System.out.println("User saved");
            user.setPassword("");
            return user;
        }

        @PostMapping("usersAll")
        public List<User> saveAllUsers(@RequestBody List<User> users){
            System.out.println("All users saved ");
            users.forEach(user -> user.setPassword(""));
            return users;
            }

        */


    @GetMapping("/header")
    public String getHeader(@RequestHeader("myheader") String myheader){
        return "Your header is " + myheader;
    }

}



