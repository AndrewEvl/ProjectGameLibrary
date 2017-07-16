package dao;

import dao.common.BaseDao;
import dao.daoImpl.RoleDaoImpl;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lino on 16.07.2017.
 */
public class RoleDaoTest extends BaseDaoTest<Role> {

    @Autowired
    private BaseDao<Role> dao = new RoleDaoImpl();

    @Override
    protected BaseDao<Role> getDao() {
        return dao;
    }

    @Override
    protected Role getModel() {
        return new Role();
    }
}
