package dao;

import entity.News;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 15.06.2017.
 */
public class NewsDaoTest {
    @Test
    public void getByDate() throws Exception {
        NewsDao newsDao = new NewsDao();
        News news = new News();
        news.setName("test");
        news.setDate(LocalDate.now());
        newsDao.save(news);
        System.out.println(news);
        List<News> newsList = newsDao.getByDate(LocalDate.now());
        System.out.println(newsList);
    }
}