package dao;

import entity.Developer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.EntityTestDataImporter;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * Created by User on 12.06.2017.
 */
public class DeveloperDaoTest {

    private static SessionFactory SESSION_FACTORY;

    @Before
    public void setUp() throws Exception {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        EntityTestDataImporter.getINSTANCE().importTestData(SESSION_FACTORY);
    }

    @Test
    public void findById() throws Exception {
        DeveloperDao developerDao = new DeveloperDao();
        Developer developerOne = new Developer();
        developerOne.setName("test");
        developerDao.save(developerOne);
        Developer developer = developerDao.findById(1L);
        assertEquals(developer.getName(),"test");
        System.out.println(developer);
    }

    @Test
    public void saveEntity() throws Exception {
        DeveloperDao developerDao = new DeveloperDao();
        Developer developerOne = new Developer();
        developerOne.setName("test");
        developerDao.save(developerOne);
    }

    @Test
    public void deleteEntity() throws Exception {
        DeveloperDao developerDao = new DeveloperDao();
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
        developerDao.delete(developerDao.findById(1L));
        assertNull(developerDao.findById(1L));
    }

    @Test
    public void update() throws Exception {
        DeveloperDao developerDao = new DeveloperDao();
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
        DeveloperDao developerDao = new DeveloperDao();
        Developer developer = new Developer();
        developer.setName("test");
        developerDao.save(developer);
        List<Developer> developerList = developerDao.findAll();
        assertThat(developerList, hasSize(1));
        System.out.println(developerList);
    }

    @After
    public void tearDown() throws Exception {
        SESSION_FACTORY.close();
    }

}