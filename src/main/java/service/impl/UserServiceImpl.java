package service.impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.addUser(user);
        sqlSession.commit();
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        return userDao.getAllUsers();
    }

    @Override
    public int login(String loginId, String loginPwd) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
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
