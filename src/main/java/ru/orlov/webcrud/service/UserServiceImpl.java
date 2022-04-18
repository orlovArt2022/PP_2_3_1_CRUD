package ru.orlov.webcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.orlov.webcrud.dao.UserDao;
import ru.orlov.webcrud.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User newUser) {
        userDao.editUser(newUser);
    }

    @Override
    @Transactional
    public User getByIdUser(Long id) {
        return userDao.getByIdUser(id);
    }
}
