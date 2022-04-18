package ru.orlov.webcrud.dao;

import ru.orlov.webcrud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User newUser);

    User getByIdUser(Long id);
}
