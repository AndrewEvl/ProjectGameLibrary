package dao.daoImpl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDaoImpl;
import dao.interfaceDao.GameDao;
import entity.*;
import org.hibernate.Session;
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
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame)
                .from(qGame)
                .where(qGame.name.eq(name));

        return query.fetchOne();
    }

    public List<Game> findByReleaseDay (LocalDate localDate){
        Session session = getSessionFactory().getCurrentSession();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame).from(qGame)
                .where(qGame.releaseDay.year()
                        .eq(localDate.getYear()));
        return query.fetchResults().getResults();
    }

    public List<Game> findByPublisher (Publisher publisher){
        Session session = getSessionFactory().getCurrentSession();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        query.select(qGame).from(qGame).where(qGame.publisher.eq(publisher));
        return query.fetchResults().getResults();
    }

    public List<Game> findByGenre (Genre genre){
        Session session = getSessionFactory().getCurrentSession();
        QGame qGame = new QGame("myGame");
        JPAQuery<Game> query = new JPAQuery<>(session);
        return query.select(qGame).from(qGame).where(qGame.genre.eq(genre)).fetchResults().getResults();
    }
}
