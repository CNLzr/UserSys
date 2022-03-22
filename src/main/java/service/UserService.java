package service;

import entity.User;

import java.util.List;

public interface UserService {
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
     * 根据登录名和登录密码进行登录
     * @param loginId  登录名称
     * @param loginPwd 登录密码
     * @return 登录结果：1:成功;2:登录错误;3:用户名不存在
     */
    int login(String loginId,String loginPwd);
}
