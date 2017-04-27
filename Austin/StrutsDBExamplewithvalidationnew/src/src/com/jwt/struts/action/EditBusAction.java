package src.com.jwt.struts.action;

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

public class EditBusAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		try {
			int i = (Integer) session.getAttribute("role");
			if (session.getAttribute("username") != null && i == 1) {
				System.out.println("in edit action");
				BusForm busForm = (BusForm) form;
				String busName = busForm.getBusName();
				String busType = busForm.getBusType();
				String number = busForm.getBusNumber();
				Connection connection = (Connection) request.getServletContext().getAttribute("connection");
				UserDAO dao = new UserDAO();
				Boolean choice = dao.editBus(busForm, connection);
				session.setAttribute("busId", busForm.getBusId());
				session.setAttribute("busName", busName);
				session.setAttribute("busType", busType);
				session.setAttribute("seats", busForm.getSeats());
				session.setAttribute("number", number);
				if (choice == false) {
					return mapping.findForward("failure");
				} else {
					List<BusForm> list = new ArrayList<BusForm>();
					list = dao.getBusData(connection);
					busForm.setList(list);
					return mapping.findForward("success");
				}
			} else {

				return mapping.findForward("login");
			}
		} catch (NullPointerException exception) {
			return mapping.findForward("login");
		}
	}
}