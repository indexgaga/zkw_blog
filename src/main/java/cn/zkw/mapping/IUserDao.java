package cn.zkw.mapping;

import cn.zkw.vo.User;

public interface IUserDao {
    User findUserByName(String user_name);

    Integer addUser(User user);

    Integer updateUserNameById(User user);

    Integer updateSexById(User user);

    Integer updateBirthdayById(User user);
}
