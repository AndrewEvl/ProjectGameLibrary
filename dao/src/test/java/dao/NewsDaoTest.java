package dao;

import dao.interfaceDao.NewsDao;
import entity.News;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 15.06.2017.
 */
public class NewsDaoTest extends BaseTest {

    @Autowired
    private NewsDao newsDao;

    @Test
    public void getByDate() throws Exception {
        News news = new News();
        news.setName("test");
        news.setDate(LocalDate.now());
        newsDao.save(news);
        System.out.println(news);
        List<News> newsList = newsDao.getByDate(LocalDate.now());
        System.out.println(newsList);
    }
}