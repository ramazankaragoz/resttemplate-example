package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import com.example.resttemplate.resttemplateexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     *   "username":"85244056914",
     *   "password":"123123",
     *   "firstName":"Ramazan",
     *   "lastName":"Karagoz"
     * }
     *
     * POST
     *http://localhost:9090/rest-service/login
     * {
     *   "username":"85244056914",
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
    public @ResponseBody ResponseEntity<ApplicationUser> save(@RequestBody ApplicationUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return new ResponseEntity<ApplicationUser>(userService.save(user), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody ResponseEntity<ApplicationUser> update(@RequestBody ApplicationUser user){
        return new ResponseEntity<ApplicationUser>(userService.update(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('DELETE_PRIVILEGE','TEST_PRIVILEGE','TEST1_PRIVILEGE')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        ApplicationUser applicationUser=new ApplicationUser();
        applicationUser.setId(id);
        userService.delete(applicationUser);
    }

    //@PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @GetMapping("/findAll")
    public ResponseEntity<List<ApplicationUser>> findAll(){
        userService.getPreAuthorities().stream().forEach(System.out::println);
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/findAllProxyService")
    public ResponseEntity<Void> findAllProxy(){
        userService.proxyProcess();

        return new ResponseEntity(Void.TYPE,HttpStatus.OK);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public void findByFirstName(@PathVariable(value = "firstName") String firstName){
        System.out.println(userService.getFirstName(firstName));

        System.out.println(userService.getByFirstName(firstName));
    }

}
