package com.lzr.usersys.servlet;

import com.lzr.usersys.entity.User;
import com.lzr.usersys.service.UserService;
import com.lzr.usersys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getAll")
public class UserGetAllServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到get请求");
        // 设置响应的文本格式以及字符编码格式
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<table border='1px'>");
        writer.print("<tr><th>账户</th><th>姓名</th><th>邮箱</th><th>年龄</th></tr>");
        List<User> users = userService.getAllUsers();
        for(User user:users){
            System.out.println(user);
            writer.print("<tr>");
            writer.print("<td>"+user.getLoginId()+"</td>");
            writer.print("<td>"+user.getName()+"</td>");
            writer.print("<td>"+user.getEmail()+"</td>");
            writer.print("<td>"+user.getAge()+"</td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
        writer.close();
    }
}
