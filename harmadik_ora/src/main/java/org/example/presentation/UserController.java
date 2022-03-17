package org.example.presentation;

import org.example.service.User;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final UserService userService;
    private final List<NameValidator> nameValidatorList;

    public UserController(UserService userService, List<NameValidator> nameValidatorList) {
        this.userService = userService;
        this.nameValidatorList = nameValidatorList;
    }

    public boolean register(String name){

        if ( isValid(name)){
            userService.save(new User(name));
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid(String username){
        for(NameValidator nameValidator: nameValidatorList){
            if(!nameValidator.isValid(username))
                return false;
        }
        return true;
    }
}
