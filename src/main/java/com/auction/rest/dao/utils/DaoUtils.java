package com.auction.rest.dao.utils;

import com.auction.rest.dao.config.HibernateConfig;
import com.auction.rest.dao.impl.auction.AuctionDao;
import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.impl.bid.BidDao;
import com.auction.rest.dao.impl.bid.BidDaoService;
import com.auction.rest.dao.impl.item.ItemDao;
import com.auction.rest.dao.impl.item.ItemDaoService;
import com.auction.rest.dao.impl.user.UserDao;
import com.auction.rest.dao.impl.user.UserDaoService;

public class DaoUtils {

    public static ItemDaoService getItemService() {
        ItemDao itemDao = new ItemDao(HibernateConfig.getSessionFactory());
        ItemDaoService itemDaoService = new ItemDaoService(itemDao);
        return itemDaoService;
    }

    public static AuctionDaoService getAuctionService() {
        AuctionDao auctionDao = new AuctionDao(HibernateConfig.getSessionFactory());
        AuctionDaoService auctionDaoService = new AuctionDaoService(auctionDao);
        return auctionDaoService;
    }

    public static UserDaoService getUserService() {
        UserDao userDao = new UserDao(HibernateConfig.getSessionFactory());
        UserDaoService userDaoService = new UserDaoService(userDao);
        return userDaoService;
    }

    public static BidDaoService getBidService() {
        BidDao bidDao = new BidDao(HibernateConfig.getSessionFactory());
        BidDaoService bidDaoService = new BidDaoService(bidDao);
        return bidDaoService;
    }
}
