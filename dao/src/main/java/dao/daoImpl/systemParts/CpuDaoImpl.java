package dao.daoImpl.systemParts;

import dao.common.BaseDaoImpl;
import dao.interfaceDao.systemParts.CpuDao;
import entity.systemParts.Cpu;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 15.06.2017.
 */
@Repository
public class CpuDaoImpl extends BaseDaoImpl<Cpu> implements CpuDao {
}
