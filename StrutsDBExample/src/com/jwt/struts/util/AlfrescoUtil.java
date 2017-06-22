package com.jwt.struts.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConstraintException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;

import com.jwt.struts.form.LoginForm;

public class AlfrescoUtil {

	public static final String ALFRESCO_API_URL = "http://localhost:8080/";
	public static final String USER_NAME = "admin";
	public static final String PASSWORD = "admin";
	public static final String ATOMPUB_URL = ALFRESCO_API_URL + "alfresco/cmisatom"; // 4.2d
	public static final String REPOSITORY_ID = "e0888eeb-e7fb-42f2-bfde-defcdaa89a83";
	public static final String FOLDER_NAME = "/u_";
	public static final String FILE_TYPE = "image/jpeg";
	public static final String FOLDER_PATH = "/user";
	public static final String destinationFolder = "D:/ec/New folder/";
	public static final String PUBLICFOLDER = "/public";

	public static Session getCmisSession() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SessionParameter.USER, "admin");
		parameters.put(SessionParameter.PASSWORD, "admin");
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(SessionParameter.ATOMPUB_URL, "http://localhost:8080/alfresco/service/cmis");
		parameters.put(SessionParameter.REPOSITORY_ID, REPOSITORY_ID);
		SessionFactory factory = SessionFactoryImpl.newInstance();
		List<Repository> repositories = factory.getRepositories(parameters);
		Session session = repositories.get(0).createSession();
		return session;
	}

	public static ItemIterable<CmisObject> getParentFolder() {
		Session session = getCmisSession();
		Folder root = session.getRootFolder();
		ItemIterable<CmisObject> children = root.getChildren();
		Folder parentFolder = getParentFolder(session);
		System.out.println("parent folder " + parentFolder.getChildren());
		return children;
	}

	public static List<LoginForm> showFolder(String userId) {
		Session session = getCmisSession();
		Folder parentFolder = getParentFolder(session);
		List<String> paths = parentFolder.getPaths();
		for (String o : paths) {
			System.out.println("AlfrescoUtil.showFolder() "+o);
		}
		CmisObject object = session.getObject(session.getObjectByPath(parentFolder.getPath() + FOLDER_NAME + userId));
		CmisObject objectOne = session.getObject(session.getObjectByPath(parentFolder.getPath() + PUBLICFOLDER));
		Folder folder = (Folder) object;
		Folder folderOne = (Folder) objectOne;
		ItemIterable<CmisObject> children = folder.getChildren();
		ItemIterable<CmisObject> childrens = folderOne.getChildren();
		List<LoginForm> files = new ArrayList<LoginForm>();
		for (CmisObject o : children) {
			LoginForm form = new LoginForm();
			form.setFileNames(o.getName());
			form.setFileId(o.getId());
			files.add(form);
		}
		for (CmisObject o : childrens) {
			LoginForm form = new LoginForm();
			form.setFileNames(o.getName());
			form.setFileId(o.getId());
			files.add(form);
		}
		return files;
	}

	public static Folder createFolders(String username, String userId) {
		Folder subFolder = null;
		Session cmisSession = getCmisSession();
		Folder parentFolder = getParentFolder(cmisSession);
		createPublicFolders();
		try {
			subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + FOLDER_NAME + userId);
			System.out.println(" - Folder already existed!" + subFolder.getName());
		} catch (CmisObjectNotFoundException onfe) {
			Map<String, Object> props = new HashMap<String, Object>();
			subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath());
			props.put("cmis:objectTypeId", "cmis:folder");
			props.put("cmis:name", "u_" + userId);
			subFolder = subFolder.createFolder(props);
			String subFolderId = subFolder.getId();
			System.out.println("Created new folder: " + subFolderId);
		}
		return subFolder;
	}

	public static Folder createPublicFolders() {
		Folder subFolder = null;
		Session cmisSession = getCmisSession();
		Folder parentFolder = getParentFolder(cmisSession);
		try {
			subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + PUBLICFOLDER);
			System.out.println(" - Folder already existed!" + subFolder.getName());
		} catch (CmisObjectNotFoundException onfe) {
			Map<String, Object> props = new HashMap<String, Object>();
			subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath());
			props.put("cmis:objectTypeId", "cmis:folder");
			props.put("cmis:name", PUBLICFOLDER);
			subFolder = subFolder.createFolder(props);
			String subFolderId = subFolder.getId();
			System.out.println("Created new folder: " + subFolderId);
		}
		return subFolder;
	}

	public static Folder getParentFolder(Session cmisSession) {
		Folder folder = (Folder) cmisSession.getObjectByPath(FOLDER_PATH);
		return folder;
	}

	public static Document createDocument(File file, String userName, String userId, String type)
			throws FileNotFoundException {
		System.out.println(type);
		String fileName = file.getName();
		String filepath = file.getAbsolutePath();
		Map<String, Object> props = null;
		Session cmisSession = getCmisSession();
		Folder parentFolder = getParentFolder(cmisSession);
		Folder subFolder;
		if (props == null) {
			props = new HashMap<String, Object>();
		}
		if (props.get("cmis:objectTypeId") == null) {
			props.put("cmis:objectTypeId", "cmis:document");
		}
		if (props.get("cmis:name") == null) {
			props.put("cmis:name", fileName);
		}
		ContentStream contentStream = cmisSession.getObjectFactory().createContentStream(fileName, file.length(),
				FILE_TYPE, new FileInputStream(filepath));
		Document document = null;
		if (type == "private") {
			try {
				subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + FOLDER_NAME + userId);
				document = subFolder.createDocument(props, contentStream, null);
				System.out.println("Created new document: " + document.getId());
			} catch (CmisContentAlreadyExistsException ccaee) {
				System.out.println("Document already exists: " + fileName);
			} catch (CmisConstraintException e) {
				System.out.println("Document already exists: " + fileName + " " + document.getId());
			}
		} else {
			subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + PUBLICFOLDER);
			document = subFolder.createDocument(props, contentStream, null);
			System.out.println("Created new document: " + document.getId());
		}
		return document;
	}

	public static boolean deleteDocument(String pathOrIdOfObject, String userId) throws FileNotFoundException {
		Session cmisSession = getCmisSession();
		CmisObject object = getObject(pathOrIdOfObject, cmisSession);
		object.delete();
		return true;
	}

	public static CmisObject getObject(String pathOrIdOfObject, Session session) {
		if (session == null) {
			throw new IllegalArgumentException("session must be set!");
		}
		if (pathOrIdOfObject == null || pathOrIdOfObject.length() == 0) {
			throw new IllegalArgumentException("pathOrIdOfObject must be set!");
		}
		CmisObject result = null;
		if (pathOrIdOfObject.charAt(0) == '/') {
			result = session.getObjectByPath(pathOrIdOfObject);
		} else {
			result = session.getObject(pathOrIdOfObject);
		}
		return result;
	}

	public static void downloadDocumentByID(String documentID, String name, String userId) {

		String fullPath = destinationFolder + name;
		Document newDocument = (Document) getCmisSession().getObject(documentID);
		try {
			ContentStream cs = newDocument.getContentStream(null);
			BufferedInputStream in = new BufferedInputStream(cs.getStream());
			FileOutputStream fos = new FileOutputStream(fullPath);
			OutputStream bufferedOutputStream = new BufferedOutputStream(fos);
			byte[] buf = new byte[1024];
			int n = 0;
			while ((n = in.read(buf)) > 0) {
				bufferedOutputStream.write(buf, 0, n);
			}
			bufferedOutputStream.close();
			fos.close();
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}
}