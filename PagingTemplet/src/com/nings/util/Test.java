package com.nings.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import com.nings.entity.MCUtilitiesExpenseItem;




public class Test {
	private static String[] dx ={"零","壹","贰","叁","肆","五",""};
	private static String[] dw = {"元","拾","百","千","万"};
	
	
	public static void main(String[] args) {
		
		
		
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
		
		/*
		
		GenericDao<MCUtilitiesExpenseItem> genericDao =new GenericDao<MCUtilitiesExpenseItem>();
		
		List<MCUtilitiesExpenseItem> list = genericDao.selectAll(new MCUtilitiesExpenseItem());
			
		for (MCUtilitiesExpenseItem mcUtilitiesExpenseItem : list) {
			System.out.println(mcUtilitiesExpenseItem);
		}*/
		
		
		
		
		
	 
        ///* Log lg= LogFactory.getLog(Test.class);
		
	/*	String sql = "com.nings.dao.eip.MCUtilitiesExpenseItemMapper.selectByPrimaryKey";
		Map sendCondition = new HashMap();
		sendCondition.put("UTILITIESCODE", "1");
		sendCondition.put("CHANNELID", "PWEC");
		MCUtilitiesExpenseItem mcUtilitiesExpenseItem = (MCUtilitiesExpenseItem) getSqlSession.getSession().selectOne(sql,  sendCondition);
		System.out.println(mcUtilitiesExpenseItem); */
	  // System.out.println(Test.convert(120));
		//MCUtilitiesExpenseItem v = (MCUtilitiesExpenseItem) getSqlSession.getSession().selectList(sql);
		
		
		
		
		
		
		
		/*
		try {
			Connection conn = JDBC.getconn();
			String sql = "SELECT * FROM MCUTILITIESEXPENSEITEM WHERE UTILITIES_CODE=? or 1=1";
			PreparedStatement statem = conn.prepareStatement(sql);
			statem.setObject(1,1);
			ResultSet rs = statem.executeQuery();
			while (rs.next()) {
				
				System.out.println(rs.getString("UTILITIES_CODE")+rs.getString(2)+rs.getString(3));
			}
			JDBC.clare(statem, conn, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		
		
		
		
		
//System.out.println(AmountToRMBStr(+4141.66755));
	}
	
	
	public static String convert(int m){
		StringBuffer sb = new StringBuffer();
		int i=0;
		while (m/10!=0) {
			sb.append(dx[m%10]+""+ dw[i++]);
			m=m/10;
		}
		return sb.toString();
	}
	
	private final static String HanDigiStr[] = new String[] { "零", "壹", "贰",
			"叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	private final static String HanDiviStr[] = new String[] { "", "拾", "佰",
			"仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟",
			"亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };

	public final static String AmountToRMBStr(double val)  {
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		int jiao, fen;

		if (val < 0) {
			val = -val;
			SignStr = "负";
		}
		 // return "数值位数过大!";
			// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) {
			TailStr = "整";
		} else {
			TailStr = HanDigiStr[jiao];
			if (jiao != 0)
				TailStr += "角";
			if (integer == 0 && jiao == 0) // 零元后不写零几分
				TailStr = "";
			if (fen != 0)
				TailStr += HanDigiStr[fen] + "分";
		}

		// 下一行可用于非正规金融场合，0.03只显示“叁分”而不是“零元叁分”
		// if( !integer ) return SignStr+TailStr;
		return "￥" + SignStr + PositiveIntegerToHanStr(String.valueOf(integer))
				+ "元" + TailStr;
	}
	private static final String PositiveIntegerToHanStr(String NumStr)
			  { // 输入字符串必须正整数，只允许前导空格(必须右对齐)，不宜有前导零
		String RMBStr = "";
		boolean lastzero = false;
		boolean hasvalue = false; // 亿、万进位前有数值标记
		int len, n;
		len = NumStr.length();
		 
		for (int i = len - 1; i >= 0; i--) {
			if (NumStr.charAt(len - i - 1) == ' ')
				continue;
			n = NumStr.charAt(len - i - 1) - '0';
			 

			if (n != 0) {
				if (lastzero)
					RMBStr += HanDigiStr[0]; // 若干零后若跟非零值，只显示一个零
				// 除了亿万前的零不带到后面
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// 如十进位前有零也不发壹音用此行
				if (!(n == 1 && (i % 4) == 1 && i == len - 1)) // 十进位处于第一位不发壹音
					RMBStr += HanDigiStr[n];
				RMBStr += HanDiviStr[i]; // 非零值后加进位，个位为空
				hasvalue = true; // 置万进位前有值标记

			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) // 亿万之间必须有非零值方显示万
					RMBStr += HanDiviStr[i]; // “亿”或“万”
			}
			if (i % 8 == 0)
				hasvalue = false; // 万进位前有值标记逢亿复位
			lastzero = (n == 0) && (i % 4 != 0);
		}

		if (RMBStr.length() == 0)
			return HanDigiStr[0]; // 输入空字符或"0"，返回"零"
		return RMBStr;
	}
}
