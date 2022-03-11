package ua.abasov.coursework.pethouse.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.abasov.coursework.pethouse.user.data.UserRepository;
import ua.abasov.coursework.pethouse.user.model.User;
import ua.abasov.coursework.pethouse.user.model.UserRole;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUser(username);
    }

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.createUser(user);
    }

    public User updateUser(int id, User updatedUser) {
        return userRepository.updateUser(id, updatedUser);
    }

    public User updatePartOfUser(int id, User updatedUser) {
        User user = userRepository.getUser(id);

        if (updatedUser.getUsername() != null) {
            user.setLogin(updatedUser.getUsername());
        }

        if (updatedUser.getPassword() != null) {
            user.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getEmail() != null) {
            user.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getAuthorities() != null) {
            user.setRole((UserRole) updatedUser.getAuthorities().stream().findFirst().get());
        }

        userRepository.updateUser(id, user);
        return user;
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
