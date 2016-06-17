package com.auction.rest.dao.impl.item;

import static com.auction.rest.dao.utils.DaoConstants.Query.Item.GET_ITEM_BY_ID;
import static com.auction.rest.dao.utils.DaoConstants.QueryParameters.ID;

import com.auction.rest.dao.AbstractDao;
import com.auction.rest.model.Item;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class ItemDao extends AbstractDao{
    public ItemDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long add(Item item) {
        getCurrentSession().save(item);
        return item.getId();
    }

    public Item getItem(Long id) {
        Query query = getCurrentSession().createQuery(GET_ITEM_BY_ID);
        query.setParameter(ID, id);
        return (Item) query.uniqueResult();
    }
}
