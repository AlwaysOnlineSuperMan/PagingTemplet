package com.nings.testservlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.DiskFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Servlet implementation class UploadImagesToService
 */
public class UploadImagesToService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImagesToService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("/upload"));
		factory.setSizeThreshold(1024*1024);
		
		String path = request.getRealPath("upload");
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()){
					
				}else {
					String name =fileItem.getFieldName();
					String value =   fileItem.getName();
					int start = value.lastIndexOf("\\");
					String fileName= value.substring(start+1);
					try {
						fileItem.write(new File(path,fileName));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			}
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		/*MultipartHttpServletRequest mhr = (MultipartHttpServletRequest)request;
		Iterator i = mhr.getFileNames();
		while(i.hasNext()){
			String tmp = (String)i.next();
		}
		

		MultipartFile mfile = null;
		String Cardtype=request.getParameter("Cardtype1");
		String Identityno=request.getParameter("Identityno1");
		String Pric=request.getParameter("Pric");
		
		if ("1".equals(Pric)) {  //第一张图片
			mfile =mhr.getFile("uploadTitleFile");
		}else if("2".equals(Pric))  {
			mfile =mhr.getFile("uploadTitleFile1");
		}
		long uploadSize = mfile.getSize();
		//判断上传附件大小是否合法
	//	if(uploadSize<Long.parseLong(uploadMaxSize)){
			try {
				
				if ("1".equals(Pric)) {  //第一张图片
					
					byte[] img = mfile.getBytes();
					String imgDataStr = "";//SerializationUtils.serialize2GZIPXml(img);
					
				}else if("2".equals(Pric))  {//第二张图片
					byte[] img1 = mfile.getBytes();
					String imgDataStr1 = "";//SerializationUtils.serialize2GZIPXml(img1);
				}
				
			} catch (IOException e) {
			} finally{

				try {
					mfile.getInputStream().close();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
