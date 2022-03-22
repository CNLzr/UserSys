package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * 根据登录名和登录密码进行登录
     * @param loginId  登录名称
     * @param loginPwd 登录密码
     * @return 登录结果：1:成功;2:登录错误;3:用户名不存在
     */
    @Override
    public int login(String loginId, String loginPwd) {
        User user = userDao.getUserByLoginId(loginId);
        // 判断用户是否存在
        if(user == null){
            return 3;
        }
        // 判断用户密码是否正确，正确返回1,不然返回2
        if(user.getLoginPwd().equals(loginPwd)){
            return 1;
        }
        return 2;
    }
}
