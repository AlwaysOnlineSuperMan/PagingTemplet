package com.nings.util;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 
 * @author nings
 *
 */
public class EncodeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	// 算法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("-----------EncodeFilter Begin---------");
		// =====对输入的编码====
		// 获取表单的提交方式
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		if ("GET".equals(method)) {
			// GET
			Map<String, String[]> map = req.getParameterMap();
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				String[] values = map.get(key);
				for (int i = 0; i < values.length; i++) {
					System.out.println(values[i]);
					values[i] = new String(values[i].getBytes("iso-8859-1"),
							"utf-8");
					System.out.println(values[i]);
				}
			}
		} else {
			// POST
			req.setCharacterEncoding("utf-8");
		}
		// ====对输出的编码====
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("-----------EncodeFilter End---------");

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
