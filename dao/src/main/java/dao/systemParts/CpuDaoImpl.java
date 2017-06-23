package dao.systemParts;

import dao.common.BaseDaoImpl;
import entity.systemParts.Cpu;

/**
 * Created by User on 15.06.2017.
 */
public class CpuDaoImpl extends BaseDaoImpl<Cpu> {
    public CpuDaoImpl() {
        super(Cpu.class);
    }
}
