<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onload = "fnOnLoad();">
<h1 align="center">Personal detail</h1>
<br/>
 Function :<%= session.getAttribute("Func")%>
 <div>
 	<a href= 'Transaction_detail.jsp' onclick = "fnOnLoad2();">personal</a>
 	<a href= 'Tran_detail_Address.jsp' onclick = "fnOnLoad();">address</a>
 	<a href= 'Tran_detail_salary.jsp'>Salary</a>
 </div>
 
 <div id= "Pers">

 <% if(session.getAttribute("msg") != null) { %>
    <p style="color: red">
     <%= session.getAttribute("msg") %>
    </p>
 <% } %>
   
 	<form action = "transactionDet?action=main" method= "Post" onsubmit = "return abc();">
 		<table cellspacing="20">
			<tr>
				<td>Full Name</td>
				<td>
					<input type= "text" id = "name" name= "name" />
				</td>
				<td>&nbsp;</td>
				<td>Age</td>
				<td>
					<input type= "text" id = "age" name= "age"/>
				</td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td>
					<input type= "text" id = "email" name= "email"/>
				</td>
				<td>&nbsp;</td>
				<td>Phone No</td>
				<td>
					<input type= "text" id = "phone" name= "phone"/>
				</td>
			</tr>
		</table>
		<br>
		<br>
	<input type="submit" name = "Back" value="Back"/>
	<input type="submit" name = "Next" value="Next"/>
	<input type="submit" name = "Go" value="Go"/>
 	</form>
 </div>
 
<script type="text/javascript">
 function abc(){
	 
	 var func = "<%= session.getAttribute("Func") %>";
	 if(func == "add"){
		 alert("hi");
		 var name = "<%= session.getAttribute("flag") %>";
		 alert(name);
		// alert(document.forms[0].pin.value);
		 alert(document.forms[0].name.value);
		 var name = document.forms[0].name.value ;

		 var phone =  document.forms[0].phone.value ;
		 if(name == "" || phone == ""){
			 alert("Please enter name and phone no");
			 return false;
		 }
		 else{
			 if(document.forms[0].pin.value != ""){
				 return true;
			 }
		 }
		 
	 }
	 else{
		 return true;
	 }
	 
 }
 
	function fnOnLoad(){
		alert("M onload");
		var name = "<%=session.getAttribute("name")%>";
		alert(name);
		if(name !=  'null'){
			document.forms[0].name.value  = "<%=session.getAttribute("name")%>";
			document.forms[0].age.value   = "<%=session.getAttribute("age")%>";
			document.forms[0].email.value = "<%=session.getAttribute("email")%>";
			document.forms[0].phone.value = "<%=session.getAttribute("phone")%>";
		}
		
 	}
	
	</script>
 
</body>
</html>