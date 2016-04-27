package com.nings.testservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nings.util.JDBCBaseDao;

/**
 * Servlet implementation class WeblogicTestJDBC
 */
public class WeblogicTestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeblogicTestJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection conn = JDBCBaseDao.getConn();
			String sql = "SELECT * FROM MCUTILITIESEXPENSEITEM WHERE UTILITIESCODE=? or 1=1";
			PreparedStatement statem = conn.prepareStatement(sql);
			statem.setObject(1,1);
			ResultSet rs = statem.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("UTILITIESCODE")+rs.getString(2)+rs.getString(3));
			}
			JDBCBaseDao.closeAll(conn, statem, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
