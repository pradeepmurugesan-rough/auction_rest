package com.auction.rest.vaidators.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Bid;
import com.auction.rest.vaidators.CanBid;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CanBidImpl implements ConstraintValidator<CanBid, Bid> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanBidImpl.class);

    @Override
    public void initialize(CanBid canBid) {

    }

    @Override
    public boolean isValid(Bid bid, ConstraintValidatorContext context) {
        boolean valid = true;
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        Auction auction = null;
        try {
            auction = auctionDaoService.getAuction(bid.getAuctionId());
        } catch (AuctionException e) {
            LOGGER.error("Exception while getting the auction in validator", e);
        }
        Boolean isLive = auction.getIsLive();
        Double highestBid = auction.getHighestBid();
        if (isLive == null || !isLive ) {
            valid = false;
        } else if (highestBid != null && bid.getPrice() <= highestBid) {
            valid = false;
            String errorMessage = "Sorry you are bit late on the bid for the price " + bid.getPrice();
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
        }
        return valid;
    }
}
