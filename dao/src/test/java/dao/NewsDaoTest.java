package dao;

import dao.daoImpl.NewsDaoImpl;
import entity.News;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 15.06.2017.
 */
public class NewsDaoTest {
    @Test
    public void getByDate() throws Exception {
        NewsDaoImpl newsDao = new NewsDaoImpl();
        News news = new News();
        news.setName("test");
        news.setDate(LocalDate.now());
        newsDao.save(news);
        System.out.println(news);
        List<News> newsList = newsDao.getByDate(LocalDate.now());
        System.out.println(newsList);
    }
}