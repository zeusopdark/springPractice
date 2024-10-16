package com.springboot.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring.entities.User;
import com.springboot.spring.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void deleteUser(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("User not found with ID: " + id);
        }
    }

    public User updateUser(int id,User userDetails)throws Exception{
        Optional<User>user=userRepository.findById(id);
        if(user.isPresent()){
          User existingUser=user.get();

          if(userDetails.getName()!=null){
            existingUser.setName(userDetails.getName());
          }
          if (userDetails.getEmail() != null) {
            existingUser.setEmail(userDetails.getEmail());
        }
        if (userDetails.getData() != null) {
            existingUser.setData(userDetails.getData());
        }
        return userRepository.save(existingUser);
        }
        else{
            throw new Exception("User not found with id : "+id);
        }
    }
}
