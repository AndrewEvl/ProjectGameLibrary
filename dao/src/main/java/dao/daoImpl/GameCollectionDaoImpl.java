package dao.daoImpl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDaoImpl;
import dao.interfaceDao.GameCollectionDao;
import entity.GameCollection;
import entity.QGameCollection;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class GameCollectionDaoImpl extends BaseDaoImpl<GameCollection> implements GameCollectionDao {


    public GameCollection fullInfo (GameCollection gameCollection){
        Session session = getSessionFactory().getCurrentSession();
        QGameCollection qGameCollection = new QGameCollection("myGameColl");
        JPAQuery<GameCollection> query = new JPAQuery<>(session);
        query.select(qGameCollection).from(qGameCollection).where(qGameCollection.eq(gameCollection));
        return query.fetchOne();
    }

}
