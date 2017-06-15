package dao;

import com.querydsl.jpa.impl.JPAQuery;
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

    public User info (String name){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QUser qUser = new QUser("myUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(qUser.name, qUser.nickName, qUser.date, qUser.address)
                .from(qUser)
                .where(qUser.nickName.eq(name));
        session.getTransaction().commit();
        session.close();
        return query.fetchOne();
    }

}
