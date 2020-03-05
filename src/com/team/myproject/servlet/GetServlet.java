package com.team.myproject.servlet;

import com.team.myproject.entity.Card;
import com.team.myproject.entity.User;
import com.team.myproject.service.CardService;
import com.team.myproject.service.UserService;
import com.team.myproject.service.impl.CardServiceimpl;
import com.team.myproject.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetServlet",value = "/GetServlet")
public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受数据
        String id = request.getParameter("id");

        //查单条
        UserService userService=new UserServiceimpl();
        User info = userService.getInfo(Integer.parseInt(id));

        //查询所有新闻分类
        CardService cardService=new CardServiceimpl() ;
        List<Card> list = cardService.getAll();

        //存入作用域
        request.setAttribute("info",info);
        request.setAttribute("list",list);

        //跳转
        request.getRequestDispatcher("up.jsp").forward(request,response);
    }
}
