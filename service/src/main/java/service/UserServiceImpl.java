package service;

import dao.interfaceDao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
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


//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
//        User userDB = userDao.findByNickName(name);
//        if(userDB == null){
//            throw new UsernameNotFoundException("YOU SHALL NOT PASS" + name);
//        }
//        return new org.springframework.security.core.userdetails.User
//                (userDB.getNickName(),userDB.getPassword(), getUserAuthorities(userDB));
//    }
//
//    private Set<GrantedAuthority> getUserAuthorities(User user){
//        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRole()));
//    }
}
