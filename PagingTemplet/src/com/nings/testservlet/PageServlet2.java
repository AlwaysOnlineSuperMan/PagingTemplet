package com.nings.testservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nings.entity.MCUtilitiesExpenseItem;
import com.nings.util.getSqlSession;

/**
 * Servlet implementation class PageServlet2
 */
public class PageServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map conditionMap = new HashMap();
			conditionMap.put("UtilitiesName", "");
			conditionMap.put("TransCode","");
			String sql = "com.nings.dao.MCUtilitiesExpenseItemMapper.selectByAll2";
			List<MCUtilitiesExpenseItem> list = getSqlSession.getSession().selectList(sql, conditionMap);
			request.setAttribute("List", list);
			request.getRequestDispatcher("/WEB-INF/page/pageTest2.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
