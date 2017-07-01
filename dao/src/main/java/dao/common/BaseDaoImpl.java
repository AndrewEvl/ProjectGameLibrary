package dao.common;

import entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;


/**
 * Created by User on 12.06.2017.
 */
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public T findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entityClass, id);
    }

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
