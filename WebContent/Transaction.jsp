<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
form{ 	
display: inline-block; 
}
#MainTran{
text-align : center;
}

table,td {
	 margin:auto;
  /* text-align: center;*/
   border: 0;
   width : 100;
}
</style>
</head>

<body onload= "fnonload();">
<h1  align="center"> Transaction Info </h1>
<% if(session.getAttribute("msg")!= null) {%>
<p style="color: red; align : center;" >
	<%=session.getAttribute("msg") %>
</p>
	<% } %>

<div id = "MainTran">
<!--  <form action = "finaclePage.jsp"> for directly moving to 2nd jsp-->
<form action = "transaction" method= "Post" onsubmit="return click2(this);">
<table cellspacing="20">
	<tr>
		<td>Function</td>
		<td>
		<select name= "functions" onchange = "javascript:click1(this);">
		  <option value="--select--">--Select--</option>
		  <option value="add">Add</option>
		  <option value="inquire">Inquire</option>
		</select>
		</td>
		<td>&nbsp;</td>
		<td>Transaction No</td>
		<td>
			<input type= "text" id = "tranNo" name = "tranNo"/>
		</td>
	</tr>
</table>
<br>
<br>
<input type="submit" name = "Back" value="Back"/>
<input type="submit" name = "Go" value="Go" />
</form>
</div>

<script type="text/javascript">
	function click1(){
		//alert("Hi");
		//alert(document.getElementsByName("functions")[0].value);
		var input = document.getElementsByName("functions")[0].value ;
		alert(input);
		if(input == "add"){
			document.getElementById("tranNo").disabled = true;
		}
		else{
			document.getElementById("tranNo").disabled = false;
		}
		
	}
	function click2(){
		alert("m 2 going");
		 input = document.getElementsByName("functions")[0].value ;
		if(input == "--select--"){
			alert("Please select function");
			return false;
		}
		if(input == "inquire"){
			var tran = document.getElementById("tranNo").value;
			if(tran == ""){
				alert("Tran No must be filled out");
		        return false;
			}
		}
	}
	
	
</script>

</body>
</html>