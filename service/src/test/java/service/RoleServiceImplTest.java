package service;

import entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lino on 18.07.2017.
 */
public class RoleServiceImplTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void findById() throws Exception {
        Role role = new Role();
        role.setRole("test");
        roleService.save(role);
        Role byId = roleService.findById(role.getId());
        assertEquals(byId.getId(),role.getId());
    }


}