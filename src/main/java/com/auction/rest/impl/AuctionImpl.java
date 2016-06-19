package com.auction.rest.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Id;
import com.auction.rest.model.Item;
import com.auction.rest.util.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuctionImpl {

    private AuctionDaoService auctionDaoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionImpl.class);

    public AuctionImpl(AuctionDaoService auctionDaoService) {
        this.auctionDaoService = auctionDaoService;
    }

    public Id addAuction(Auction auction) throws AuctionException {
        LOGGER.debug("Adding the auction " + JsonConverter.objectToJson(auction));
        Long id = this.auctionDaoService.addAuction(auction);
        return new Id(id);
    }

    public Auction getAuction(Long id) throws AuctionException {
        Auction auction = this.auctionDaoService.getAuction(id);
        Item item = DaoUtils.getItemService().getItem(auction.getItemId());
        auction.setItem(item);
        return auction;
    }

    public Auction makeAuctionLive(Long id) throws AuctionException {
        Auction auction = this.auctionDaoService.makeAuctionLive(id);
        return auction;
    }
}
