package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.Studentdao;

@WebServlet("/fetch")
public class Studentfetch extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid=req.getParameter("sid");
		int sid1=Integer.parseInt(sid);
		
		Studentdao dao=new Studentdao();
		String msg=dao.fetch(sid1);
		res.getWriter().print(msg);
	}
}
