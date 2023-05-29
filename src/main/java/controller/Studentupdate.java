package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.Studentdao;
import dto.Studentdto;

@WebServlet("/update")
public class Studentupdate extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid=req.getParameter("sid");
		int sid1=Integer.parseInt(sid);
		
		String phno=req.getParameter("phno");
		long phno1=Long.parseLong(phno);
		
		Studentdao dao=new Studentdao();
		String msg=dao.update(sid1,phno1);
		res.getWriter().print(msg);
	}
}
