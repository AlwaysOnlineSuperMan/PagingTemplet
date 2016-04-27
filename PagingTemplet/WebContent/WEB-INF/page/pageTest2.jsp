<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<jsp:include page="/WEB-INF/common/CommonVariables.jsp" />
<script type="text/javascript" src="js/jquery.easypage.js"></script>
<script type="text/javascript">
	//contentclass   要分页内容的class名称 默认的为contentlist
	//navigateid		 放置导航按钮的位置id 默认为mynavigate
	//everycount 		 每页显示多少个
	//navigatecount	 导航按钮开始显示多少个，从第二个开始显示为双倍	
	$(function() {
		$.easypage({
			'contentclass' : 'contentlist',
			'navigateid' : 'navigatediv',
			'everycount' : 1,
			'navigatecount' : 5
		});
	})
</script>
</head>

<body>
	<table>
		<tr>
			<th>项目编号</th>
			<th>项目名称</th>
			<th>渠道标识</th>
			<th>交易码</th>
			<th>图片路径</th>
			<th>排序</th>
		</tr>
		<tbody id="contents">
		<c:forEach items="${List }" var="curr">
				<tr class="contentlist">
					<td>${curr.utilitiesCode }</td>
					<td>${curr.utilitiesName }</td>
					<td>${curr.channelId }</td>
					<td>${curr.transCode}</td>
					<td>${curr.imagePath }</td>
					<td>${curr.sort }</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<div id="navigatediv"></div>
</body>
</html>
