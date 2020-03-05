package com.team.myproject.servlet;

import com.team.myproject.service.UserService;
import com.team.myproject.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet",value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //取值
        String id = request.getParameter("id");

        //解决响应乱码
        PrintWriter out=response.getWriter();
        UserService userService=new UserServiceimpl();
        int i = userService.deleteInfo(Integer.parseInt(id));
        if(i>0){
            out.print("<script>alert('删除成功');location.href='ShowServlet';</script>");
        }else{
            out.print("<script>alert('删除失败');location.href='ShowServlet';</script>");
        }

    }
}
