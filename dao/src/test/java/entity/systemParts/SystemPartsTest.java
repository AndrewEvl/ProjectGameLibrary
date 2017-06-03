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

    @Test
    public void  testRam(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Ram ram = new Ram();
        ram.setName("test");
        ram.setId(1L);
        session.save(ram);
        ram.getId();
        ram.getName();
        ram.toString();
        ram.hashCode();

        transaction.commit();
        session.close();
    }

    @Test
    public void  testHdd(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hdd hdd = new Hdd();
        hdd.setName("test");
        hdd.setId(1L);
        session.save(hdd);
        hdd.getId();
        hdd.getName();
        hdd.toString();
        hdd.hashCode();

        transaction.commit();
        session.close();
    }

    @Test
    public void  testVideoCard(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        VideoCard videoCard = new VideoCard();
        videoCard.setName("test");
        videoCard.setId(1L);
        session.save(videoCard);
        videoCard.getId();
        videoCard.getName();
        videoCard.toString();
        videoCard.hashCode();

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }

}