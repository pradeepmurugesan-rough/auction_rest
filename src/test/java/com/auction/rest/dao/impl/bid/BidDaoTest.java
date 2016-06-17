package com.auction.rest.dao.impl.bid;

import com.auction.rest.model.Bid;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.bid.BidDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class BidDaoTest {
    private static SessionFactory factory;
    private static Bid bid;
    private static Long bidId;

    @BeforeClass
    public static void setUpDb() {
        bidId = Long.valueOf(1);
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        bid = BidDaoData.getBid();
        BidDao bidDao = new BidDao(factory);
        bidDao.openCurrentSessionwithTransaction();
        Long id = bidDao.add(bid);
        bidDao.closeCurrentSessionwithTransaction();

        bidDao.openCurrentSessionwithTransaction();
        for(Bid bid : BidDaoData.getBids()) {
            bidDao.add(bid);
        }
        bidDao.closeCurrentSessionwithTransaction();
    }

    @Test
    public void testInsert() {
        bid = BidDaoData.getBid();
        bidId++;
        BidDao bidDao = new BidDao(factory);
        bidDao.openCurrentSessionwithTransaction();
        Long id = bidDao.add(bid);
        Bid insertedBid = bidDao.getBid(bid.getId());
        bidDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedBid);
        Assert.assertEquals(insertedBid.getPrice(), bid.getPrice());
    }

    @Test
    public void testRetrive() {
        BidDao bidDao = new BidDao(factory);
        bidDao.openCurrentSessionwithTransaction();
        Bid insertedBid = bidDao.getBid(Long.valueOf(1));
        bidDao.closeCurrentSessionwithTransaction();
        Assert.assertNotNull(insertedBid);
    }

    @Test
    public void testRetriveBidsForAuction() {

        BidDao bidDao = new BidDao(factory);
        bidDao.openCurrentSession();
        List<Bid> insertedBids = bidDao.getBidsOfAuction((long) 0);
        System.out.println(insertedBids.size());
        Assert.assertEquals(insertedBids.size(), 5);
        bidDao.closeCurrentSession();

    }

    @Test
    public void testRetriveBidsForAuctionAndUser() {
        BidDao bidDao = new BidDao(factory);
        bidDao.openCurrentSession();
        List<Bid> insertedBids = bidDao.getBidsOfUserAndAuction((long) 0, (long) 1);
        System.out.println(insertedBids.size());
        Assert.assertEquals(insertedBids.size(), 5);
        bidDao.closeCurrentSession();
    }
}
