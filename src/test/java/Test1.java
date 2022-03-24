import com.lzr.usersys.entity.User;
import com.lzr.usersys.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import com.lzr.usersys.util.MybatisUtil;

public class Test1 {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean rest = userMapper.addUser(new User("lzr", "lzr", "lzr", "lzr@163.com", "22"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
        if(rest){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
