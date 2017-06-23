package dao;

import dao.common.BaseDaoImpl;
import entity.SystemSetting;

/**
 * Created by User on 15.06.2017.
 */
public class SystemSettingDaoImpl extends BaseDaoImpl<SystemSetting> {
    public SystemSettingDaoImpl() {
        super(SystemSetting.class);
    }
}
