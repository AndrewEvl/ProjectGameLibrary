package dao.interfaceDao;

import dao.common.BaseDao;
import entity.News;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Lino on 25.06.2017.
 */
public interface NewsDao extends BaseDao<News> {

    List<News> getByDate(LocalDate localDate);
}
