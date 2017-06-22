package dao;

import dao.common.BaseDao;
import entity.Developer;

/**
 * Created by User on 25.05.2017.
 */
public class DeveloperDao extends BaseDao<Developer> {

    public DeveloperDao (){
        super(Developer.class);
    }

}
