package dao;

import dao.interfaceDao.GameCollectionDao;
import entity.GameCollection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by User on 15.06.2017.
 */
public class GameCollectionDaoTest extends BaseTest {

    @Autowired
    private GameCollectionDao gameCollectionDao;

    @Test
    public void fullInfo() throws Exception {
        GameCollection gameCollection = new GameCollection();
        gameCollection.setName("test");
        gameCollection.setOst("test");
        gameCollection.setFigure("+");
        gameCollectionDao.save(gameCollection);
        gameCollectionDao.fullInfo(gameCollection);
    }

}