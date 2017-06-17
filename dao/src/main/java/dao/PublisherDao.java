package dao;

import entity.Publisher;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 15.06.2017.
 */
public class PublisherDao extends BaseDao<Publisher>{

    public PublisherDao() {
        super(Publisher.class);
    }
}
