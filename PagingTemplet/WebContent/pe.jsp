<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/ajax.js_zh_CN"></script>
<script type="text/javascript">
function ds(){
var oparams = new Array(new Pair("currPage", "1"),new Pair("currRecord", "2"));
postData2SRVWithCallback("PageServletTest", PEGetPostData(oparams), function(success, message){
	 alert(success);	
	 alert(message);
	 $("#msg").html(message);
	 
});
}
</script>
</head>
<body>
	<input type="button" value="ssssss" onclick="ds()">
	<div id="msg">

</div>
</body>
</html>