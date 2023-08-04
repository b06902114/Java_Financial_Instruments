package Esun.demo.controller;

import Esun.demo.model.User;
import Esun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;

    // add user

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user){

           User check = userService.addUser(user);

           if(check.getName() != null) {
               return "ADD SUCCESSFULLY";
           }
           else{
               return "TYPE SOMETHING WRONG OR YOU ARE ALREADY REGISTER";
           }




    }

    // get User by ID
    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);

    }

    // get Users
    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    // update
    @PutMapping("/user_update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    // delete User by id
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
    }

    // GET USERS BY STORED PROCEDURE
    @RequestMapping("/users/procedure/{id}/{sn}")
    public List<User> getUsersByProcedure(@PathVariable("id") String id, @PathVariable("sn") String sn){
        return userService.getUsersByProcedure(id, sn);
    }
}
