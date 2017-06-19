package dao;

import entity.Game;
import entity.Publisher;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 14.06.2017.
 */
public class GameDaoTest {
    @Test
    public void findByPublisher() throws Exception {
        GameDao gameDao = new GameDao();
        Game game = new Game();
        Publisher publisher = new Publisher();
        PublisherDao publisherDao = new PublisherDao();
        publisher.setName("test");
        publisherDao.save(publisher);
        game.setPublisher(publisher);
        gameDao.save(game);
        List<Game> byPublisher = gameDao.findByPublisher(publisher);
        System.out.println(byPublisher);
    }


    @Test
    public void findByReleaseDay() throws Exception {
        GameDao gameDao = new GameDao();
        Game game = new Game();
        game.setName("test");
        game.setReleaseDay(LocalDate.now());
        gameDao.save(game);
        List<Game> gameList = gameDao.findByReleaseDay(LocalDate.now());
        System.out.println(gameList);
        assertNotNull(gameList);

    }

//    private static SessionFactory SESSION_FACTORY;

    @Test
    public void findByNameTest() throws Exception {
        GameDao gameDao = new GameDao();
        Game game = new Game();
        game.setName("test");
        gameDao.save(game);
        Game fullInfo = gameDao.findByName("test");
        assertEquals(fullInfo.getName(), "test");
    }


}