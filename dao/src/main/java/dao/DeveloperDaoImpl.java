package dao;

import dao.common.BaseDaoImpl;
import entity.Developer;

/**
 * Created by User on 25.05.2017.
 */
public class DeveloperDaoImpl extends BaseDaoImpl<Developer> {

    public DeveloperDaoImpl(){
        super(Developer.class);
    }

}
