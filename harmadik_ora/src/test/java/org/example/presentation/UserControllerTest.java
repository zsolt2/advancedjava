package org.example.presentation;

import org.example.service.User;
import org.example.service.UserService;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @org.junit.jupiter.api.Test
    void register_properInput(){
        // Az a kerdes ha csak egy validator van, ami mindig igazat ad vissza, akkor meghivodik-e a UserService
        // Given
        UserService userService = mock(UserService.class);
        //when(userService.save())
        NameValidator nameValidatorOK  = mock(NameValidator.class);
        when(nameValidatorOK.isValid(anyString())).thenReturn(true);

        List<NameValidator> nameValidatorList = new ArrayList();
        nameValidatorList.add(nameValidatorOK);


        UserController userController = new UserController(userService, nameValidatorList);

        String userName = "exapmleU serName";

        // When

        boolean rv = userController.register(userName);

        // Given
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());

    }

}

/*

class UserControllerTest {
    @org.junit.jupiter.api.Test
    void register_properInput()
        // Az a kerdes ha csak egy validator van, ami mindig igazat ad vissza, akkor meghivodik-e a UserService
        // Given
        UserService userService = mock(UserService.class);
        //when(userService.save())
        NameValidator nameValidatorOK  = mock(NameValidator.class);
        when(nameValidatorOK.isValid(anyString())).thenReturn(true);

        List<NameValidator> nameValidatorList = new ArrayList();
        nameValidatorList.add(nameValidatorOK);


        UserController userController = new UserController(userService);

        String userName = "exapmleU serName";

        // When

        boolean rv = userController.register(userName);

        // Given
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatcher.<User>any());

    }
    void register_input_without_spaces(){
        // Given
        UserService userService = mock(UserService.class);
        //when(userService.save())
        UserController userController = new UserController(userService);

        String userName = "exapmleUserName";

        // When

        boolean rv = userController.register(userName);

        // Given
        assertTrue(false);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());

    }
    void register_short_input(){
        // Given
        UserService userService = mock(UserService.class);
        //when(userService.save())
        UserController userController = new UserController(userService);

        String userName = "exap";

        // When

        boolean rv = userController.register(userName);

        // Given
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());

    }
    void register_properInput(){
        // Given
        UserService userService = mock(UserService.class);
        //when(userService.save())
        UserController userController = new UserController(userService);

        String userName = "exapmleUserName";

        // When

        boolean rv = userController.register(userName);

        // Given
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());

    }
}


* */