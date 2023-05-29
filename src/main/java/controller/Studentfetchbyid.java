package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import dao.Studentdao;
import dto.Studentdto;;

@WebServlet("/fetchbyid")
public class Studentfetchbyid extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid=req.getParameter("sid");
		int id=Integer.parseInt(sid);
		
		Studentdao dao=new Studentdao();
		Studentdto d1=dao.fetchbyid(id);
		res.getWriter().print(d1);
	}
}
