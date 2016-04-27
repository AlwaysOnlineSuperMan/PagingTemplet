/*!
 * @(#)ajax-nings1.0.js	 
 *
 * Author: nings
 * 
 * Date: 2016-03-23
 *
 * Copyright 2005-2009 Client Service International, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * 说明：Asynchronous Javascript And Xml
 * 同步asyncflag=true：send()执行完成，等服务器响应结束才执行后面代码 提交——获取到响应，这个期间，前台是“用户体验空白期” 用户无法点击(获取不到焦点)页面上任何组件，如果有多个请求要求服务器的同一个路径处理，必须排队 所有的form的提交，包括超级链接都是同步提交 document.forms[0].submit();//也是同步提
 * 异步asyncflag=false：send()执行完成，马上执行JS代码 提交——获取到响应，这个期间，前台不存在“用户体验空白期”	在前一个请求的处理过程中，前台可以继续做其他的操作 各个请求提交互相不干扰、不影响，无需互相等待、牵制
 * GET提交 ：  数据用url拼接url=transantion?prm1=value1&prm2=value2
 * POST提交：添加设置内容的类型 xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
 * 			  数据一般不要将参数附加到url上(拼接),而是用 postSendcontextDate=prm1=value1&prm2=value2;send(postSendcontextDate),
 */


var STATE0_UNINIT = "请求未初始化 ,还没调用open()....";
var STATE1_LOADING = "请求已经建立,但未发送请求send();装载中...";
var STATE2_LOADED = "请求已经发送,正在处理中...";
var STATE3_INTERACTIVE = "请求处理中,响应了部分数据,但服务器未响应完成...";
var STATE4_END = "服务器响应完成!"

var TIMEOUT = 30000;

var xmlHttp;
//新建相对应浏览器Ajax异步请求XMLHttpRequest对象
//var xmlHttp = window.ActiveXObject ? new ActiveXObject("Microsoft.XMLHTTP") : new XMLHttpRequest();
function createXmlHttp() {
	try {
		xmlHttp = new XMLHttpRequest();
		console.info("createXmlHttp:XMLHttpRequest");
	} catch (tryicrosoft) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			console.info("createXmlHttp:Msxml2.XMLHTTP");
		} catch (othermicrosoft) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				console.info("createXmlHttp:Microsoft.XMLHTTP");
			} catch (e) {
				xmlHttp = false;
			}
		}
	}
	if (!xmlHttp){
		console.info("Error initializing XMLHttpRequest");
		alert("Error initializing XMLHttpRequest");}
}

function ajaxPost(url, asyncflag, postSendcontextDate) {
	//escape(s)
	createXmlHttp();
	/*
	 * var xmlhttp;
	 * 
	 * if(window.XMLHttpRequest){ xmlHttp = new XMLHttpRequest; }else
	 * if(window.ActiveObject){ xmlHttp = new ActiveObject("Microsoft.XMLHTTP"); }
	 */
	// 对url进行UTF-8编码
	url = encodeURI(url);
	// var asyncflag = asyncflag;// ture:同步 false:异步
	// 设置请求信息 xmlHttp.open(提交方式,路径,异步同步开关); (还没发送服务器)
	xmlHttp.open("post", url, asyncflag);
	// 设置回调函数:监听器(观察员)， 只要状态发生了变化，就会去执行函数里面的逻辑
	xmlHttp.onreadystatechange = function() {
		// alert(xhr.readystate+":"+xhr.status);
		var readyStateVar = xmlHttp.readyState;
		{
			switch (readyStateVar) {
			case 0:
				window.status = STATE0_UNINIT;
				break;
			case 1:
				window.status = STATE1_LOADING;
				break;
			case 2:
				window.status = STATE2_LOADED;
				break;
			case 3:
				window.status = STATE3_INTERACTIVE;
				break;
			case 3:
				window.status = STATE4_END;
				break;
			}
			console.info(window.status);
		}
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var resultText = xmlHttp.responseText;
			// alert(resultText);
			clearTimeout(cleaeTo)
			document.getElementById("msg").innerHTML = resultText;
		}
	}
	// 对于POST提交，url的编码需要JS来手动申明
	// 以前的form标签,会自动为你申明
	xmlHttp.setRequestHeader("content-type",
			"application/x-www-form-urlencoded");
	var cleaeTo = setTimeout(function(){
		// OOP.cancel = true;	
		    xmlHttp.abort();
		    console.info("Rade Time Out...");
		    alert("Rade Time Out...");
	}, TIMEOUT);
	xmlHttp.send(postSendcontextDate);
}

function ajaxGet(urlOrSendcontextDate, flag) {
	createXmlHttp();
	/*
	 * var xmlhttp; // 获取Ajax的相对应浏览器XMLHttpRequest对象 if(window.XMLHttpRequest){
	 * xmlHttp = new XMLHttpRequest; }else if(window.ActiveObject){ xmlHttp =
	 * new ActiveObject("Microsoft.XMLHTTP"); }
	 */
	// 对url进行UTF-8编码
	urlOrSendcontextDate = encodeURI(urlOrSendcontextDate);
	// 申请一个请求(还没发送服务器)
	xmlHttp.open("get", urlOrSendcontextDate, flag);
	// 设置回调函数
	xmlHttp.onreadystatechange = function() {
		// alert(xmlHttp.readyState+":"+xmlHttp.status);
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var resultText = xmlHttp.responseText;
			document.getElementById("msg").innerHTML = resultText;
		}
	}
	xmlHttp.send();
}

