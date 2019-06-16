<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onload = "fnOnLoad();">
Function :<%= session.getAttribute("Func") %>
 
<h1>Salary detail</h1>

 <div>
 	<a href= 'Transaction_detail.jsp'>personal</a>
 	<a href= 'Tran_detail_Address.jsp'>address</a>
 	<a href= 'Tran_detail_salary.jsp'>Salary</a>
 </div>
 
 
<div id= "Addr">
 	<form action = "transactionDet?action=salary" method= "Post">
 		<table cellspacing="20">
			<tr>
				<td>Salary</td>
				<td>
					<input type= "number" id = "salary" name="salary" />
				</td>
				<td>&nbsp;</td>
				<td>Bonus</td>
				<td>
					<input type= "number" id = "bonus" name="bonus"/>
				</td>
			</tr>
			</table>
		<br>
		<br>
	<input type="submit" name = "Back" value="Back"/>
	<input type="submit" name = "Go" value="Go"/>
 	</form>
 </div>
 
 <script type= "text/javascript">
 	function fnOnLoad(){
		alert("M onload");
		var salary = "<%=session.getAttribute("salary")%>";
		alert(salary);
		if(salary !=  'null'){
		document.forms[0].salary.value  = "<%=session.getAttribute("salary")%>";
		document.forms[0].bonus.value   = "<%=session.getAttribute("bonus")%>";
		}
 	}
 </script>
			
</body>
</html>