package dao.systemParts;

import entity.GameCollection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 15.06.2017.
 */
public class GameCollectionDaoTest {
    @Test
    public void fullInfo() throws Exception {
        GameCollectionDao gameCollectionDao = new GameCollectionDao();
        GameCollection gameCollection = new GameCollection();
        gameCollection.setName("test");
        gameCollection.setOst("test");
        gameCollection.setFigure("+");
        gameCollectionDao.save(gameCollection);
    }

}