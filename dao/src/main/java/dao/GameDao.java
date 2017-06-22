package dao;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDao;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 25.05.2017.
 */
public class GameDao extends BaseDao<Game> {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    public GameDao() {
        super(Game.class);
    }

    public Game findByName(String name) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .from(qGame)
                .where(qGame.name.eq(name));
        Game result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        System.out.println(result);
        return result;
    }

    public List<Game> findByReleaseDay (LocalDate localDate){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame).from(qGame)
                .where(qGame.releaseDay.year()
                        .eq(localDate.getYear()));
        List<Game> results = query.fetchResults().getResults();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Game> findByPublisher (Publisher publisher){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame).from(qGame).where(qGame.publisher.eq(publisher));
        List<Game> results = query.fetchResults().getResults();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Game> findByGenre (Genre genre){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        List<Game> result = query.select(qGame).from(qGame).where(qGame.genre.eq(genre)).fetchResults().getResults();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Game> findByPlatform (Platform platform){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .from(qGame)
                .join(qGame.platform);
//                .where(qGame.platform.equals(platform))

        session.getTransaction().commit();
        session.close();
        return null;
    }

}
