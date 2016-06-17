package com.auction.rest.dao.impl.auction;

import com.auction.rest.model.Auction;
import org.hibernate.SessionFactory;

public class AuctionDaoService {
    private AuctionDao auctionDao;

    public AuctionDaoService(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public Long addAuction(Auction auction) {
        this.auctionDao.openCurrentSessionwithTransaction();
        Long id = this.auctionDao.add(auction);
        this.auctionDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public Auction getAuction(Long id) {
        this.auctionDao.openCurrentSession();
        Auction auction = this.auctionDao.getAuction(id);
        this.auctionDao.closeCurrentSession();
        return auction;
    }
}
