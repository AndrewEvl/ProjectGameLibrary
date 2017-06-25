package dao;

import com.querydsl.jpa.impl.JPAQuery;
import dao.common.BaseDaoImpl;
import entity.News;
import entity.QNews;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 15.06.2017.
 */
public class NewsDaoImpl extends BaseDaoImpl<News> {
    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    public List<News> getByDate(LocalDate localDate){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QNews qNews = new QNews("myNews");
        JPAQuery<News> query = new JPAQuery<>(session);
        query.select(qNews)
                .from(qNews)
                .where(qNews.date.dayOfMonth()
                        .eq(localDate.getDayOfMonth()));
        List<News> results = query.fetchResults().getResults();
        session.getTransaction().commit();
        session.close();
        return results;

    }
}
