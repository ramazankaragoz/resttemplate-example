package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.entity.User;
import com.example.resttemplate.resttemplateexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ramazan Karagöz
 * @date 8/29/2019
 */

@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * POST
     * http://localhost:9090/rest-service/user/save
     *{
     *   "username":"40516901118",
     *   "password":"123123",
     *   "firstName":"Ramazan",
     *   "lastName":"Karagoz"
     * }
     *
     * POST
     *http://localhost:9090/rest-service/login
     * {
     *   "username":"40516901118",
     *   "password":"123123"
     * }
     *
     * GET
     * http://localhost:9090/rest-service/testException/saveData/1
     * Authorization Bearer eyJhbGciOiJIUzU
     *
     */
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<User> save(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreatedBy("developer");
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<User> update(@RequestBody User user){
        user.setCreatedBy("sadsa");
        return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
    }
}
