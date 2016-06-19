package com.auction.rest.dao.impl.auction;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.auction.AuctionDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuctionDaoTest {

    private static SessionFactory factory;
    private static Auction auction;
    private static Long auctionId;

    @BeforeClass
    public static void setUpDb() throws AuctionException {
        auctionId = Long.valueOf(1);
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        auction = AuctionDaoData.getAuction();
        AuctionDao auctionDao = new AuctionDao(factory);
        auctionDao.openCurrentSessionwithTransaction();
        Long id = auctionDao.add(auction);
        auctionDao.closeCurrentSessionwithTransaction();
    }

    @Test
    public void testInsert() throws AuctionException {
        auction = AuctionDaoData.getAuction();
        auctionId++;
        AuctionDao auctionDao = new AuctionDao(factory);
        auctionDao.openCurrentSessionwithTransaction();
        auctionDao.add(auction);
        Auction insertedAuction = auctionDao.getAuction(auction.getId());
        auctionDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedAuction);
        Assert.assertEquals(insertedAuction.getChannel(), auction.getChannel());
    }

    @Test
    public void testRetrive() throws AuctionException {
        AuctionDao auctionDao = new AuctionDao(factory);
        auctionDao.openCurrentSessionwithTransaction();
        Auction insertedAuction = auctionDao.getAuction(Long.valueOf(1));
        auctionDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedAuction);
        Assert.assertEquals(insertedAuction.getId(), Long.valueOf(1));
    }
}
