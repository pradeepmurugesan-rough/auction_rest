package com.auction.rest.dao.impl.item;

import com.auction.rest.model.Item;
import com.auction.rest.testutils.HibernateTestConfig;
import com.auction.rest.testutils.data.auction.AuctionDaoData;
import com.auction.rest.testutils.data.item.ItemDaoData;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemDaoServiceTest {
    private static SessionFactory factory;
    private static ItemDaoService itemDaoService;
    private static ItemDao itemDao;
    private static Item item;

    @BeforeClass
    public static void SetUp() {
        item = ItemDaoData.getItem();
        factory = new HibernateTestConfig().getUnitTestSessionFactory();
        itemDao = new ItemDao(factory);
        itemDaoService = new ItemDaoService(itemDao);
        itemDaoService.addItem(item);
    }

    @Test
    public void testAddItem() {
        item = ItemDaoData.getItem();
        itemDaoService.addItem(item);
        Item insertedItem = itemDaoService.getItem(item.getId());
        Assert.assertNotNull(insertedItem);
        Assert.assertEquals(insertedItem.getName(), "Rolex");
    }

    @Test
    public void testGetItem() {
        Item item = itemDaoService.getItem(new Long(1));
        Assert.assertNotNull(item);
        Assert.assertEquals(item.getName(), "Rolex");
    }
}
