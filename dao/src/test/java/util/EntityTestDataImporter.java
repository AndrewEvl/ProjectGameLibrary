package util;

import entity.*;
import entity.reviews.NewsComment;
import entity.reviews.ReviewGame;
import entity.systemParts.Cpu;
import entity.systemParts.Hdd;
import entity.systemParts.Ram;
import entity.systemParts.VideoCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

/**
 * Created by User on 06.06.2017.
 */
public class EntityTestDataImporter {

    private static EntityTestDataImporter INSTANCE;

    private EntityTestDataImporter() {
    }

    public static EntityTestDataImporter getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (EntityTestDataImporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EntityTestDataImporter();
                }
            }
        }
        return INSTANCE;
    }
    public void importTestData (SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer valve = saveDeveloper(session, "Valve");
        Developer idSoftware = saveDeveloper(session,"ID Software");

        Publisher valvePublisher = savePublisher(session, "Valve");
        Publisher idPublisher = savePublisher(session, "ID Software");

        Genre action = saveGenre(session,"Action");
        ReviewGame quakeReviewFirst = saveReviewGame(session, "Cool");
        ReviewGame quakeReviewSecond = saveReviewGame(session, "Legendary");
        session.save(quakeReviewFirst);
        session.save(quakeReviewSecond);


        Cpu p4 = saveCpu(session, "Pentium 4");
        Ram firstRam = saveRam(session, "1024");
        Hdd firstHdd = saveHdd(session, "4Gb");
        VideoCard videoCard = saveVideoCard(session, "Nvidia 550 TI");
        SystemSetting systemSetting = saveSystemSetting(session, p4,firstRam,firstHdd,videoCard);
        session.save(systemSetting);

        Platform pc = savePlatform(session, "PC", systemSetting);
        session.save(pc);

        Game quake = saveGame(session, "Quake II",LocalDate.of(1997, Month.DECEMBER, 9),action,idPublisher,idSoftware);
        quake.getPlatform().add(pc);
        quake.getReviewGame().add(quakeReviewFirst);
        quake.getReviewGame().add(quakeReviewSecond);
        Game halfLife = saveGame(session, "Half-Life", LocalDate.of(1998, Month.NOVEMBER, 19),action,valvePublisher,valve) ;
        halfLife.getPlatform().add(pc);
        halfLife.getReviewGame().add(quakeReviewFirst);
        halfLife.getReviewGame().add(quakeReviewSecond);
        session.save(quake);
        session.save(halfLife);

        ForumTheme forumTheme = saveForumTheme(session, "Test Theme");

        NewsComment newsComment = saveNewsComment(session,"WTF");
        News news = saveNews(session,"New NEWS",LocalDate.now(),"News od Day");
        news.getNewsCommentSet().add(newsComment);
        session.save(news);

        transaction.commit();
        session.close();

    }


    private Game saveGame(Session session, String name, LocalDate releaseDay, Genre genre, Publisher publisher, Developer developer) {
        Game game = new Game(name, releaseDay, genre, publisher, developer);
        session.save(game);
        return game;
    }

    private Developer saveDeveloper(Session session, String name) {
        Developer developer = new Developer(name);
        session.save(developer);
        return developer;
    }

    private ForumTheme saveForumTheme(Session session, String theme) {
        ForumTheme forumTheme = new ForumTheme(theme);
        session.save(forumTheme);
        return forumTheme;
    }

    private Genre saveGenre(Session session, String name) {
        Genre genre = new Genre(name);
        session.save(genre);
        return genre;
    }

    private News saveNews(Session session, String name, LocalDate date, String text) {
        News news = new News(name, date, text);
        session.save(news);
        return news;
    }

    private Platform     savePlatform(Session session, String name, SystemSetting systemSetting) {
        Platform platform = new Platform(name, systemSetting);
        session.save(platform);
        return platform;
    }

    private Publisher savePublisher(Session session, String name) {
        Publisher publisher = new Publisher(name);
        session.save(publisher);
        return publisher;
    }

    private Role saveRole(Session session, String roleName) {
        Role role = new Role(roleName);
        session.save(role);
        return role;
    }

    private SystemSetting saveSystemSetting(Session session, Cpu cpu, Ram ram, Hdd hdd, VideoCard videoCard) {
        SystemSetting systemSetting = new SystemSetting(cpu, ram, hdd, videoCard);
        session.save(systemSetting);
        return systemSetting;
    }

    private User saveUser(Session session, String name, String nickName, LocalDate date, String password, String mail, Role role, Address address) {
        User user = new User(name, nickName, date, password, mail, role, address);
        session.save(user);
        return user;
    }
    private ReviewGame saveReviewGame (Session session, String text){
        ReviewGame reviewGame = new ReviewGame(text);
        session.save(reviewGame);
        return reviewGame;
    }

    private NewsComment saveNewsComment (Session session, String text) {
        NewsComment newsComment = new NewsComment(text);
        session.save(newsComment);
        return newsComment;
    }

    private Cpu saveCpu (Session session, String name){
        Cpu cpu = new Cpu(name);
        session.save(cpu);
        return cpu;
    }

    private Ram saveRam (Session session, String name){
        Ram ram = new Ram(name);
        session.save(ram);
        return ram;
    }

    private Hdd saveHdd (Session session, String name){
        Hdd hdd = new Hdd(name);
        session.save(hdd);
        return hdd;
    }

    private VideoCard saveVideoCard (Session session, String name){
        VideoCard videoCard = new VideoCard(name);
        session.save(videoCard);
        return videoCard;
    }
}


