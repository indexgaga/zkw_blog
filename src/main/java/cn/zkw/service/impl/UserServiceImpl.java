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

    @Override
    public boolean updateNikeName(User user) {
        return dao.updateUserNameById(user)>=1;
    }

    public boolean addUser(User user){
        return dao.addUser(user)>=1;
    }

    @Override
    public boolean updateSexById(User user) {
        return dao.updateSexById(user)>=1;
    }

    @Override
    public boolean updateBirthdayById(User user) {
        return dao.updateBirthdayById(user)>=1;
    }
}
