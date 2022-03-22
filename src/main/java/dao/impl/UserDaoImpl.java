package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * userDao:用于获取Mybatis映射文件反射出来的UserDao实现类
     * sqlSession:用于获取MySql连接会话
     */
    private static UserDao userDao;
    private static SqlSession sqlSession;
    // 加载Dao层类时,加载Mybatis,并获取sqlSession对象
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = factory.openSession();
            userDao = sqlSession.getMapper(UserDao.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取用户列表
     * @return 用户集合
     */
    @Override
    public boolean addUser(User user) {
        try {
            userDao.addUser(user);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByLoginId(String loginId) {
        return null;
    }
}
