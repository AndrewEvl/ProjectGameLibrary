package dao;

import dao.daoImpl.GameDaoImpl;
import dao.daoImpl.GenreDaoImpl;
import dao.interfaceDao.GameDao;
import dao.interfaceDao.GenreDao;
import dao.interfaceDao.PublisherDao;
import entity.Game;
import entity.Genre;
import entity.Publisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 14.06.2017.
 */
public class GameDaoTest extends BaseTest {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private GenreDao genreDao;

    @Test
    public void findByPublisher() throws Exception {
        Game game = new Game();
        Publisher publisher = new Publisher();
        publisher.setName("test");
        publisherDao.save(publisher);
        game.setPublisher(publisher);
        gameDao.save(game);
        List<Game> byPublisher = gameDao.findByPublisher(publisher);
        System.out.println(byPublisher);
    }

    @Test
    public void findByGenre (){
        Game game = new Game();
        Genre genre = new Genre();
        genre.setName("test");
        genreDao.save(genre);
        game.setName("test");
        game.setGenre(genre);
        gameDao.save(game);
        List<Game> byGenre = gameDao.findByGenre(genre);
        System.out.println(byGenre);
    }



    @Test
    public void findByReleaseDay() throws Exception {
        Game game = new Game();
        game.setName("test");
        game.setReleaseDay(LocalDate.now());
        gameDao.save(game);
        List<Game> gameList = gameDao.findByReleaseDay(LocalDate.now());
        System.out.println(gameList);
        assertNotNull(gameList);

    }

    @Test
    public void findByNameTest() throws Exception {
        Game game = new Game();
        game.setName("test");
        gameDao.save(game);
        Game fullInfo = gameDao.findByName("test");
        assertEquals(fullInfo.getName(), "test");
    }


}