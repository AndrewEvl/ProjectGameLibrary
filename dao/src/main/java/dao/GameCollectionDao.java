package dao;

import dao.common.BaseDao;
import entity.GameCollection;

/**
 * Created by Lino on 25.06.2017.
 */
public interface GameCollectionDao extends BaseDao<GameCollection>{

    GameCollection fullInfo (GameCollection gameCollection);
}
