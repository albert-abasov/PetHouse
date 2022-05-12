package ua.abasov.coursework.pethouse.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.abasov.coursework.pethouse.user.dto.UserDto;
import ua.abasov.coursework.pethouse.user.model.User;
import ua.abasov.coursework.pethouse.user.model.UserRole;
import ua.abasov.coursework.pethouse.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());

        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @PatchMapping("/{id}")
    public User updatePartOfUser(@PathVariable int id, @RequestBody User updatedUser) {
        return userService.updatePartOfUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
