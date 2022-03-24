package com.lzr.usersys.service.impl;

import com.lzr.usersys.entity.User;
import com.lzr.usersys.mapper.UserMapper;
import com.lzr.usersys.service.UserService;
import com.lzr.usersys.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.commit();
        return userMapper.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getAllUsers();
    }

    @Override
    public int login(String loginId, String loginPwd) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByLoginId(loginId);
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
