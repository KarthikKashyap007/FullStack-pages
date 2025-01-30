//package com.example.demo.controller;
//
//import com.example.demo.exception.UserNotFoundException;
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.nio.file.attribute.UserPrincipalNotFoundException;
//import java.util.List;
//
//@RestController
//@CrossOrigin("http://localhost:5173")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/user")
////    @CrossOrigin("http://localhost:5173")
//    User newUser(@RequestBody User newUser){
//        return userRepository.save(newUser);
//    }
//    @GetMapping("/users")
////    @CrossOrigin("http://localhost:5173")
//    List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//    @GetMapping("/users/{id}")
////    @CrossOrigin("http://localhost:5173")
//    User getUserById(@PathVariable Long id){
//        return userRepository.findById(id)
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
//
//    @CrossOrigin("http://localhost:5173")
//    @PutMapping("/users/{id}")
//    User updateUser(@RequestBody User newUser,@PathVariable Long id){
//        return  userRepository.findById(id)
//                .map(user ->{
//                    user.setUsername(newUser.getUsername());
//                    user.setName(newUser.getName());
//                    user.setEmail(newUser.getEmail());
//                    return userRepository.save(user);
//                }).orElseThrow(()-> new UserNotFoundException(id));
//    }
//
//    @DeleteMapping("/user/{id}")
//   @CrossOrigin("http://localhost:5173")
//    String deleteUser(@PathVariable Long id){
//        if(!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//        return "User with id "+ id+ "has been deleted.";
//
//    }
//
//}

package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.userService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private userService userService;

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.updateUser(id, newUser);
    }

//    @DeleteMapping("/user/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return "User with id " + id + " has been deleted.";
//    }
//}
    @DeleteMapping("/user/{id}")
    @CrossOrigin("http://localhost:5173")
     public String deleteUser(@PathVariable Long id) {
//        if(!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//
        return userService.deleteUser(id);
    }

    }

