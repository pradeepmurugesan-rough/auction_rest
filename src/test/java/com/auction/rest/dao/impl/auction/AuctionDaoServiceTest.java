package com.auction.rest.dao.impl.auction;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.auction.AuctionDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuctionDaoServiceTest {

    private static SessionFactory factory;
    private static AuctionDaoService auctionDaoService;
    private static AuctionDao auctionDao;
    private static Auction auction;
    private static Long auction_id;

    @BeforeClass
    public static void SetUp() throws AuctionException {
        auction_id = Long.valueOf(1);
        auction = AuctionDaoData.getAuction();
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        auctionDao = new AuctionDao(factory);
        auctionDaoService = new AuctionDaoService(auctionDao);
        auctionDaoService.addAuction(auction);
    }

    @Test
    public void testAddAuction() throws AuctionException {
        Long auctionId = ++auction_id;
        auction = AuctionDaoData.getAuction();
        auction.setId(auctionId);
        auctionDaoService.addAuction(auction);
        Auction insertedAuction = auctionDaoService.getAuction(auctionId);
        Assert.assertNotNull(insertedAuction);
        Assert.assertEquals(insertedAuction.getId(), auctionId);
    }
}
