package src.com.jwt.struts.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.dao.UserDAO;
import com.jwt.struts.form.LoginForm;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession();
			LoginForm loginForm = (LoginForm) form;
			String userName = loginForm.getUsername();
			String passWord = loginForm.getPassword();
			Connection connection = (Connection) request.getServletContext().getAttribute("connection");
			UserDAO dao = new UserDAO();
			boolean choice = dao.loginData(userName, passWord, connection);
			/*List count= new List();
			if(session.getAttribute("username")!= null){
				count.add(userName);
			}
			System.out.println(count);*/
			if (choice == true) {
				session.setAttribute("username", loginForm.getUsername());
				int role = dao.getRole(userName, connection);
				session.setAttribute("role", role);
				System.out.println("in login action " + role);
				System.out.println(loginForm.getUsername());
				if (role == 1)
					return mapping.findForward("success");
				else
					return mapping.findForward("normaluser");
			} else
				return mapping.findForward("failure");
		} catch (NullPointerException exception) {
			return mapping.findForward("login");
		}
	}
}