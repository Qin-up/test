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

@WebServlet(name = "ShowServlet",value = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //取值：条件查询的值
        //类型id
        Integer cardsId=0;
        String inputType = request.getParameter("type");
        if (inputType!=null && !inputType.equals("")){
            cardsId=new Integer(inputType);
        }

        //标题
        String name=null;
        String inputName = request.getParameter("name");
        if (inputType!=null && !inputName.equals("")){
            name=inputName;
        }
        //获取页码
        String strPage = request.getParameter("page");
        int curPage=strPage==null?1:Integer.parseInt(strPage);
        //页面大小
        int pageSize=3;

        //调用业务
        UserService userService=new UserServiceimpl();
        //获取总页数
        int totalPage = userService.getInfoPages(pageSize,cardsId,name);
        //获取当前页数据
        List<User> list = userService.getAllInfo(curPage,pageSize,cardsId,name);

        //保存请求对象
        request.setAttribute("list",list);//分页查询
        request.setAttribute("totalPage",totalPage);//页总数
        request.setAttribute("curPage",curPage);//当前页
        request.setAttribute("pageSize",pageSize);//页大小

        //获取所有类型
        CardService cardService=new CardServiceimpl();
        List<Card> typeList = cardService.getAll();

        //保存请求对象
        request.setAttribute("typeList",typeList);//所有类型

        //使用请求转发，传递数据
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}

