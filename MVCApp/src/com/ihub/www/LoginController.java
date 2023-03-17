package com.ihub.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//reading form data
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		
		//set the values to bean object
		LoginBean lb=new LoginBean();
		lb.setUsername(uname);
		lb.setPassword(pass);
		
		//send the bean object to jsp
		req.setAttribute("bean",lb);
		
		if(pass.equals("admin"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
			rd.forward(req,res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
			rd.forward(req,res);
		}
		pw.close();
		
	}

}
