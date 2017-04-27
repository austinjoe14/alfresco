package com.jwt.struts.action;

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

public class AddBusAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		try {
			int i = (Integer) session.getAttribute("role");
			if (session.getAttribute("username") != null && i == 1) {
				BusForm busForm = (BusForm) form;
				String time = busForm.getTime();
				Connection connection = (Connection) request.getServletContext().getAttribute("connection");
				UserDAO dao = new UserDAO();
				Boolean choice = dao.addNewBus(busForm, connection,time);
				if (choice) {
					List<BusForm> list = new ArrayList<BusForm>();
					list = dao.getBusData(connection);
					busForm.setList(list);
					return mapping.findForward("success");
				} else {
					return mapping.findForward("failure");
				}
			} else {

				return mapping.findForward("login");
			}
		} catch (NullPointerException exception) {
			return mapping.findForward("login");
		}
	}
}