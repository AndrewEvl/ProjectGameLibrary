package service;

import entity.Role;

/**
 * Created by Lino on 18.07.2017.
 */
public interface RoleService {

    Role findById (Long id);

    void save (Role role);
}
