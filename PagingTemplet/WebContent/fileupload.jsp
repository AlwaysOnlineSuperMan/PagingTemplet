<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
 	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path +"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/ajx.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
function setImagePreview() { 
	// $("#localImag").empty();
	var docObj=document.getElementById("uploadTitleFile"); 
	var imgObjPreview=document.getElementById("ImageData"); 
	if(docObj.files && docObj.files[0]){ 
	//火狐下，直接设img属性 
	imgObjPreview.style.display = 'block'; 
	imgObjPreview.style.width = '120px'; 
	imgObjPreview.style.height = '120px'; 
	//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]); 
	}else{ 
	//IE下，使用滤镜 
	docObj.select(); 
	var imgSrc = document.selection.createRange().text; 
	var localImagId = document.getElementById("localImag"); 
	//必须设置初始大小 
	localImagId.style.width = "120px"; 
	localImagId.style.height = "120px"; 
	//图片异常的捕捉，防止用户修改后缀来伪造图片 
	try{ 
	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
	}catch(e){ 
	alert("您上传的图片格式不正确，请重新选择!"); 
	return false; 
	} 
	imgObjPreview.style.display = 'none'; 
	document.selection.empty(); 
	}  
//	$("#ImageData").val(String(imgObjPreview.src));
	return true; 
	}
	 
function setImagePreview1() { 
	// $("#localImag").empty();
	var docObj=document.getElementById("uploadTitleFile1"); 
	var imgObjPreview=document.getElementById("ImageData1"); 
	if(docObj.files && docObj.files[0]){ 
	//火狐下，直接设img属性 
	imgObjPreview.style.display = 'block'; 
	imgObjPreview.style.width = '120px'; 
	imgObjPreview.style.height = '120px'; 
	//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]); 
	}else{ 
	//IE下，使用滤镜 
	docObj.select(); 
	var imgSrc = document.selection.createRange().text; 
	var localImagId = document.getElementById("localImag1"); 
	//必须设置初始大小 
	localImagId.style.width = "120px"; 
	localImagId.style.height = "120px"; 
	//图片异常的捕捉，防止用户修改后缀来伪造图片 
	try{ 
	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
	}catch(e){ 
	alert("您上传的图片格式不正确，请重新选择!"); 
	return false; 
	} 
	imgObjPreview.style.display = 'none'; 
	document.selection.empty(); 
	}  
	$("#fileList").show();
//	$("#ImageData").val(String(imgObjPreview.src));
	return true; 
	}



function clearImage(){
	
	$("#uploadTitleFile1").val('');
	$("#uploadTitleFile").val('');
	var ImageData1=document.getElementById("ImageData1"); 
	var ImageData=document.getElementById("ImageData"); 
	$("#ImageData").removeAttr("src");
	$("#ImageData1").removeAttr("src");
	ImageData.style.width = '0px'; 
	ImageData.style.height = '0px'; 
	ImageData1.style.width = '0px'; 
	ImageData1.style.height = '0px'; 
	$("#fileList").hide();
}









function checkSMSPassword(){
	uploadTitleImage();
}

function uploadTitleImage(){
	var imgname = $("#uploadTitleFile").val();
		if(imgname==""||imgname==null){
	 		alert("请添加需上传的图片！");
	 		return;
	 	}
		 var imgtype = imgname.substring(imgname.lastIndexOf(".")+1);
		 imgtype = imgtype.toLowerCase();
		 if(imgtype!="jpg" && imgtype!="gif" && imgtype!="jpeg" && imgtype!="bmp" && imgtype!="png"){
			 alert("上传的图片格式只能是:JPG,GIF,JPEG,BMP,PNG格式");
			 return false;
		 }
	var imgname1 = $("#uploadTitleFile1").val();
	if(imgname1==""||imgname1==null){
	 	 		alert("请添加需上传的图片！");
	 	 		return;
	 }
	  var imgtype1 = imgname1.substring(imgname1.lastIndexOf(".")+1);
	  imgtype1 = imgtype1.toLowerCase();
	  if(imgtype1!="jpg" && imgtype1!="gif" && imgtype1!="jpeg" && imgtype1!="bmp" && imgtype1!="png"){
	  alert("上传的图片格式只能是:JPG,GIF,JPEG,BMP,PNG格式");
	 	  return false;
	  }	 
	 
	var urlAddr ='<%=basePath%>'+'UploadImagesToService';
	alert(urlAddr);
	 	$.ajaxFileUpload
		(
			{
				url:urlAddr,
				secureuri:false,
				data: {Pric:'1'},
				fileElementId:'uploadTitleFile',
				dataType: 'json',
				success: function (data ,status)
				{
					if(data.ReturnCode=='000000'){
						
							//uploadImg();
	 	 					return ;
	 					}else  if(data.ReturnCode=='100000'){
	 							alert(data.ErrorMsg)
	 	 	 					return ;
	 	 				 } else{
			 					alert(data.ErrorMsg)
			 					return;
	 				}
				},
				error: function (data,status,e)
				{
					alert(data.responseText);
					//$("#MessageId2").html(data.responseText);
					
					//popWin("detail2");
				}
			}
		)
}
</script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody id="IdCardPhoto">
			<tr>
				<td>上传身份证正面照片<strong class="red">&nbsp;&nbsp;*</strong></td>
				<td><input type="file" name="uploadTitleFile"
					id="uploadTitleFile" onchange="javascript:setImagePreview();" /></td>
			</tr>
			<tr>
				<td>预览正面照</td>
				<td>
					<div id="localImag">
						<img id="ImageData" width=-1 height=-1 style="diplay: none" />
					</div>
				</td>
			</tr>
			<tr>
				<td>上传身份证反面照片<strong class="red">&nbsp;&nbsp;*</strong></td>
				<td><input type="file" name="uploadTitleFile1"
					id="uploadTitleFile1" onchange="javascript:setImagePreview1();" />
				</td>
			</tr>
			<tr>
				<td>预览反面照</td>
				<td>
					<div id="localImag1">
						<img id="ImageData1" width=-1 height=-1 style="diplay: none" />
					</div>
				</td>
			</tr>
			<tr id="fileList" style="display: none">
				<td>操作</td>
				<td>
					<div class="subMit">
						<input name="button" type="button"
							style="float: left; width: 150px" class="no_mar"
							id="uploadButton" value="上传" onclick="checkSMSPassword();" /> <input
							type="button" id="clearButton" style="float: left; width: 150px"
							class="no_mar" value="清除" onclick="clearImage();" />
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>





