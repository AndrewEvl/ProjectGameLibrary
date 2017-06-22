package dao;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDao;
import entity.QUser;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 15.06.2017.
 */
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }
    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    public User findByNickName(String name){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QUser qUser = new QUser("myUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(qUser)
                .from(qUser)
                .where(qUser.nickName.eq(name));
        User result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public User fullInfo (Long id){
        Session session = SESSION_FACTORY.openSession();
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
