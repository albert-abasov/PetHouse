package ua.abasov.coursework.pethouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ua.abasov.coursework.pethouse.user.model.User;
import ua.abasov.coursework.pethouse.user.service.UserService;

import static ua.abasov.coursework.pethouse.user.model.UserRole.*;

@Component
public class UserRunner implements ApplicationRunner {
    private UserService userService;

    @Autowired
    public UserRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User admin = new User("admin", "admin",
                "admin@gmail.com", ADMIN);

        if (userService.loadUserByUsername("admin") == null) {
            userService.createUser(admin);
        }
    }
}
