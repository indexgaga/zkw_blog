package cn.zkw.mapping;

import cn.zkw.vo.User;

public interface IUserDao {
    User findUserByName(String user_name);

    Integer userAdd(User user);
}
