package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    // 确保SqlSession对象是线程安全的
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private MybatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return  sqlSession;
    }

    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
