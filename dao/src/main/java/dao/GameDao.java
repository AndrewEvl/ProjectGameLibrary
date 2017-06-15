package dao;

import com.querydsl.jpa.impl.JPAQuery;
import entity.Game;
import entity.QGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public Game findByNameTwo (String name){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Game result = session.get(Game.class, name);
        transaction.commit();
        session.close();
        return result;
    }

    public Game findByName(String name) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .from(qGame).where(qGame.name.eq(name));
        session.getTransaction().commit();
        session.close();
        return query.fetchOne();
    }

    public List<Game> findByReleaseDay (LocalDate localDate){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .where(qGame.releaseDay.year()
                        .eq(localDate.getYear()));
        session.getTransaction().commit();
        session.close();
        return query.fetchResults().getResults();
    }

}
