package dao;

import entity.Game;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 14.06.2017.
 */
public class GameDaoTest {


    @Test
    public void findByReleaseDay() throws Exception {
        GameDao gameDao = new GameDao();
        Game game = new Game();
        game.setName("test");
        game.setReleaseDay(LocalDate.now());
        gameDao.save(game);
        List<Game> gameList = gameDao.findByReleaseDay(LocalDate.now());
        assertNotNull(gameList);

    }

//    private static SessionFactory SESSION_FACTORY;

    @Test
    public void findByNameTest() throws Exception {
        GameDao gameDao = new GameDao();
        Game game = new Game();
        game.setName("test");
        gameDao.save(game);
        Game byId = gameDao.findById(1L);
        System.out.println(byId);
        Game fullInfo = gameDao.findByName("test");
        System.out.println(fullInfo);
    }


}