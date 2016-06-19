package com.auction.rest.vaidators.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.model.Auction;
import com.auction.rest.vaidators.CanGoLive;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CanGoLiveImpl implements ConstraintValidator<CanGoLive, Long> {

    @Override
    public void initialize(CanGoLive canGoLive) {

    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        Auction auction = auctionDaoService.getAuction(id);
        if (auction.getIsLive()) {
            valid = false;
        }
        return valid;
    }
}
