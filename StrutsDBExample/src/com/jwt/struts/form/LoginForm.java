package com.jwt.struts.form;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	private File fileName;
	private String fileNames;
	private String newFileName;
	private String fileId;
	private String userId;
	private List<LoginForm> file = new ArrayList<LoginForm>();
	private FormFile files;
	private String fileType;
	private String creator;
	
	@Override
	public String toString() {
		return "LoginForm [fileNames=" + fileNames + ", fileId=" + fileId + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public File getFileName() {
		return fileName;
	}

	public void setFileName(File fileName) {
		this.fileName = fileName;
	}

	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public List<LoginForm> getFile() {
		return file;
	}

	public void setFile(List<LoginForm> file) {
		this.file = file;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public FormFile getFiles() {
		return files;
	}

	public void setFiles(FormFile files) {
		this.files = files;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
}