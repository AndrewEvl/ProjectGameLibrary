package dao.daoImpl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.interfaceDao.NewsDao;
import dao.common.BaseDaoImpl;
import entity.News;
import entity.QNews;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

    public List<News> getByDate(LocalDate localDate){
        Session session = getSessionFactory().getCurrentSession();
        QNews qNews = new QNews("myNews");
        JPAQuery<News> query = new JPAQuery<>(session);
        query.select(qNews)
                .from(qNews)
                .where(qNews.date.dayOfMonth()
                        .eq(localDate.getDayOfMonth()));
        List<News> results = query.fetchResults().getResults();
        return results;

    }
}
