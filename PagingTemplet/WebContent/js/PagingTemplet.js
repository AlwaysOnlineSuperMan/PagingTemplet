function pageMode(currPage) {
	document.getElementById("currPage").value = currPage;
	document.forms[0].submit();
}
function changeCurrRecord(){
	var CurrRecord = document.getElementById("currRecord").value;
	if(CurrRecord<=0){
		alert("每页显示必须大于等于1!");
		return;
	}
	document.getElementById("currPage").value = 1;
	document.forms[0].submit();
}
