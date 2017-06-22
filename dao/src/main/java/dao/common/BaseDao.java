package dao.common;

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

    private SessionFactory sessionFactory;
    private Class<T> entryClass;

    public BaseDao (Class<T> entityClass){
        this.entryClass = entityClass;
    }

    public T findById (Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entryClass, id);
    }

    public void save (T entity){
        sessionFactory.getCurrentSession().save(entity);
    }

    public void  delete (T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }


    public void update (T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    //update
    //version

    public List<T> findAll () {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM " + entryClass.getSimpleName(), entryClass).list();
    }

    private SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
