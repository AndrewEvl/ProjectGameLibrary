package dao;

import dao.interfaceDao.UserDao;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 15.06.2017.
 */
public class UserDaoTest extends BaseTest{

    @Autowired
    private  UserDao userDao;


    @Test
    public void fullInfo() throws Exception {
        User user = new User();
        user.setNickName("test");
        userDao.save(user);
        User test = userDao.findByNickName("test");
        assertEquals(test.getNickName(), "test");
    }

    @Test
    public void findByNickNameTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setNickName("Bad");
        userDao.save(user);
        User byNickName = userDao.findByNickName(user.getNickName());
        assertEquals(byNickName.getNickName(), "Bad");
        System.out.println(byNickName.toString());
    }
}