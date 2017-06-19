package dao;

import entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by User on 12.06.2017.
 */
public abstract class BaseDao<T extends BaseEntity> {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entryClass;

    public BaseDao (Class<T> entityClass){
        this.entryClass = entityClass;
    }

    public T findById (Long id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        T result = session.get(entryClass, id);
        transaction.commit();
        session.close();
        return result;
    }

    public void save (T entity){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public void  delete (T entity){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    public void update (T entity) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entryClass.getSimpleName(), entity);
        transaction.commit();
        session.close();
    }

    //update
    //version

    public List<T> findAll () {
        Session session = SESSION_FACTORY.openSession();
        return session.createQuery("FROM " + entryClass.getSimpleName(), entryClass).list();
    }

}
