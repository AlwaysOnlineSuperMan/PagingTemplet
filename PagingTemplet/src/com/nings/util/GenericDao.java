package com.nings.util;
import java.lang.reflect.Field;
import java.security.Policy.Parameters;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 * @author       nings 
 * 使用说明：
 *	1、实体类名必须与表名一致，属性名必须与列名一致;
 *  2、必须是id为主键，并且是自动增长，序列名还必须是seq_表名_id;
 *  3、主键在实体类里的属性中必须放在第一个;
 *	建议：
 *		所有的表实体类 
			new T() 一个无参的构造方法,利于查询所有; 
			new T(ID) 再一个带第一行字段(实体类中对应表中的主键/唯一键)的构造方法,利于根据ID查询和删除;
			new  T(id .....)  还一个带所有参数的构造方法,利于修改;
			new T(......) 还一个除了主键带所有参数的构造方法,利于添加;
 */
public class GenericDao<T> {
		/*
		 * @method       查询所有数据
		 * @param Tobjct 传入一个无参实体相应的要查询的表对象T Tobject=new T();
		 * @return		  返回查询的表对象的集合 
		 */
		public List<T> selectAll(T Tobjct){
			Class clazz=Tobjct.getClass();
			List<T> TobjectList=new ArrayList<T>();
			Connection conn=JDBCBaseDao.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from "+clazz.getSimpleName();
			System.out.println("查询所有SQL语句： "+sql);
			try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					while (rs.next()) {
						T NewTobject=(T) clazz.newInstance();
						Field[] field=clazz.getDeclaredFields();
						for (Field f : field) {
							String fName=f.getName();
							String fType=f.getType().getName();
							f.setAccessible(true);
							if (fType.equals(int.class.getName()) || fType.equals(Integer.class.getName())) {
									f.set(NewTobject, rs.getInt(fName));
							}else if (fType.equals(double.class.getName()) || fType.equals(Double.class.getName())) {
								f.set(NewTobject, rs.getDouble(fName));
							}else if (fType.equals(String.class.getName())) {
								f.set(NewTobject, rs.getString(fName));
							}else if (fType.equals(Date.class.getName())) {
								f.set(NewTobject, rs.getDate(fName));
							}else {
								f.set(NewTobject, rs.getObject(fName));
							}
						}
						TobjectList.add(NewTobject);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCBaseDao.closeAll(conn, pstmt, rs);
			}
				return TobjectList;
		}
		/*
		 * @method       根据ID查询相应的数据
		 * @param Tobjct 传入一个带第一行字段参数相应的要查询的表实体对象
		 * @return		  返回查询的表对象或为空 
		 */
		public T selectById(T Tobjct){
			Connection conn=JDBCBaseDao.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Class clazz=Tobjct.getClass();
			String sql="select * from "+clazz.getSimpleName()+" where "+clazz.getDeclaredFields()[0].getName()+"=?";
			System.out.println("根据ID查询的SQL语句："+sql);
			T NewTobject=null;
			try {
					pstmt=conn.prepareStatement(sql);
					Field ft=clazz.getDeclaredFields()[0];
					ft.setAccessible(true);
					pstmt.setObject(1, ft.get(Tobjct));
					rs=pstmt.executeQuery();
					while (rs.next()) {
						NewTobject=(T) clazz.newInstance();
						Field[] field=clazz.getDeclaredFields();
						for (Field f : field) {
							String fName=f.getName();
							String fType=f.getType().getName();
							f.setAccessible(true);
							if (fType.equals(int.class.getName()) || fType.equals(Integer.class.getName())) {
									f.set(NewTobject, rs.getInt(fName));
							}else if (fType.equals(double.class.getName()) || fType.equals(Double.class.getName())) {
								f.set(NewTobject, rs.getDouble(fName));
							}else if (fType.equals(String.class.getName())) {
								f.set(NewTobject, rs.getString(fName));
							}else if (fType.equals(Date.class.getName())) {
								f.set(NewTobject, rs.getDate(fName));
							}else {
								f.set(NewTobject, rs.getObject(fName));
							}
						}
					}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCBaseDao.closeAll(conn, pstmt, rs);
			}
				return NewTobject;
		}
		/*
		 * @method       添加相应的数据
		 * @param Tobjct 传入带所有参数相应的要添加的表实体对象
		 * @return		  返回添加的表对象是否成功 
		 */
		public boolean insert(T Tobjct){
			boolean bool=false;
			Connection conn=JDBCBaseDao.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Class clazz=Tobjct.getClass();
			String TableName=clazz.getSimpleName();
			StringBuffer columns=new StringBuffer();
			StringBuffer values=new StringBuffer();
			Field[] fields =	clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f=fields[i];
				String fName=f.getName();
				columns.append(fName);
				if("id".equalsIgnoreCase(fName)) {
					values.append("seq_"+TableName + "_" + fName + ".nextval");
				} else {
					values.append("?");
				}
				if (i<fields.length-1) {
					columns.append(",");
					values.append(",");
				}
			}
			String sql="insert into "+ TableName+"("+columns+")"+"values("+values+")";
			System.out.println(sql);
			try {
					pstmt=conn.prepareStatement(sql);
					int index = 1;
					for (Field f : fields) {
						String fname = f.getName();
						if("id".equalsIgnoreCase(fname)) continue;
						f.setAccessible(true);
						pstmt.setObject(index, f.get(Tobjct));
						index++;
					}
					int count=pstmt.executeUpdate();
					if(count>0) bool=true;				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				JDBCBaseDao.closeAll(conn, pstmt, null);
			}
				return bool;
		}
		/*
		 * @method       修改相应的数据
		 * @param Tobjct 传入带所有参数相应的要修改的表实体对象
		 * @return		  返回修改的表对象是否成功 
		 */
		public boolean update(T Tobjct){
			boolean bool=false;
			Connection conn=JDBCBaseDao.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Class clazz=Tobjct.getClass();
			String TableName=clazz.getSimpleName();
			String ID_Value=null;
			StringBuffer columns_values=new StringBuffer();
			Field[] fields =	clazz.getDeclaredFields();
			try {
			for (int i = 0; i < fields.length; i++) {
				Field f=fields[i];
				String fName=f.getName();
				f.setAccessible(true);
				columns_values.append(fName+"=?");
				if(i<fields.length-1)columns_values.append(",");
			}
			String sql=" update  "+ TableName+" set "+columns_values+" where "+fields[0].getName()+"=?";
			System.out.println(sql);
					pstmt=conn.prepareStatement(sql);
					int index = 1;
					for (Field f : fields) {
						String fname = f.getName();
						f.setAccessible(true);
						pstmt.setObject(index, f.get(Tobjct));
						index++;
					}
					fields[0].setAccessible(true);
					pstmt.setObject(index,fields[0].get(Tobjct));
					int count=pstmt.executeUpdate();
					if(count>0) bool=true;				
			} catch (Exception e) {
				e.printStackTrace();
			}  finally{
				JDBCBaseDao.closeAll(conn, pstmt, null);
			}
				return bool;
		}
		/*
		 * @method       根据ID查询相应的数据
		 * @param Tobjct 传入一个带第一行字段参数相应的要删除的表实体对象
		 * @return		  返回查询的表对象或为空 
		 */
		public boolean deleteById(T Tobjct){
			boolean bool=false;
			Connection conn=JDBCBaseDao.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Class clazz=Tobjct.getClass();
			String sql="delete from "+clazz.getSimpleName()+" where "+clazz.getDeclaredFields()[0].getName()+"=?";
			System.out.println(sql);
			T NewTobject=null;
			try {
					pstmt=conn.prepareStatement(sql);
					Field ft=clazz.getDeclaredFields()[0];
					ft.setAccessible(true);
					pstmt.setObject(1, ft.get(Tobjct));		
					if(pstmt.executeUpdate()>0){
						bool=true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCBaseDao.closeAll(conn, pstmt, rs);
			}
				return bool;
			}
			
}
