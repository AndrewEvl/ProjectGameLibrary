package entity;

import entity.reviews.ForumComments;
import entity.reviews.NewsComment;
import entity.reviews.ReviewGame;
import entity.systemParts.Cpu;
import entity.systemParts.Hdd;
import entity.systemParts.Ram;
import entity.systemParts.VideoCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.EntityTestDataImporter;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by User on 24.05.2017.
 */
public class EntityTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        EntityTestDataImporter.getINSTANCE().importTestData(SESSION_FACTORY);
    }

    @Test
    public void testEntityDb (){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        List<Game> games = session.createQuery("select g FROM Game g",Game.class)
                .getResultList();
        List<Platform> platforms = session.createQuery("select p from Platform  p",Platform.class)
                .getResultList();

        List<ReviewGame> reviewGames = session.createQuery("select r from ReviewGame r", ReviewGame.class)
                .getResultList();

        System.out.println(reviewGames);
        System.out.println(games);
        System.out.println(platforms);

        transaction.commit();
        session.close();
    }

    @Test
    public void testForumComments (){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ForumComments forumComments = new ForumComments();
        User user = new User();
        ForumTheme forumTheme = new ForumTheme();
        forumTheme.setTheme("test");
        user.setNickName("Andrew");
        session.save(user);
        session.save(forumTheme);
        forumComments.setName("test");
        forumComments.setUser(user);
        forumComments.setForumTheme(forumTheme);
        session.save(forumComments);

        System.out.println(forumComments);

        transaction.commit();
        session.close();
    }


    @Test
    public void testSaveDeveloper() {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = new Developer();
        developer.setName("Test");
        developer.setId(1L);

        assertEquals(developer.getName(), "Test");
//        assertEquals(developer.getId(),1L);
        System.out.println(developer);

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
        Platform platform = new Platform();
        ReviewGame reviewGame = new ReviewGame();
        SystemSetting systemSetting = new SystemSetting();
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        Hdd hdd = new Hdd();
        VideoCard videoCard = new VideoCard();

        reviewGame.setText("Test");
        reviewGame.setGame(game);
        publisher.setName("Test");
        genre.setName("Test");
        developer.setName("Test");
        game.setName("test");
        cpu.setName("test");
        ram.setName("test");
        hdd.setName("test");
        videoCard.setName("test");
        platform.setName("PC");
        systemSetting.setCpu(cpu);
        systemSetting.setHdd(hdd);
        systemSetting.setRam(ram);
        systemSetting.setVideoCard(videoCard);
        platform.setSystemSetting(systemSetting);
        game.setReleaseDay(LocalDate.now());


        session.save(cpu);
        session.save(ram);
        session.save(hdd);
        session.save(videoCard);
        session.save(systemSetting);
        session.save(platform);

        session.save(reviewGame);
        session.save(developer);
        session.save(publisher);
        session.save(genre);


        game.setGenre(genre);
        game.setDeveloper(developer);
        game.setPublisher(publisher);
        game.getPlatform().add(platform);
        game.getReviewGame().add(reviewGame);
        System.out.println(game.toString());

        session.save(game);
        transaction.commit();
        session.close();

    }

    @Test
    public void testSaveGameCollection() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        GameCollection gameCollection = new GameCollection();
        Genre genre = new Genre();
        Publisher publisher = new Publisher();
        Developer developer = new Developer();
        Platform platform = new Platform();
        ReviewGame reviewGame = new ReviewGame();
        SystemSetting systemSetting = new SystemSetting();
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        Hdd hdd = new Hdd();
        VideoCard videoCard = new VideoCard();

        gameCollection.setArtBook("test");
        gameCollection.setFigure("test");
        gameCollection.setOst("test");
        gameCollection.setOther("test");

        reviewGame.setText("Test");
        reviewGame.setGame(gameCollection);

        publisher.setName("Test");

        genre.setName("Test");

        developer.setName("Test");

        gameCollection.setName("test");

        cpu.setName("test");
        ram.setName("test");
        hdd.setName("test");
        videoCard.setName("test");
        platform.setName("PC");
        systemSetting.setCpu(cpu);
        systemSetting.setHdd(hdd);
        systemSetting.setRam(ram);
        systemSetting.setVideoCard(videoCard);
        platform.setSystemSetting(systemSetting);
        gameCollection.setReleaseDay(LocalDate.now());


        session.save(cpu);
        session.save(ram);
        session.save(hdd);
        session.save(videoCard);
        session.save(systemSetting);
        session.save(platform);

        session.save(reviewGame);
        session.save(developer);
        session.save(publisher);
        session.save(genre);


        gameCollection.setGenre(genre);
        gameCollection.setDeveloper(developer);
        gameCollection.setPublisher(publisher);
        gameCollection.getPlatform().add(platform);
        gameCollection.getReviewGame().add(reviewGame);
        System.out.println(gameCollection.toString());

        session.save(gameCollection);
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

        System.out.println(genre.toString());

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
        System.out.println(news.toString());

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

        System.out.println(publisher.toString());

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

        System.out.println(platform);

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

        System.out.println(reviewGames.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void testRole() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Role role = new Role();

        role.setId(1L);
        role.setRole("test");
        session.save(role);

        assertThat(role.getRole(), equalTo("test"));
        System.out.println(role.toString());

        transaction.commit();
        session.close();
    }


    @Test
    public void testUser() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        Role role = new Role();
        Address address = new Address();


        user.setDate(LocalDate.now());
        user.setMail("test");
        user.setName("test");
        user.setNickName("test");
        user.setPassword("test");
        role.setRole("test");
        session.save(role);
        address.setCity("Minsk");
        address.setCountry("Belarus");
        user.setAddress(address);
        user.setRole(role);
        session.flush();

        System.out.println(user.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void testForumTheme() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ForumTheme forumTheme = new ForumTheme();

        forumTheme.setTheme("test");

        System.out.println(forumTheme.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void testCpu () {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Cpu cpu = new Cpu();
        cpu.setName("test");
        cpu.setId(1L);
        session.save(cpu);
        System.out.println(cpu.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void  testRam(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Ram ram = new Ram();
        ram.setName("test");
        ram.setId(1L);
        session.save(ram);

        System.out.println(ram.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void  testHdd(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hdd hdd = new Hdd();
        hdd.setName("test");
        hdd.setId(1L);
        session.save(hdd);

        System.out.println(hdd.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void  testVideoCard(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        VideoCard videoCard = new VideoCard();
        videoCard.setName("test");
        videoCard.setId(1L);
        session.save(videoCard);

        System.out.println(videoCard.toString());

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
