package dao.systemParts;

import com.querydsl.jpa.impl.JPAQuery;
import dao.BaseDao;
import entity.GameCollection;
import entity.QGameCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 15.06.2017.
 */
public class GameCollectionDao extends BaseDao<GameCollection> {
    public GameCollectionDao() {
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
