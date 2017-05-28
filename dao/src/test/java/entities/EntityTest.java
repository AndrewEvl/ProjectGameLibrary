package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;
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

        Developer developer = new Developer();
        developer.setName("Test");
        developer.setId(1L);

        assertEquals(developer.getName(), "Test");
        assertEquals(developer.getId(), 1);

        session.close();
    }

    @Test
    public void testSaveGame() {
        Session session = SESSION_FACTORY.openSession();

        Game game = new Game();
        game.setId(1L);
        game.setName("test");
        assertEquals(game.getId(), 1);
        assertEquals(game.getName(), "test");

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

    @Test
    public void testSaveNews() {
        Session session = SESSION_FACTORY.openSession();

        News news = new News();
        news.setId(1L);
        news.setName("test");
        news.setText("test");
        assertEquals(news.getId(), 1);
        assertEquals(news.getName(), "test");
        assertEquals(news.getText(), "test");

        session.close();
    }

    @Test
    public void testSavePublisher() {
        Session session = SESSION_FACTORY.openSession();

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("test");

        assertEquals(publisher.getId(), 1);
        assertEquals(publisher.getName(), "test");


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

        Review review = new Review();
        review.setId(1L);
        review.setText("test");

        assertEquals(review.getId(), 1);
        assertEquals(review.getText(), "test");


        session.close();
    }


    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
