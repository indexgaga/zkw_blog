package cn.zkw.service;

import cn.zkw.vo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserByName(String user_name);

    boolean userAdd(User user);
}
