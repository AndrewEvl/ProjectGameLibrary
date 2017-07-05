package dao.daoImpl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.interfaceDao.GameDao;
import dao.common.BaseDaoImpl;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 25.05.2017.
 */
@Repository
public class GameDaoImpl extends BaseDaoImpl<Game> implements GameDao {

    public Game findByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
//        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .from(qGame)
                .where(qGame.name.eq(name));
        Game result = query.fetchOne();
//        session.getTransaction().commit();
//        session.close();
//        System.out.println(result);
        return result;
    }

    public List<Game> findByReleaseDay (LocalDate localDate){
        Session session = getSessionFactory().getCurrentSession();
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
        Session session = getSessionFactory().getCurrentSession();
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
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        List<Game> result = query.select(qGame).from(qGame).where(qGame.genre.eq(genre)).fetchResults().getResults();
//        session.getTransaction().commit();
//        session.close();
        return result;
    }

    public List<Game> findByPlatform (Platform platform){
        Session session = getSessionFactory().getCurrentSession();
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
