package com.jwt.struts.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.form.LoginForm;
import com.jwt.struts.util.AlfrescoUtil;

public class UploadAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm fileForm = (LoginForm) form;
		File file= fileForm.getFileName();
		System.out.println(file);
		HttpSession session = request.getSession(false);
		String name=(String) session.getAttribute("userName");
		String userId=(String) session.getAttribute("userId");
		System.out.println(userId);
		System.out.println(file.getAbsolutePath());
		AlfrescoUtil.createDocument(file,name,userId,fileForm.getFileType());
		fileForm.setFile( AlfrescoUtil.showFolder(userId));
		return mapping.findForward("success");
	}
	
}
