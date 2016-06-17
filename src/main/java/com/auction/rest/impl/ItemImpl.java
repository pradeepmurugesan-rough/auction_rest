package com.auction.rest.impl;

import com.auction.rest.dao.impl.item.ItemDaoService;
import com.auction.rest.model.Id;
import com.auction.rest.model.Item;

public class ItemImpl {

    private ItemDaoService itemDaoService;

    public ItemImpl(ItemDaoService itemDaoService) {
        this.itemDaoService = itemDaoService;
    }

    public Id addItem(Item item) {
        Long id = itemDaoService.addItem(item);
        return new Id(id);
    }

    public Item getItem(Long id) {
        return itemDaoService.getItem(id);
    }
}
