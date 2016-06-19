package com.auction.rest.dao.impl.bid;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Bid;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.auction.AuctionDaoData;
import com.auction.rest.testutils.data.bid.BidDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class BidDaoServiceTest {
    private static SessionFactory factory;
    private static BidDaoService bidDaoService;
    private static BidDao bidDao;
    private static Bid bid;

    @BeforeClass
    public static void SetUp() throws AuctionException {
        bid = BidDaoData.getBid();
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        bidDao = new BidDao(factory);
        bidDaoService = new BidDaoService(bidDao);
        bidDaoService.addBid(bid);
        for(Bid bid : BidDaoData.getBids()) {
            bidDaoService.addBid(bid);
        }
    }

    @Test
    public void testAddBid() throws AuctionException {
        bid = BidDaoData.getBid();
        bidDaoService.addBid(bid);
        Bid insertedBid = bidDaoService.getBid(bid.getId());
        Assert.assertNotNull(insertedBid);
        Assert.assertEquals(insertedBid.getPrice(), bid.getPrice());
    }

    @Test
    public void testRetrive() throws AuctionException {
        Bid bid = bidDaoService.getBid((long)1);
        Assert.assertNotNull(bid);
        Assert.assertTrue(bid.getId() == 1);
    }

    @Test
    public void testRetriveBidsForAuction() throws AuctionException {

        List<Bid> bids = bidDaoService.getBidsForAuction((long)0);
        Assert.assertEquals(bids.size(), 5);

    }

    @Test
    public void testRetriveBidsForAuctionAndUser() throws AuctionException {
        List<Bid> bids = bidDaoService.getBidsForUserAndAuction((long)0, (long)1);
        Assert.assertEquals(bids.size(), 5);
    }
}
