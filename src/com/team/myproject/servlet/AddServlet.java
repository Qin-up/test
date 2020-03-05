package com.team.myproject.servlet;

import com.team.myproject.entity.Card;
import com.team.myproject.entity.User;
import com.team.myproject.service.UserService;
import com.team.myproject.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet",value = "/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        /*  文件逻辑处理   */
        User user=new User();
        user.setUserNum(request.getParameter("num"));
        user.setUserName(request.getParameter("name"));
        user.setUserAddr(request.getParameter("add"));
        user.setCardId(Integer.parseInt(request.getParameter("type")));

        UserService newInfoService=new UserServiceimpl();
        int i = newInfoService.addInfo(user);
        if (i>0){
            response.getWriter().print("<script>alert('添加成功');location.href='ShowServlet'</script>");
        }else{
            response.getWriter().print("<script>alert('添加失败')；location.href='ShowServlet'</script>");
        }
    }
}
