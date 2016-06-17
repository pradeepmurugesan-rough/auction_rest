package com.auction.rest.testutils.data.user;

import com.auction.rest.model.Item;
import com.auction.rest.model.User;

public class UserDaoData {
    public static User getUser() {
        User user = new User();
        user.setName("John");
        user.setLocation("Chennai");
        return user;
    }
}
