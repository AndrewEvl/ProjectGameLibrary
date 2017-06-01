package entities;

import entities.reviews.NewsComment;
import entities.reviews.ReviewGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

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

        Session session = SESSION_FACTORY.openSession();
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
        Transaction transaction = session.beginTransaction();

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
        game.getSystemSetting().add(systemSetting);
        game.getReviewGame().add(reviewGame);

        session.save(game);
        transaction.commit();
        session.close();

    }

    @Test
    public void testSaveGenre() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("test");
        assertEquals(genre.getId(), 1);
        assertEquals(genre.getName(), "test");

        transaction.commit();
        session.close();
    }


    @Test
    public void testSaveNews() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        News news = new News();
        NewsComment newsComment = new NewsComment();
        newsComment.setText("Test");
        session.save(newsComment);
        news.setId(1L);
        news.setDate(LocalDate.now());
        news.setName("test");
        news.setText("test");
        news.setDate(LocalDate.now());
        news.getNewsCommentSet().add(newsComment);
        news.toString();
        news.hashCode();

        transaction.commit();
        session.close();
    }

    @Test
    public void testSavePublisher() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("test");

        transaction.commit();
        session.close();
    }

    @Test
    public void testSavePlatform() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Platform platform = new Platform();
        platform.setId(1L);
        platform.setName("test");

        assertEquals(platform.getId(), 1);
        assertEquals(platform.getName(), "test");

        transaction.commit();
        session.close();
    }

    @Test
    public void testSaveReview() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ReviewGame reviewGames = new ReviewGame();
        reviewGames.setId(1L);
        reviewGames.setText("test");

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
