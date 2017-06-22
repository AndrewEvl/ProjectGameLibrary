package dao;

import dao.common.BaseDao;
import entity.Role;

/**
 * Created by User on 15.06.2017.
 */
public class RoleDao extends BaseDao<Role> {
    public RoleDao() {
        super(Role.class);
    }
}
