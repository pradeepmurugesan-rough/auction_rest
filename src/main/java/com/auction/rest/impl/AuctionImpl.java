package com.auction.rest.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Id;

public class AuctionImpl {

    private AuctionDaoService auctionDaoService;

    public AuctionImpl(AuctionDaoService auctionDaoService) {
        this.auctionDaoService = auctionDaoService;
    }

    public Id addAuction(Auction auction) {
        Long id = this.auctionDaoService.addAuction(auction);
        return new Id(id);
    }

    public Auction getAuction(Long id) {
        Auction auction = this.auctionDaoService.getAuction(id);
        return auction;
    }

    public Auction makeAuctionLive(Long id) {
        Auction auction = this.auctionDaoService.makeAuctionLive(id);
        return auction;
    }
}
