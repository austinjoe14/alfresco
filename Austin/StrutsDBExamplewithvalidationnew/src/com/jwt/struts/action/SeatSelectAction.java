package com.jwt.struts.action;

import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.dao.UserDAO;
import com.jwt.struts.form.BusForm;

public class SeatSelectAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		try{
		int i=(Integer) session.getAttribute("role");
		System.out.println(i);
		if (session.getAttribute("username") != null && (i==2||i==1)) {
			Connection connection = (Connection) request.getServletContext().getAttribute("connection");
			UserDAO dao = new UserDAO();
			BusForm busForm = (BusForm) form;
			List<Integer> list = new ArrayList<Integer>();
			Date date=(Date) session.getAttribute("traveldate");
			list = dao.getFemaleSeats(connection,date);
			request.setAttribute("female", list);
			System.out.println(list);
			String busNumber=busForm.getBusNumber();
			session.setAttribute("busnumber", busNumber);
			list = dao.getMaleSeats(connection,date);
			request.setAttribute("male", list);
			System.out.println(list);
			return mapping.findForward("success");
		} else {
			Writer writer=response.getWriter();
			writer.write("please login first");
			return mapping.findForward("login");	
		}
		}catch(NullPointerException exception){
			return mapping.findForward("login");
		}
	}
}
