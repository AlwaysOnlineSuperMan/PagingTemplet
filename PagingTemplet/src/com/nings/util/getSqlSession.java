package com.nings.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class getSqlSession {
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sessionFactory;
	
	static{
		if(sessionFactory==null){
		 try {
			InputStream  input = Resources.getResourceAsStream("MyBatiesMySQL.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(input);
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	public  static SqlSession getSession(){
		SqlSession o = tl.get();
		SqlSession conn = null;
		if(o==null){
		 conn  =sessionFactory.openSession();
			tl.set(conn);
		}else{
			conn = o;
			
		}
		return conn;
	}
	
	
	public static void clare(){
		SqlSession s= tl.get();
		if(s!=null){
			s.close();
			tl.remove();
			tl.set(null);
		}
	}
}
