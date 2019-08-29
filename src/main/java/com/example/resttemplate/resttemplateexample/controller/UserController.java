package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.entity.User;
import com.example.resttemplate.resttemplateexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<User> save(@RequestBody User user){
        user.setCreatedBy("developer");
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<User> update(@RequestBody User user){
        user.setCreatedBy("sadsa");
        return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
    }
}
