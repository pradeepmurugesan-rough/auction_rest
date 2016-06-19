package com.auction.rest.vaidators.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Bid;
import com.auction.rest.vaidators.CanBid;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CanBidImpl implements ConstraintValidator<CanBid, Bid> {
    @Override
    public void initialize(CanBid canBid) {

    }

    @Override
    public boolean isValid(Bid bid, ConstraintValidatorContext context) {
        boolean valid = true;
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        Auction auction = auctionDaoService.getAuction(bid.getAuctionId());
        Boolean isLive = auction.getIsLive();
        Double highestBid = auction.getHighestBid();
        if (isLive == null || !isLive ) {
            valid = false;
        } else if (highestBid != null && bid.getPrice() < highestBid) {
            valid = false;
            String errorMessage = "Sorry you are bit late on the bid for the price " + bid.getPrice();
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
        }
        return valid;
    }
}
