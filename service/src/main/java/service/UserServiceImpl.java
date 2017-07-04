package service;

import dao.interfaceDao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Lino on 02.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByNickName(String name) {
        return userDao.findByNickName(name);
    }
}
