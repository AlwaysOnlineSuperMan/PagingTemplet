/*!
 * @author nings
 * PagingTemplet Library v1.0
 * Date: 2016-03-23
 */
function pageMode(currPage) {
	document.getElementById("currPage").value = currPage;
	document.forms[0].submit();
}
function changeCurrRecord(){
	document.getElementById("currPage").value = 1;
	document.forms[0].submit();
}
