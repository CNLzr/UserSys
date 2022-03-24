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

@WebServlet(urlPatterns = "/register")
public class UserRegisterServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        User user = new User(loginId,loginPwd,name,email,age);
        if(userService.registerUser(user)){
            writer.print("<h1>用户注册成功</h1>");
        }else {
            writer.print("<h1>用户名已存在</h1");
            writer.print("<h1>用户注册失败</h1");
        }
        writer.close();
    }

}
