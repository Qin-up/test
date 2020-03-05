package com.team.myproject.servlet;

import com.team.myproject.entity.Card;
import com.team.myproject.service.CardService;
import com.team.myproject.service.impl.CardServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoAddServlet",value = "/GoAddServlet")
public class GoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardService cardService=new CardServiceimpl();
        List<Card> list = cardService.getAll();

        request.setAttribute("list",list);
        request.getRequestDispatcher("add.jsp").forward(request,response);
    }
}
