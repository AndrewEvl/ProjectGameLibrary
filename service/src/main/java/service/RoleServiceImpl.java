package service;

import dao.interfaceDao.RoleDao;
import entity.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Lino on 18.07.2017.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
