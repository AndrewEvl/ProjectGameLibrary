package dao;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDaoImpl;
import entity.GameCollection;
import entity.QGameCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class GameCollectionDaoImpl extends BaseDaoImpl<GameCollection> {
    public GameCollectionDaoImpl() {
        super(GameCollection.class);
    }
    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    public GameCollection fullInfo (GameCollection gameCollection){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QGameCollection qGameCollection = new QGameCollection("myGameColl");
        JPAQuery<GameCollection> query = new JPAQuery<>(session);
        query.select(qGameCollection).from(qGameCollection).where(qGameCollection.eq(gameCollection));
        GameCollection result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
