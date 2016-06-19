package com.auction.rest.dao.impl.user;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.User;

import java.util.List;

public class UserDaoService {
    private UserDao userDao;

    public UserDaoService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long addUser(User user) throws AuctionException {
        this.userDao.openCurrentSessionwithTransaction();
        Long id = this.userDao.add(user);
        this.userDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public User getUser(Long id) throws AuctionException {
        this.userDao.openCurrentSession();
        User user = this.userDao.getUser(id);
        this.userDao.closeCurrentSession();
        return user;
    }

    public List<User> getAllUsers() throws AuctionException {
        this.userDao.openCurrentSession();
        List<User> users = this.userDao.getUsers();
        this.userDao.closeCurrentSession();
        return users;
    }
}
