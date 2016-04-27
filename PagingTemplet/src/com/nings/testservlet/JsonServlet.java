package com.nings.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.mybatis.generator.logging.Log;
import org.mybatis.generator.logging.LogFactory;

/**
 * Servlet implementation class JsonServlet
 */
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Log log = LogFactory.getLog(this.getClass());
	/**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserNo = request.getParameter("UserNo");
		String PassWord = request.getParameter("PassWord");
		PrintWriter pw =  response.getWriter();
		System.out.println();
		String jsonVar ="";
		log.debug("-----JsonServlet-----Begin---"+UserNo+" "+PassWord);
		System.out.print("-----JsonServlet-----Begin---"+UserNo+" "+PassWord);
		if("123456".equalsIgnoreCase(PassWord)&&"888888".equalsIgnoreCase(UserNo)){
			jsonVar  = "{'Name':'宁思','JF':'1444'}";	
			//jsonVar  = "<xml><Name>宁思</Name><JF>1444</JF></xml>";
		}else{
			jsonVar = "false";
		}
		System.out.print("-----JsonServlet-----End---"+jsonVar);

		pw.write(jsonVar);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
