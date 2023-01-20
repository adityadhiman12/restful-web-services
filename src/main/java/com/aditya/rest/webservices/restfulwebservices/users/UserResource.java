package com.aditya.rest.webservices.restfulwebservices.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;
    public UserResource(UserDaoService userDaoService) {
        this.userDaoService=userDaoService;
    }

    //Get all users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.findAll();
    }

    //Get single user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }

    //create user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
