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
<base href="<%=basePath %>">
<script type="text/javascript" src="js/PagingTemplet.js"></script>
<div align="center" class="PagingTempletDiv">
	共${PagingTemplet.allRecord}条记录 每页<input type="text" name="currRecord" id="currRecord"
		value="${PagingTemplet.currRecord}" size="2"
		onchange="changeCurrRecord()">条
	第${PagingTemplet.currPageNo}页/共${PagingTemplet.allPageSize}页
	<c:if test="${PagingTemplet.currPageNo<=1}">
		<input type="button" value="已是首页" disabled="disabled" />
		<input type="button" value=" 上一页 " disabled="disabled" />
	</c:if>
	<c:if test="${PagingTemplet.currPageNo >1 }">
		<input type="button" value=" 首页  "
			onclick="pageMode(${PagingTemplet.fristPageNo})" />
		<input type="button" value="上一页"
			onclick="pageMode(${PagingTemplet.previosPageNo})" />
	</c:if>
	<c:if test="${PagingTemplet.currPageNo >= PagingTemplet.allPageSize}">
		<input type="button" value="下一页" disabled="disabled" />
		<input type="button" value=" 已是尾页  " disabled="disabled" />
	</c:if>
	<c:if test="${PagingTemplet.currPageNo < PagingTemplet.allPageSize}">
		<input type="button" value="下一页"
			onclick="pageMode(${PagingTemplet.nextPageNo})" />
		<input type="button" value=" 尾页    "
			onclick="pageMode(${PagingTemplet.bottomPageNo})" />
	</c:if>
	转到 <input type="text" name="currPage"
		value="${PagingTemplet.currPageNo }" size="2" id="currPage"> 页
	<button width="20" onclick="submit()">GO</button>
</div>