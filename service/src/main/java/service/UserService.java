package service;

import entity.User;

/**
 * Created by Lino on 02.07.2017.
 */
public interface UserService {
//

    void save (User user);

    User findByNickName(String name);

//    UserDetails loadUser (String name);
}
