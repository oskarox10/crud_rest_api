package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestContoller {

    @Autowired
    private Repository repository;


    @PostMapping("/user")
    public User saveUser(@RequestBody User theUser){

        User dbUser = repository.save(theUser);

        return dbUser;
    }


    @GetMapping("/user")
    public List<User> findAll(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id){

        Optional<User> theUser = repository.findById(id);


        if (theUser == null){
            throw new RuntimeException("Not found" + id);
        }
        return theUser;

    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User theUser){
        User dbUser = repository.save(theUser);

        return dbUser;
    }



    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        repository.deleteById(id);

        return "User deleted: " + id;
    }


}

