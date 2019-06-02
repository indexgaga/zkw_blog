package cn.zkw.service;

import cn.zkw.vo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByName(String user_name);

    boolean addUser(User user);
}
