package dao.systemParts;

import dao.common.BaseDao;
import entity.systemParts.Cpu;

/**
 * Created by User on 15.06.2017.
 */
public class CpuDao extends BaseDao<Cpu> {
    public CpuDao() {
        super(Cpu.class);
    }
}
