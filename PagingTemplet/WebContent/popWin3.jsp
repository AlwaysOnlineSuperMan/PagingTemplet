<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
 
function selectImg(clickObj){
	var showx = (event.screenX - event.offsetX)/2; // + deltaX;
	var showy = (event.screenY - event.offsetY)/2; // + deltaY;
	var obj = new Object();
	obj.imageName = document.getElementById('AdvertImage').value;
	var retval = window.opener.showModalDialog("resultWindos.jsp",obj, "dialogWidth:800px; dialogHeight:750px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;location=no; "  );
	alert(retval);
	if(retval==null||retval=="") return;
	//document.getElementById('image').src="AdvertImageQry.do?AdvertImage="+retval;
	//document.getElementById('imageSpan').style.display="";
	//document.getElementById('AdvertImage').value=retval;
	//document.getElementById('selA').innerHTML="重新选择";
}
 
</script>
</head>
<body id="ContentWrap" style="height: 600px; min-height: 600px;">
<input type="text" id="AdvertImage">
<a href="javascript:selectImg(this)" style="color: #f1b36e">《协议》</a>
<input type="button"  onclick="selectImg(this)" value="cc">
</body>
</html>
