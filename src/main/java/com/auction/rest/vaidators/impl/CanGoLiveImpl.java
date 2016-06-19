package com.auction.rest.vaidators.impl;

import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Auction;
import com.auction.rest.vaidators.CanGoLive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CanGoLiveImpl implements ConstraintValidator<CanGoLive, Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanGoLive.class);

    @Override
    public void initialize(CanGoLive canGoLive) {

    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        Auction auction = null;
        try {
            auction = auctionDaoService.getAuction(id);
        } catch (AuctionException e) {
            LOGGER.error("Exception while getting the auction in validator", e);
            e.printStackTrace();
        }
        if (auction.getIsLive()) {
            valid = false;
        }
        return valid;
    }
}
