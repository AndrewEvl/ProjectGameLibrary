import dao.daoImpl.DeveloperDaoImpl;
import entity.Developer;


/**
 * Created by User on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {

//        SessionFactory sessionFactory = new configuration.configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();

        DeveloperDaoImpl developerDao = new DeveloperDaoImpl();
        Developer developerOne = new Developer();
        developerOne.setName("test");
        developerDao.save(developerOne);


//        session.close();

//       close Developer developer = new Developer();
//        developer.setName("no getters and setters");
//        session.saveOrUpdate(developer);
//
//        Developer find = session.find(Developer.class, 1L);
//        System.out.println(find);
//
//        List<Developer> resulList = session.createQuery("from Developer",Developer.class).getResultList();
//        resulList.forEach(System.out::println);
//
////        session.delete("from emploees where emploees.id='1'");
//
//        session.close();
//        sessionFactory.close();
    }
}
