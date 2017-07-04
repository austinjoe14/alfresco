package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.form.LoginForm;
import com.jwt.struts.util.AlfrescoUtil;

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		AlfrescoUtil.deleteDocument(loginForm.getFileId(), userId);
		System.out.println("deleted " + loginForm.getFileNames());
		loginForm.setFile(AlfrescoUtil.showFolder(userId));
		return mapping.findForward("success");
	}

}
