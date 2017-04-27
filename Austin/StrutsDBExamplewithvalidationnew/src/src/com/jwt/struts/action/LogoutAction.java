package src.com.jwt.struts.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("in logout");
		session.getAttribute("username");

		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()) != null) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);

					System.out.print("Deleted cookie: " + cookie.getName() + "<br/>");
				}
				System.out.print("Name : " + cookie.getName() + ",  ");
				System.out.print("Value: " + cookie.getValue());
			}
		} else {
			System.out.println("<h2>No cookies founds</h2>");
		}
		session.removeAttribute("username");
		session.invalidate();
		return mapping.findForward("success");
	}

}