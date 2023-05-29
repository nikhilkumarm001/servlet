package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import dto.Studentdto;
import dao.Studentdao;

@WebServlet("/insert")
public class Studentcontroller extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=req.getParameter("std_id");
		String sname=req.getParameter("std_name");
		String gender=req.getParameter("gender");
		String ph_no=req.getParameter("ph_no");
		
		long ph_no1=Long.parseLong(ph_no);
		
		int sid1=Integer.parseInt(sid);
		
		Studentdto dto=new Studentdto();
		dto.setStd_id(sid1);
		dto.setStd_name(sname);
		dto.setGender(gender);
		dto.setPh_no(ph_no1);
		
		
		Studentdao dao=new Studentdao();
		String msg=dao.create(dto);
		res.getWriter().print(msg);
	}
}
