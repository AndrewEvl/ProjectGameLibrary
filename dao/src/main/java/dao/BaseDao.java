package dao;

import entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public void saveEntity (T e){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(e);
        transaction.commit();
        session.close();
    }

    public void  deleteEntity (){
        Session session = SESSION_FACTORY.openSession();
        session.delete(entryClass);
        session.close();
    }

    public T findByName (String name){
        Session session = SESSION_FACTORY.openSession();
        T result = session.get(entryClass, name);
        session.close();
        return result;
    }

    //update

    public List<T> findAll () {
        Session session = SESSION_FACTORY.openSession();
        return session.createQuery("from" + entryClass.getSimpleName(), entryClass).list();
    }

}
