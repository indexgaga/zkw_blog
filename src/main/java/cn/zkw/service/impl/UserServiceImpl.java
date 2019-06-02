package cn.zkw.service.impl;

import cn.zkw.mapping.IUserDao;
import cn.zkw.service.UserService;
import cn.zkw.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUserDao dao;

    @Override
    public User getUserByName(String user_name) {
        return dao.findUserByName(user_name);
    }

    public boolean addUser(User user){
        return dao.addUser(user)>=1;
    }
}
