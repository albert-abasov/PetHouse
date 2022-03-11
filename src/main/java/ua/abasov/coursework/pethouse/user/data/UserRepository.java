package ua.abasov.coursework.pethouse.user.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.abasov.coursework.pethouse.user.model.User;

import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUser(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    public User getUser(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?",
                    new BeanPropertyRowMapper<>(User.class), name);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    public User createUser(User user) {
        jdbcTemplate.update("INSERT INTO users(login, password, email, role)" +
                        "VALUES(?, ?, ?, cast(? as user_role))", user.getUsername(), user.getPassword(),
                user.getEmail(), user.getAuthorities().stream().findFirst().get().getAuthority());

        return user;
    }

    public User updateUser(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE users SET login = ?, password = ?, email = ?, role = cast(? as user_role)" +
                        "WHERE  id = ?", updatedUser.getUsername(), updatedUser.getPassword(), updatedUser.getEmail(),
                updatedUser.getAuthorities().stream().findFirst().get().getAuthority(), id);

        return updatedUser;
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
