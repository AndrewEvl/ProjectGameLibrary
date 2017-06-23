package dao.systemParts;

import dao.GameCollectionDaoImpl;
import entity.GameCollection;
import org.junit.Test;

/**
 * Created by User on 15.06.2017.
 */
public class GameCollectionDaoTest {
    @Test
    public void fullInfo() throws Exception {
        GameCollectionDaoImpl gameCollectionDao = new GameCollectionDaoImpl();
        GameCollection gameCollection = new GameCollection();
        gameCollection.setName("test");
        gameCollection.setOst("test");
        gameCollection.setFigure("+");
        gameCollectionDao.save(gameCollection);
        gameCollectionDao.fullInfo(gameCollection);
    }

}