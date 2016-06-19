package com.auction.rest.dao.impl.auction;

import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Item;
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

    public Auction updateAuction(Auction auction) {
        this.auctionDao.openCurrentSessionwithTransaction();
        Auction updatedAuction = this.auctionDao.updateAuction(auction);
        this.auctionDao.closeCurrentSessionwithTransaction();
        return updatedAuction;
    }

    public Auction getAuction(Long id) {
        this.auctionDao.openCurrentSession();
        Auction auction = this.auctionDao.getAuction(id);
        Item item = DaoUtils.getItemService().getItem(auction.getItemId());
        auction.setItem(item);
        this.auctionDao.closeCurrentSession();
        return auction;
    }

    public Auction makeAuctionLive(Long id) {
        this.auctionDao.openCurrentSessionwithTransaction();
        Auction auction = this.auctionDao.getAuction(id);
        auction.setIsLive(true);
        this.auctionDao.updateAuction(auction);
        this.auctionDao.closeCurrentSessionwithTransaction();
        return auction;
    }

    public Auction makeAuctionNotLive(Long id) {
        this.auctionDao.openCurrentSessionwithTransaction();
        Auction auction = this.auctionDao.getAuction(id);
        auction.setIsLive(false);
        this.auctionDao.updateAuction(auction);
        this.auctionDao.closeCurrentSessionwithTransaction();
        return auction;
    }


}
