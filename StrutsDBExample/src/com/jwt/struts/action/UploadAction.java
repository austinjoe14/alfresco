package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.jwt.struts.form.LoginForm;
import com.jwt.struts.util.AlfrescoUtil;

public class UploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm fileForm = (LoginForm) form;
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("userName");
		String userId = (String) session.getAttribute("userId");
		System.out.println("-----------------------upload=--------------------");
		FormFile formFile = null;
		formFile = fileForm.getFiles();
		long size = formFile.getFileSize();
		String path = getServlet().getServletContext().getRealPath("") + "/" + formFile.getFileName();
		System.out.println(path + " and size is " + size);
		String filePath = System.getProperty("java.io.tmpdir") + "/" + fileForm.getFiles().getFileName();
		AlfrescoUtil.createDocument(formFile, name, userId, fileForm.getFileType(), path);
		System.out.println("The file " + formFile.getFileName() + " is uploaded successfully." + filePath);
		fileForm.setFile(AlfrescoUtil.showFolder(userId));
		return mapping.findForward("success");
	}
}