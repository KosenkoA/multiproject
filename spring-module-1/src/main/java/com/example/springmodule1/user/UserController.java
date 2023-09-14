package com.example.springmodule1.user;

import org.example.SharedTestClass;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    can be used to test if the SharedTestClass is accessible from spring-module-1
    //    can be accessed at http://localhost:8080/api/users/hello
    //    to run application:
    //    build spring-module-1 via gradle task bootJar,
    //    make sure you have docker running,
    //    then run docker-compose up spring-module-1 in the root directory
    //    then access http://localhost:8080/api/users/hello
    @GetMapping("/hello")
    public String hello() {
        SharedTestClass sharedTestClass = new SharedTestClass(); // This is a test to see if the SharedTestClass is accessible from spring-module-1
        SharedTestClass.helloWorld(new String[]{});
        return "Hello World!";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            User newUser = new User();
            newUser.setName("User not found");
            newUser.setEmail("Email not found");
            newUser.setId(-1L);
            return newUser;
        }
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userRepository.findById(id).isPresent()) {
            User existingUser = userRepository.findById(id).get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        } else {
            User newUser = new User();
            newUser.setName("User not found");
            newUser.setEmail("Email not found");
            newUser.setId(-1L);
            return newUser;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            if (userRepository.findById(id).isPresent()) {
                userRepository.findById(id).get();
                userRepository.deleteById(id);
                return "User deleted successfully";
            } else {
                return "User not found";
            }
        } catch (Exception e) {
            return "User not found";
        }
    }

}
