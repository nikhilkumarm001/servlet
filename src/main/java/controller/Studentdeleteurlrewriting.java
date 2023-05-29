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

@WebServlet("/delete")
public class Studentdeleteurlrewriting extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getParameter("id");
		int cid=Integer.parseInt(id);
		
		Studentdao dao=new Studentdao();
		dao.urldelete(cid);
		List<Studentdto> l1=dao.fetchall();
		req.setAttribute("studentlist", l1);
		resp.getWriter().print("<h1 style=\"color: red\"><i>DATA DELETED SUCCESSFULLY</i></h1>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("download.jsp");
		
		dispatcher.include(req, resp);
		
	}
}
