package dao;

import dao.common.BaseDaoImpl;
import entity.Role;

/**
 * Created by User on 15.06.2017.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> {
    public RoleDaoImpl() {
        super(Role.class);
    }
}
