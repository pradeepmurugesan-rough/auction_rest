package com.auction.rest.dao.impl.item;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Item;

public class ItemDaoService {
    private ItemDao itemDao;

    public ItemDaoService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Long addItem(Item item) throws AuctionException {
        this.itemDao.openCurrentSessionwithTransaction();
        Long id = this.itemDao.add(item);
        this.itemDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public Item getItem(Long id) throws AuctionException {
        this.itemDao.openCurrentSession();
        Item item = this.itemDao.getItem(id);
        this.itemDao.closeCurrentSession();
        return item;
    }
}
