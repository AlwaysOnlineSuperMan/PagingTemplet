<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/ajax-nings1.0.js"></script>
<script type="text/javascript">
	function testAjaxPost(){
		var url = "PageServletTest";
		var flag = true;
		var contextDate = "currPage=1";
		ajaxPost(url,flag,contextDate)
	}
	function testAjaxGet(){
		var url = "PageServletTest";
		var SendcontextDate = "currPage=3&currRecord=4";
		var flag = true;
		var urlOrSendcontextDate = url+"?"+SendcontextDate;
		ajaxGet(urlOrSendcontextDate,flag)
	}
</script>
<title>Insert title here</title>
</head>
<body>
<a href="PageServletTest">分页测试一</a>
<a href="PageServlet2">分页测试二</a>
<a href="PageServlet">分页测试三</a>
<a href="fileupload.jsp">文件上传</a>
<a href="pe.jsp">pe</a>
<a href="popWin.jsp">窗体</a>
<a href="popWin2.jsp">窗体2</a>
<input type="button" value="testAjaxPost" onclick="testAjaxPost()">
<input type="button" value="testAjaxGet" onclick="testAjaxGet()">
<div id="msg">

</div>
</body>
</html>