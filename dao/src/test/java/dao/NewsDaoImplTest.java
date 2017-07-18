package dao;

import dao.interfaceDao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lino on 17.07.2017.
 */
public class NewsDaoImplTest extends BaseTest {

    @Autowired
    private final NewsDao newsDao;

    public NewsDaoImplTest(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

}