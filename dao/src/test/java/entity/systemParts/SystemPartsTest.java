package entity.systemParts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 02.06.2017.
 */
public class SystemPartsTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testCpu () {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Cpu cpu = new Cpu();
        cpu.setName("test");
        cpu.setId(1L);
        session.save(cpu);
        cpu.getId();
        cpu.getName();
        cpu.toString();
        cpu.hashCode();

        transaction.commit();
        session.close();
    }


    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }

}