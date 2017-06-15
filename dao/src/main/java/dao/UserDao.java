package dao;

import entity.User;

/**
 * Created by User on 15.06.2017.
 */
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }
}
