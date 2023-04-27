package com.deep.controller;

import com.deep.model.User;
import com.deep.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        Map<String, Object> map = new LinkedHashMap<>();
       try {
           User userList = this.userService.createUser(user);
           map.put("status",1);
           map.put("message", "user added successfully !");
//           map.put("data", userList);
           return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
       }catch (Exception e){
           map.clear();
           map.put("status",0);
           map.put("message", "User is already available !");
           return new ResponseEntity<>(map, HttpStatus.OK);
       }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId) ,HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        Map<String, Object> map = new LinkedHashMap<>();
        List<User> userList = userService.getAllUsers();
        Collections.sort(userList, (user1, user2) -> user1.getUsername().compareTo(user2.getUsername()));
        System.out.println(userList);
        try {
            map.put("status",1);
            map.put("message", "All users fetch successfully !");
            map.put("data", userList);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }catch (Exception e){
            map.clear();
            map.put("status",0);
            map.put("message","No user found !");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Map<String, Object> map = new LinkedHashMap<>();
        User users = userService.saveUser(user);
        map.put("status",1);
        map.put("message","User updated successfully !");
        map.put("data",users);
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            userService.deleteUser(userId);
            map.put("staus",1);
            map.put("message","User deleted successfully !");
            return new ResponseEntity(map, HttpStatus.OK);
        }catch (Exception e){
            map.clear();
            map.put("status",0);
            map.put("message", "User Not found !");
            return new ResponseEntity(map, HttpStatus.NOT_FOUND);
        }
    }
}