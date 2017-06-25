package dao;

import dao.interfaceDao.DeveloperDao;
import entity.Developer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * Created by User on 12.06.2017.
 */
public class DeveloperDaoTest extends BaseTest {

    @Autowired
    private DeveloperDao developerDao;


    @Test
    public void findById() throws Exception {
        Developer developerOne = new Developer();
        developerOne.setName("test");
        developerDao.save(developerOne);
        Developer developer = developerDao.findById(1L);
        assertEquals(developer.getName(),"test");
        System.out.println(developer);
    }

    @Test
    @Rollback (value = false)
    public void saveEntity() {
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
    }

    @Test
    public void deleteEntity() throws Exception {
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
        developerDao.delete(developerDao.findById(1L));
        assertNull(developerDao.findById(1L));
    }

    @Test
    public void update() throws Exception {
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
        developer.setName("testOne");
        developerDao.update(developer);
        Developer byId = developerDao.findById(1L);
        System.out.println(byId);
        assertEquals(developer.getName(),"testOne");
    }

    @Test
    public void findAll() throws Exception {
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
        List<Developer> developerList = developerDao.findAll();
        assertThat(developerList, hasSize(1));
        System.out.println(developerList);
    }
}