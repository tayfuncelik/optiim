package com.example.user.service;

import com.example.user.dao.UserDao;
import com.example.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.Serializable;

@Component
@Transactional
public class UserService implements Serializable {

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public User getUser(Long id) {
        User u = null;
        try {
            u = userDao.getOne(id);
        } catch (Exception e) {
            LOG.error("exception while get by id", e);
        }
        return u;
    }

    public void addUser(User user) {
        User us = userDao.getUserByEmail(user.getEmail());
        if (us != null) {
            userDao.updateUser(user.getName(), user.getLastName(), user.getEmail());
        } else {
            userDao.save(user);
        }
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.save(user);
    }
}
