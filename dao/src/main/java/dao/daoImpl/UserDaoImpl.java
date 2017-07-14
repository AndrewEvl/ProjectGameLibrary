package dao.daoImpl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.interfaceDao.UserDao;
import dao.common.BaseDaoImpl;
import entity.QUser;
import entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


    public User findByNickName(String name){
        Session session = getSessionFactory().getCurrentSession();
//        session.beginTransaction();
        QUser qUser = new QUser("myUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(qUser)
                .from(qUser)
                .where(qUser.nickName.eq(name));
        User result = query.fetchOne();
//        session.getTransaction().commit();
//        session.close();
        return result;
    }

    public User fullInfo (Long id){
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        QUser qUser = new QUser("NyUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(qUser).from(qUser).where(qUser.id.eq(id));
        User result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        return result;

    }

}
