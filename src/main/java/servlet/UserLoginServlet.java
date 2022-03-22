package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 设置请求内容的字符编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的文本格式以及字符编码格式
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String loginId = req.getParameter("loginId");
        String loginPwd = req.getParameter("loginPwd");
        int login_status = userService.login(loginId,loginPwd);
        if(login_status == 1){
            writer.print("<h1>登陆成功</h1>");
        }else if(login_status == 2) {
            writer.print("<h1>用户名或密码错误</h1");
        }else if(login_status == 3){
            writer.print("<h1>用户名不存在</h1");
        }
        writer.close();
    }
}
