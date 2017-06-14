package dao;

import com.querydsl.jpa.impl.JPAQuery;
import entity.Game;
import entity.QGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 25.05.2017.
 */
public class GameDao extends BaseDao<Game> {

    public GameDao() {
        super(Game.class);
    }

//    public Game fullInfo (Game game) {
//        QGame qGame = new QGame("myGame");
//        JPAQuery<Game> query = new JPAQuery<>();
//        query.select(qGame.name,
//                qGame.developer,
//                qGame.genre,
//                qGame.publisher,
//                qGame.releaseDay)
//                .from(qGame)
//                .where(qGame.eq(game));
//        return query.fetchOne();
//    }
}
