package entities;

import entities.reviews.ReviewGame;
import entities.systemParts.Cpu;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.Set;

import static org.junit.Assert.assertEquals;


/**
 * Created by User on 24.05.2017.
 */
public class EntityTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveDeveloper() {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = new Developer();
        developer.setName("Test");
        developer.setId(1L);

        assertEquals(developer.getName(), "Test");
        assertEquals(developer.getId(), 1);

        transaction.commit();
        session.close();
    }

    @Test
    public void testSaveGame() {
        Session session = SESSION_FACTORY.openSession();

        Game game = new Game();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        ReviewGame reviewGame = new ReviewGame();
        SystemSetting systemSetting = new SystemSetting();
        reviewGame.setText("Test");
        reviewGame.setGame(game);
        publisher.setName("Test");
        genre.setName("Test");
        developer.setName("Test");
        session.save(systemSetting);
        session.save(reviewGame);
        session.save(developer);
        session.save(publisher);
        session.save(genre);
        game.setName("test");
        game.setGenre(genre);
        game.setDeveloper(developer);
        game.setPublisher(publisher);
//        game.setSystemSetting((Set<SystemSetting>) systemSetting);
//        game.setReviewGame((Set<ReviewGame>) reviewGame);
        session.save(game);


        session.close();

    }

    @Test
    public void testSaveGenre() {
        Session session = SESSION_FACTORY.openSession();

        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("test");
        assertEquals(genre.getId(), 1);
        assertEquals(genre.getName(), "test");

        session.close();
    }

    //
////    @Test
////    public void testSaveNews() {
////        Session session = SESSION_FACTORY.openSession();
////
////        News news = new News();
////        news.setId(1L);
////        news.setName("test");
////        news.setText("test");
////        assertEquals(news.getId(), 1);
////        assertEquals(news.getName(), "test");
////        assertEquals(news.getText(), "test");
////
////        session.close();
////    }
//
    @Test
    public void testSavePublisher() {
        Session session = SESSION_FACTORY.openSession();

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("test");

//        assertEquals(publisher.getId(), 1);
//        assertEquals(publisher.getName(), "test");

        session.close();
    }

    @Test
    public void testSavePlatform() {
        Session session = SESSION_FACTORY.openSession();

        Platform platform = new Platform();
        platform.setId(1L);
        platform.setName("test");

        assertEquals(platform.getId(), 1);
        assertEquals(platform.getName(), "test");

        session.close();
    }

    @Test
    public void testSaveReview() {
        Session session = SESSION_FACTORY.openSession();

        ReviewGame reviewGames = new ReviewGame();
        reviewGames.setId(1L);
        reviewGames.setText("test");

//        assertEquals(reviewGames.getId(),1L);
//        assertEquals(reviewGames.getText(), "test");

        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
