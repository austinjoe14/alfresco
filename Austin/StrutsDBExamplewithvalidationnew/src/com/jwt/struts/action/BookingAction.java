package com.jwt.struts.action;

import java.io.Writer;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class BookingAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		try {
			int i = (Integer) session.getAttribute("role");
			System.out.println(i);
			if (session.getAttribute("username") != null) {
				Connection connection = (Connection) request.getServletContext().getAttribute("connection");
				UserDAO dao = new UserDAO();
				List<BusForm> list = new ArrayList<BusForm>();
				BusForm busForm = new BusForm();
				String source = busForm.getStartingPoint();
				String end = busForm.getEndPoint();
				String date = busForm.getDate();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(df);
				Date dateOfJourney;
				String MyDate = null;
				try {
					dateOfJourney = df.parse(date);
					((SimpleDateFormat) df).applyPattern("EEEE");
					MyDate = df.format(dateOfJourney);
					session.setAttribute("traveldate", dateOfJourney);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list = dao.getBus(source, end, connection, MyDate);
				busForm.setList(list);
				System.out.println(source + " " + end + " " + date);
				System.out.println(list);
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
