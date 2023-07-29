package com.deep.controller;

import com.deep.dto.UserDto;
import com.deep.entity.User;
import com.deep.exception.UserNotFoundException;
import com.deep.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/")
    String message(){
        logger.info("Inside the normal method controller !");
        return "This is normal method !";
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userRequest) {
        logger.info("Inside saveUser method of user controller !"+ userRequest.getUserId());
       try {
           UserDto userResponce = userService.createUser(userRequest);
           return new ResponseEntity<>(userResponce, HttpStatus.ACCEPTED);
       } catch (UserNotFoundException e) {
           return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        logger.info("Inside getUserByID method of user controller !");
        try {
            User user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        logger.info("Inside getAllUsers method of user controller !");
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            Set<UserDto> userList = userService.getAllUsers();
            map.put("status",1);
            map.put("message", "All users fetch successfully !");
            map.put("data", userList);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        logger.info("Inside updateUser method of user controller !");
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            User users = userService.saveUser(user);
            map.put("status",1);
            map.put("message","User updated successfully !");
            map.put("data",users);
            return new ResponseEntity(map,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
        logger.info("Inside deleteUserById method of user controller !");
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            User User = userService.deleteUser(userId);
            map.put("staus",1);
            map.put("message","User deleted successfully !");
            map.put("data",User);
            return new ResponseEntity(map, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  }