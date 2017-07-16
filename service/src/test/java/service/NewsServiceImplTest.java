package service;

import entity.News;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lino on 16.07.2017.
 */
public class NewsServiceImplTest extends BaseTest{

    @Autowired
    private NewsService newsService;

    @Test
    public void getAll() throws Exception {
        News news = new News();
        newsService.save(news);
        newsService.getAll();
    }

    @Test
    public void findById() throws Exception {
        News news = new News();
        news.setName("test");
        news.setId(1L);
        newsService.save(news);
        newsService.findById(1L);
    }

    @Test
    public void save() throws Exception {
        News news = new News();
        news.setName("test");
        newsService.save(news);
    }

}