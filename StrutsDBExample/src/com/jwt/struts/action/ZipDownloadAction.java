package com.jwt.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.form.LoginForm;
import com.jwt.struts.util.AlfrescoUtil;

public class ZipDownloadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		String ids = request.getParameter("fileIds");
		String newName = request.getParameter("newFileName");
		String[] id = ids.split(",");
		List<String> name = new ArrayList<String>();
		for (int i = 0; i < id.length; i++) {
			name.add(id[i]);
		}
		AlfrescoUtil.zipFiles(name, newName, userId);
		loginForm.setFile(AlfrescoUtil.showFolder(userId));
		return mapping.findForward("success");
	}

}
