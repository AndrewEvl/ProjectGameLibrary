package dao;

import dao.daoImpl.UserDaoImpl;
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
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setNickName("test");
        userDao.save(user);
        User fullInfo = userDao.fullInfo(1L);
        assertEquals(fullInfo.getNickName(), "test");
    }

    @Test
    public void findByNickNameTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setNickName("Bad");
//        user.setDate(LocalDate.now());
        userDao.save(user);
        User byNickName = userDao.findByNickName(user.getNickName());
        assertEquals(byNickName.getNickName(), "Bad");
        System.out.println(byNickName.toString());
    }
}