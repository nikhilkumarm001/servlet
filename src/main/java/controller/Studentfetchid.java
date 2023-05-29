package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Studentdto;

@WebServlet("/fetchid")
public class Studentfetchid extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String s1=req.getParameter("sid");
		int id=Integer.parseInt(s1);
			
		Studentdao dao=new Studentdao();
		Object d1=dao.fetchid(id);
		resp.getWriter().print(d1);
	}
}
