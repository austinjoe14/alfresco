package com.jwt.struts.action;

import java.io.Writer;
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

import com.jwt.struts.form.BusForm;

public class GetPassengerDetailsAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in out ttry");
		HttpSession session = request.getSession(false);
		try {
			System.out.println("in ttry");
			int i = (Integer) session.getAttribute("role");
			if (session.getAttribute("username") != null && (i == 2 || i == 1)) {
				BusForm busForm = (BusForm) form;
				int value=busForm.getTotalseats();
				session.setAttribute("totalseats", value);
				
				List<String> list = new ArrayList<String>();
				for(i=1;i<=value;i++){
					String seat=request.getParameter("seat"+i);
					System.out.println(seat);
					list.add(seat);
				}
				session.setAttribute("seatslist", list);
				ServletContext context=request.getServletContext();
				context.setAttribute("numberOfSeats", list);
				return mapping.findForward("success");
			} else {
				Writer writer = response.getWriter();
				writer.write("please login first");
				return mapping.findForward("login");
			}
		} catch (NullPointerException exception) {
			System.out.println("in catch");
			return mapping.findForward("login");
		}
	}
}