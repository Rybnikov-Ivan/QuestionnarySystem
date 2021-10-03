package com.OpenCode.QuestionnarySystem.service;

import com.OpenCode.QuestionnarySystem.model.Role;
import com.OpenCode.QuestionnarySystem.model.User;
import com.OpenCode.QuestionnarySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) throws Exception {
        if (checkUniqueLogin(user)){
            user.setRole(Role.USER);
            return userRepository.save(user);
        } else {
            throw new Exception("Input Data Not valid");
        }
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    private boolean checkUniqueLogin(User user){
        List<User> users = userRepository.findAll();
        boolean check = false;
        for (User use:users){
            if (use.getUserLogin().trim().equals(user.getUserLogin().trim())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
