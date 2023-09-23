package com.example.lab_week1;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Account;
import models.GrantAccess;
import respositories.AccountRespository;
import services.AccountServices;
import services.GrantAccessServices;

@WebServlet(urlPatterns = {"/","/Controll"})
public class ControllerServlet extends HttpServlet {

    private static AccountServices accountServices;

    private static GrantAccessServices grantAccessServices;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        accountServices = new AccountServices();
        grantAccessServices = new GrantAccessServices();
        Account checkAccount = accountServices.checkLogInService(email,password);
        GrantAccess checkGrantAccess = grantAccessServices.searchGrantAccessByAccountIdService(checkAccount.getId());
        if(checkAccount != null && checkGrantAccess != null ){
            RequestDispatcher res = req.getRequestDispatcher("result.jsp");
            res.forward(req, resp);

        }else{
            RequestDispatcher res = req.getRequestDispatcher("login.jsp");
            res.forward(req, resp);
        }

    }

    public void destroy() {
    }
}