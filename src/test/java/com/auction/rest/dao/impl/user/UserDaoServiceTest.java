package com.auction.rest.dao.impl.user;

import com.auction.rest.dao.impl.user.UserDao;
import com.auction.rest.dao.impl.user.UserDaoService;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.User;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.user.UserDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoServiceTest {
    private static SessionFactory factory;
    private static UserDaoService userDaoService;
    private static UserDao userDao;
    private static User user;

    @BeforeClass
    public static void SetUp() throws AuctionException {
        user = UserDaoData.getUser();
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        userDao = new UserDao(factory);
        userDaoService = new UserDaoService(userDao);
        userDaoService.addUser(user);
    }

    @Test
    public void testAddUser() throws AuctionException {
        user = UserDaoData.getUser();
        userDaoService.addUser(user);
        User insertedUser = userDaoService.getUser(user.getId());
        Assert.assertNotNull(insertedUser);
        Assert.assertEquals(insertedUser.getId(), Long.valueOf(user.getId()));
    }

    @Test
    public void testGetUser() throws AuctionException {
        User user = userDaoService.getUser(new Long(1));
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), Long.valueOf(1));
    }
}
