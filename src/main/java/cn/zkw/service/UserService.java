package cn.zkw.service;

import cn.zkw.vo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByName(String user_name);

    boolean updateNikeName(User user);

    boolean addUser(User user);

    boolean updateSexById(User user);

    boolean updateBirthdayById(User user);
}
