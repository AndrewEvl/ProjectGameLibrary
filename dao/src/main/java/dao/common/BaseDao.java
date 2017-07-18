package dao.common;

import entity.BaseEntity;

import java.util.List;

/**
 * Created by User on 22.06.2017.
 */
public interface BaseDao<T extends BaseEntity> {

    T findById(Long id);

    void save(T entity);

    void delete(T entity);

    void update(T entity);

    List<T> findAll();
}
