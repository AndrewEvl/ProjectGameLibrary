package dao.daoImpl;

import dao.interfaceDao.PublisherDao;
import dao.common.BaseDaoImpl;
import entity.Publisher;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class PublisherDaoImpl extends BaseDaoImpl<Publisher> implements PublisherDao {
}
