package com.nings.testservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;

import com.nings.entity.MCUtilitiesExpenseItem;
import com.nings.util.PagingTemplet;
import com.nings.util.getSqlSession;

public class PageServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PagingTemplet<MCUtilitiesExpenseItem> PagingTemplet = new PagingTemplet<MCUtilitiesExpenseItem>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		int currPage = 1;
		// if(PagingTemplet!=null && PagingTemplet.getCurrPageNo()!=0)currPage=PagingTemplet.getCurrPageNo();
		int currPageValue = 0;
		String currPageParameter = request.getParameter("currPage");
		if (currPageParameter != null && !currPageParameter.equals("")) {
			currPageValue = Integer.valueOf(currPageParameter);
			if (currPageValue > 0) {
				currPage = currPageValue;
			}
		}

		int pageSize = 2;
		//if (PagingTemplet != null && PagingTemplet.getCurrRecord() != 0)pageSize = PagingTemplet.getCurrRecord();
		int currRecordValue = 0;
		String currRecordParameter = request.getParameter("currRecord");
		if (currRecordParameter != null && !currRecordParameter.equals("")) {
			currRecordValue = Integer.valueOf(currRecordParameter);
			if (currRecordValue > 0) {
				pageSize = currRecordValue;
			}
		}
		
		
		Map conditionMap = new HashMap();
		
	//	System.out.println(request.getParameter("UtilitiesName")+"v v" +request.getAttribute("UtilitiesName"));
		
		
		conditionMap.put("currPage", (currPage -1)* pageSize);
		conditionMap.put("pageSize", pageSize);
		conditionMap.put("UtilitiesName", request.getParameter("UtilitiesName"));
		conditionMap.put("TransCode", request.getParameter("TransCode"));
		String sql1 = "com.nings.dao.MCUtilitiesExpenseItemMapper.selectByAll";
		String sql2 = "com.nings.dao.MCUtilitiesExpenseItemMapper.selectByAllCount";

		System.out.println("------begin--------");
		List<MCUtilitiesExpenseItem> resultListCo = getSqlSession.getSession().selectList(sql2, conditionMap);
		List<MCUtilitiesExpenseItem> resultList = getSqlSession.getSession().selectList(sql1, conditionMap);
		System.out.println("------end--------");

		
		
		//getSqlSession.getSession().selectList("", null,new RowBounds(1, 2));
		// --------------------

		// 共allRecord条记录
		PagingTemplet.setAllRecord(resultListCo.size());
		// 每页currRecord条记录
		PagingTemplet.setCurrRecord(pageSize);
		// 共allPageSize页--

		// 当前第currPageNo页
		PagingTemplet.setCurrPageNo(currPage);

		System.out.println("PagingTemplet--" + PagingTemplet.getCurrPageNo());
		// 本页的结果集resultList
		PagingTemplet.setResultList(resultList);

		request.setAttribute("PagingTemplet", PagingTemplet);
		request.getRequestDispatcher("/WEB-INF/page/pageTest.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
