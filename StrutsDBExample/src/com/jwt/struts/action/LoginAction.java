package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.dao.UserDAO;
import com.jwt.struts.form.LoginForm;
import com.jwt.struts.form.UserForm;
import com.jwt.struts.util.AlfrescoUtil;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("indfdsf");
		LoginForm loginForm = (LoginForm) form;
		String userName = loginForm.getUsername();
		String passWord = loginForm.getPassword();
		UserDAO dao = new UserDAO();
		boolean choice = dao.loginData(userName, passWord);
		UserForm userForm = dao.getData(userName);
		HttpSession session = request.getSession(false);
		session.setAttribute("userId", userForm.getUserId());
		session.setAttribute("firstName", userForm.getFirstName());
		session.setAttribute("lastName", userForm.getLastName());
		session.setAttribute("email", userForm.getEmail());
		session.setAttribute("phone", userForm.getPhone());
		session.setAttribute("userName", userForm.getUserName());
		session.setAttribute("password", userForm.getPassword());
		System.out.println("choice is " + choice);
		String userId = userForm.getUserId();
		AlfrescoUtil.createFolders(userName, userId);
		loginForm.setFile(AlfrescoUtil.showFolder(userId));
		if (choice) {
			return mapping.findForward("success");
		} else
			return mapping.findForward("failure");
	}
}
