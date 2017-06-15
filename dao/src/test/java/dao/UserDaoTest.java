package dao;

import entity.User;
import org.junit.Test;
import java.time.LocalDate;

/**
 * Created by User on 15.06.2017.
 */
public class UserDaoTest {
    @Test
    public void info() throws Exception {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("test");
        user.setDate(LocalDate.now());
        userDao.save(user);
        System.out.println(userDao.findById(1L));
        userDao.info(user.getName());
    }
}