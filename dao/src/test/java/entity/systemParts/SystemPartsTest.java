package entity.systemParts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by User on 02.06.2017.
 */
public class SystemPartsTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }



    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }

}