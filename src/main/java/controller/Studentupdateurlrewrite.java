package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Studentdto;

@WebServlet("/updating")
public class Studentupdateurlrewrite extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("sid");
		int cid=Integer.parseInt(id);
		String name=req.getParameter("name");
		String no=req.getParameter("sno");
		long cno=Long.parseLong(no);
		String gender=req.getParameter("gender");
		
		Studentdto dto= new Studentdto();
		dto.setStd_id(cid);
		dto.setStd_name(name);
		dto.setPh_no(cno);
		dto.setGender(gender);
		
		Studentdao dao=new Studentdao();
		dao.updating(dto);
		List<Studentdto> l1=dao.fetchall();
		req.setAttribute("studentlist", l1);
		resp.getWriter().print("<h1 style=\"color: cyan\"><i>DATA UPDATED SUCCESSFULLY</i></h1>");
		
//		resp.setContentType("text/html"); Which helps to print the data instead of HTML code in the browser
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("download.jsp");
		
//		if we use forward method we can get the data but not the messege written...

//		dispatcher.forward(req, resp); 
		
//		if we use forward method we can get the data along with the messege written...
		
		dispatcher.include(req, resp);
	}
}

//		if we are using multiple checkbox in the frontend then to view the data in the controller we need to use req.getParametervalues();
