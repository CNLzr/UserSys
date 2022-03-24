package com.lzr.usersys.mapper;

import com.lzr.usersys.entity.User;

import java.util.List;


public interface UserMapper {
    /**
     * 添加用户功能
     * @param user 用户对象
     * @return boolean 添加用户是否成功：true成功，false失败
     */
    boolean addUser(User user);

    /**
     * 获取用户列表
     * @return 用户集合
     */
    List<User> getAllUsers();

    /**
     * 根据登陆名称获取用户对象
     * @param loginId 登录名称
     * @return 用户对象
     */
    User getUserByLoginId(String loginId);
}
