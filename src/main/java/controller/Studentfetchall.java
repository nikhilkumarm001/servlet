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

@WebServlet("/fetchall")
public class Studentfetchall extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		Studentdao dao=new Studentdao();
		List<Studentdto> list=dao.fetchall();
		
		req.setAttribute("studentlist", list);
		RequestDispatcher rd=req.getRequestDispatcher("download.jsp");
		rd.forward(req, resp);
		
		
//		for(Studentdto a:list) {
//			resp.getWriter().print(a.getStd_id()+"\n"+a.getStd_name()+"\n"+a.getGender()+"\n"+a.getPh_no()+"\n");
//		}
		
	}

}
