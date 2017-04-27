package com.jwt.struts.action;

import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.dao.UserDAO;
import com.jwt.struts.form.BusForm;

public class SeatConfirmation extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		try {
			int i = (Integer) session.getAttribute("role");
			System.out.println(i);
			if (session.getAttribute("username") != null && (i == 2 || i == 1)) {
				Connection connection = (Connection) request.getServletContext().getAttribute("connection");
				UserDAO dao = new UserDAO();
				System.out.println("confirm seats");
				int counter = (Integer) session.getAttribute("totalseats");
				System.out.println(counter);

				List<BusForm> forms = new ArrayList<BusForm>();
				BusForm busForm = null;
				for (int counterOne = 1; counterOne <= counter; counterOne++) {
					busForm = new BusForm();
					busForm.setUserName(request.getParameter("userName" + counterOne));
					busForm.setGender(request.getParameter("gender" + counterOne));
					busForm.setAge(Integer.parseInt(request.getParameter("age" + counterOne)));
					busForm.setContact(Integer.parseInt(request.getParameter("contact" + counterOne)));
					forms.add(busForm);
				}
				String date = (String) session.getAttribute("tdate");
				String busNumber = (String) session.getAttribute("busnumber");

				List<String> list = new ArrayList<String>();
				ServletContext context = request.getServletContext();
				list = (List<String>) context.getAttribute("numberOfSeats");

				List<Integer> id=new ArrayList<Integer>();
				id=dao.insertPassengerDetails(connection, forms);
				System.out.println(id);
				dao.bookSeats(id, list, connection, date, busNumber);

				return mapping.findForward("success");
			} else {
				Writer writer = response.getWriter();
				writer.write("please login first");
				return mapping.findForward("login");
			}
		} catch (NullPointerException exception) {
			return mapping.findForward("login");
		}
	}

}
