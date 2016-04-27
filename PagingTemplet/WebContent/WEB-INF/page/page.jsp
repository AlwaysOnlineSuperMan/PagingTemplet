<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页测试</title>
<jsp:include page="/WEB-INF/common/CommonVariables.jsp" />
</head>
<body>
	<form action="PageServlet" method="post">
	
	项目名称:<input type="text" id="UtilitiesName" name="UtilitiesName">
	交易码:<input type="text" id="TransCode" name="TransCode"><button width="20" onclick="submit()">查询</button>
		<table>
			<tr>
				<th>图片路径</th>
				<th>项目编号</th>
				<th>项目名称</th>
				<th>渠道标识</th>
				<th>交易码</th>
				<th>排序</th>
			</tr>
			<c:if test="${not empty PagingTemplet.resultList}">
				<c:forEach items="${PagingTemplet.resultList }" var="curr">
					<tr>
						<td><img   src="paymentImgs/${curr.imagePath }"> </td>
						<td>${curr.utilitiesCode }</td>
						<td>${curr.utilitiesName }</td>
						<td>${curr.channelId }</td>
						<td>${curr.transCode}</td>
						<td>${curr.sort }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<jsp:include page="/WEB-INF/common/PaginTempletNavigate.jsp" /> 
	</form>
		 
</body>
</html>

