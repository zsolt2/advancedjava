package org.example.secondExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Map User to UserDto
        // The dto does not need every data that the User provides.
        List<User> userList = new ArrayList<>();
        List<UserDto> userDtoList = userList.stream().map(user -> new UserDto(user)).collect(Collectors.toList())

    }
}
