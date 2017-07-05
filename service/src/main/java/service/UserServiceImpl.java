package service;

import dao.interfaceDao.UserDao;
import entity.Role;
import entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lino on 02.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByNickName(String name) {
        return userDao.findByNickName(name);
    }

    @Override
    public UserDetails loadUser(String name) throws UsernameNotFoundException{
        User userDB = userDao.findByNickName(name);
        if(userDB == null){
            throw new UsernameNotFoundException("YOU SHALL NOT PASS" + name);
        }
        return new org.springframework.security.core.userdetails.User(userDB.getNickName(),userDB.getPassword(), userAutorizate(userDB));
    }

    private Set<GrantedAuthority> userAutorizate(User user){
        Set<Role> roles = new HashSet<>();
        roles.add(user.getRole());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return grantedAuthorities;
    }
}
