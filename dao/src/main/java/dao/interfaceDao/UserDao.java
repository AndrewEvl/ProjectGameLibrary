package dao.interfaceDao;

import dao.common.BaseDao;
import entity.User;

/**
 * Created by Lino on 25.06.2017.
 */
public interface UserDao extends BaseDao<User> {

    User findByNickName(String name);

    User fullInfo (Long id);
}
