package com.jwt.struts.action;

import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
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

public class BusBooking extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		try{
		int i=(Integer) session.getAttribute("role");
		System.out.println(i);
		if (session.getAttribute("username") != null && i==1) {
			Connection connection = (Connection) request.getServletContext().getAttribute("connection");
			UserDAO dao = new UserDAO();
			List<BusForm> list = new ArrayList<BusForm>();
			list = dao.getBusData(connection);
			BusForm busForm = (BusForm) form;
			busForm.setList(list);
			HttpSession sessions = request.getSession();
			String name = (String) (sessions.getAttribute("username"));
			System.out.println(name);
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