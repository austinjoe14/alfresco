package com.jwt.struts.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.QueryResult;
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
import org.apache.commons.io.FilenameUtils;
import org.apache.struts.upload.FormFile;

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
	public static final String sourceFolder = "C:/Users/austina/AppData/Local/Temp/";
	public static final String sourceFolders = "D:/gitpart/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/StrutsDBExample/";

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
			form.setCreator(o.getCreatedBy());
			files.add(form);
		}
		for (CmisObject o : childrens) {
			LoginForm form = new LoginForm();
			form.setFileNames(o.getName());
			form.setFileId(o.getId());
			form.setCreator(o.getCreatedBy());
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

	public static Document createDocument(FormFile formFile, String userName, String userId, String type, String path)
			throws FileNotFoundException {
		System.out.println(type);
		Map<String, Object> props = null;
		Session cmisSession = getCmisSession();
		Folder parentFolder = getParentFolder(cmisSession);
		Folder subFolder;
		long filesize = formFile.getFileSize();
		String file = formFile.toString();
		System.out.println(filesize);
		System.out.println(formFile.getFileName());
		String ext1 = FilenameUtils.getExtension(file);
		System.out.println("---------------------------------------------------------");
		System.out.println(ext1);
		if (props == null) {
			props = new HashMap<String, Object>();
		}
		if (props.get("cmis:objectTypeId") == null) {
			props.put("cmis:objectTypeId", "cmis:document");
		}
		if (props.get("cmis:name") == null) {
			props.put("cmis:name", formFile.getFileName());
		}
		props.put("cmis:createdBy", userName);
		ContentStream contentStream = cmisSession.getObjectFactory().createContentStream(file, filesize, FILE_TYPE,
				new FileInputStream(file));
		Document document = null;
		if (type.equals("private")) {
			System.out.println("inside");
			try {
				subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + FOLDER_NAME + userId);
				document = subFolder.createDocument(props, contentStream, null);
				System.out.println("Created new document: " + document.getId());
			} catch (CmisContentAlreadyExistsException ccaee) {
				System.out.println("Document already exists: " + formFile.getFileName());
			} catch (CmisConstraintException e) {
				System.out.println("Document already exists: " + formFile.getFileName() + " " + document.getId());
			}
		} else {
			try {
				subFolder = (Folder) cmisSession.getObjectByPath(parentFolder.getPath() + PUBLICFOLDER);
				document = subFolder.createDocument(props, contentStream, null);
				System.out.println("Created new document: " + document.getId());
			} catch (CmisContentAlreadyExistsException ccaee) {
				System.out.println("Document already exists: " + formFile.getFileName());
			} catch (CmisConstraintException e) {
				System.out.println("Document already exists: " + formFile.getFileName() + " " + document.getId());
			}
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
		
		Document newDocument = (Document) getCmisSession().getObject(documentID);
		String file = newDocument.getName();
		String ext1 = FilenameUtils.getExtension(file);
		String fullPath = destinationFolder + name+"."+ext1;
		System.out.println("---------------------------------------------------------");
		System.out.println(ext1);
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

	public static List<LoginForm> search(String name, String userId) {
		Session session = getCmisSession();
		System.out.println(name);
		Folder parentFolder = getParentFolder(session);
		CmisObject object = session.getObjectByPath(parentFolder.getPath() + FOLDER_NAME + userId);
		CmisObject objectOne = session.getObjectByPath(parentFolder.getPath() + PUBLICFOLDER);
		System.out.println(object);
		String queryOne = "SELECT * FROM cmis:document WHERE cmis:name LIKE '" + name + "%' and (in_folder('"
				+ objectOne.getId() + "') or in_folder('" + object.getId() + "'))";
		ItemIterable<QueryResult> queryResults = session.query(queryOne, false);
		List<LoginForm> files = new ArrayList<LoginForm>();
		int i = 1;
		for (QueryResult result : queryResults) {
			System.out.println("--------------------parent-------------------");
			System.out.println("--------------------------------------------\n" + i + " , "
					+ result.getPropertyByQueryName("cmis:objectTypeId").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:name").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:createdBy").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:objectId").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:contentStreamFileName").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:contentStreamMimeType").getFirstValue() + " , "
					+ result.getPropertyByQueryName("cmis:contentStreamLength").getFirstValue());
			i++;
			LoginForm form = new LoginForm();
			String names = (String) result.getPropertyByQueryName("cmis:name").getFirstValue();
			form.setFileNames(names);
			String id = (String) result.getPropertyByQueryName("cmis:objectId").getFirstValue();
			form.setFileId(id);
			files.add(form);
		}
		return files;
	}

	public static void zipFiles(List<String> files, String newName, String userId) {
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		String fullPath = destinationFolder + newName + ".zip";
		try {
			fos = new FileOutputStream(fullPath);
			zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			for (String filePath : files) {
				Document newDocument = (Document) getCmisSession().getObject(filePath);
				ContentStream cs = newDocument.getContentStream(null);
				BufferedInputStream in = new BufferedInputStream(cs.getStream());
				ZipEntry ze = new ZipEntry(newDocument.getName());
				System.out.println("Zipping the file: " + newDocument.getName());
				zipOut.putNextEntry(ze);
				byte[] tmp = new byte[4 * 1024];
				int size = 0;
				while ((size = in.read(tmp)) != -1) {
					zipOut.write(tmp, 0, size);
				}
				zipOut.flush();
				in.close();
			}
			zipOut.close();
			System.out.println("Done... Zipped the files...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ex) {

			}
		}
	}

}