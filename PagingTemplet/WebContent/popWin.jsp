<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/paymentcss.css" />
<style type="text/css">

#detail2 {
	position: fixed;
	display: none;
	font-size: 14px;
	font-family: "微软雅黑";
	text-align: center;
	background: #f1f1f1;
	
	border: 1px #ccc solid;
	border-radius: 5px;
	-webkit-appearance: none;
}
</style>
<script type="text/javascript">


function testAjaxPost(){
	var url = "PageServletTest";
	var flag = true;
	var contextDate = "currPage=1";
	ajaxPost(url,flag,contextDate)
}
function ajaxPost(url,asyncflag,postSendcontextDate){
	var xmlhttp;
	// 获取Ajax的相对应浏览器XMLHttpRequest对象
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest;
	}else if(window.ActiveObject){
		xmlHttp = new ActiveObject("Microsoft.XMLHTTP");
	}
	// 对url进行UTF-8编码
	url = encodeURI(url);
	//var asyncflag = asyncflag;// ture异步 false同步
	// 申请一个请求(还没发送服务器)
	xmlHttp.open("post",url,asyncflag);
	// 设置回调函数
	xmlHttp.onreadystatechange = function(){
		//alert(xhr.readystate+":"+xhr.status);
		if(xmlHttp.readyState==4 && xmlHttp.status == 200){
			var resultText = xmlHttp.responseText;
			//alert(resultText);
			//document.getElementById("msg").innerHTML=resultText;
			
			
			$("#MessageId2").html(resultText+resultText+resultText);
			$("#MessageId2").css("height",$("#ContentWrap").height()-100);
			$("#MessageId2").css("width",$("#ContentWrap").width()-50);
			popWin("detail2");
		}
	}
	//对于POST提交，url的编码需要JS来手动申明
	//以前的form标签,会自动为你申明
	xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xmlHttp.send(postSendcontextDate);
 }
function showNotice(){
	
	
	testAjaxPost();
	
			
	
}
/***
 * 小鸟弹出层插件，由漫画Jquery弹出层插件改编而来
 * QQ:9169775
 * 编写时间：2013年3月21号
 * version:1.0
***/
function popWin(obj){
	var _z=9000;//新对象的z-index
	var _mv=false;//移动标记
	var _x,_y;//鼠标离控件左上角的相对位置		
	var _obj= $("#"+obj);
	var _wid= _obj.width();
	var _hei= _obj.height();
	var _tit= _obj.find("#MessageId2");
	var _cls =_obj.find("#close");
	var docE =$("#ContentWrap");
	var left=($(document).width()-_obj.width())/2;
	var top =(docE.height()-_obj.height())/2;
	_obj.css({	"left":left,"top":100,"display":"block","z-index":_z-(-1)});
			
			
	$('<div id="maskLayer"></div>').appendTo("body").css({
		"background:url":"images/black30.png","width":"100%","position":"fixed","height":"100%","display":"block", "top":"0", "left":"0", "z-index":"9"
	});
	reModel();
	$(window).bind("resize",function(){reModel();});
	$(document).keydown(function(event) {
		if (event.keyCode == 27) {
			$("#maskLayer").remove();
			_obj.hide();
		}
	});
	function reModel(){
		var b = docE? docE : document.body,
		height = b.scrollHeight > b.clientHeight ? b.scrollHeight : b.clientHeight,
		width = b.scrollWidth > b.clientWidth ? b.scrollWidth : b.clientWidth;
		$("#maskLayer").css({
			"height": height,"width": width
		});
	};
}

function closeIt(clickObj){
	$(clickObj).parent().parent().hide();
	$("#maskLayer").remove();
}
</script>
</head>
<body id="ContentWrap" style="height:600px;min-height:600px;">
<a href ="javascript:showNotice()"style="color:#f1b36e">《协议》</a>
<div id="detail2">
				<div style="margin-bottom: 10px"></div>
				<div id="MessageId2" style="margin-bottom: 10px; overflow:scroll; padding-right:10px;height:550px;"></div>
				<div class="subMit">
				 	<input type="button"  id="close" style="z-index:10000;" value="确认" onclick="closeIt(this)"/>
          		</div>
			</div>
</body>
</html>