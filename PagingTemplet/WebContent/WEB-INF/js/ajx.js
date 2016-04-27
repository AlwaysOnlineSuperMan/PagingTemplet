/*!
 * @author nings
 * ajax Library v1.0
 * Date: 2016-03-23
 * 说明：
 * 异步asyncflag=false：send()执行完成，马上执行JS代码
 * 同步asyncflag=true：send()执行完成，等服务器响应结束才执行后面代码
 * GET提交 ：  数据用url拼接url=transantion?prm1=value1&prm2=value2
 * POST提交：添加设置内容的类型 xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
 * 			  数据一般不要将参数附加到url上(拼接),而是用 postSendcontextDate=prm1=value1&prm2=value2;send(postSendcontextDate),
 */

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
			alert(resultText);
		}
	}
	//对于POST提交，url的编码需要JS来手动申明
	//以前的form标签,会自动为你申明
	xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xmlHttp.send(postSendcontextDate);
 }
 
 

 function ajaxGet(urlOrSendcontextDate,flag){
		var xmlhttp;
		// 获取Ajax的相对应浏览器XMLHttpRequest对象
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest;
		}else if(window.ActiveObject){
			xmlHttp = new ActiveObject("Microsoft.XMLHTTP");
		}
		// 对url进行UTF-8编码
		urlOrSendcontextDate = encodeURI(urlOrSendcontextDate);
		// 申请一个请求(还没发送服务器)
		xmlHttp.open("get",urlOrSendcontextDate,flag);
		// 设置回调函数
		xmlHttp.onreadystatechange = function(){
			//alert(xmlHttp.readyState+":"+xmlHttp.status);
			if(xmlHttp.readyState ==4 && xmlHttp.status == 200){
				var resultText = xmlHttp.responseText;
				document.getElementById("msg").innerHTML=resultText;
			}
		}
		xmlHttp.send();
	 }