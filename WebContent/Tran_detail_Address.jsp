62<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal</title>
</head>
<body onload = "fnOnLoad();">
Function :<%= session.getAttribute("Func") %>
 
<h1>Address detail</h1>

 <div>
 	<a href= 'Transaction_detail.jsp'>personal</a>
 	<a href= 'Tran_detail_Address.jsp'>address</a>
 	<a href= 'Tran_detail_salary.jsp'>Salary</a>
 </div>

<div id= "Addr">
 	<form action = "transactionDet?action=address" method= "Post" >
 		<table cellspacing="20">
			<tr>
				<td>House No</td>
				<td>
					<input type= "text" id = "house" name="house" />
				</td>
				<td>&nbsp;</td>
				<td>City</td>
				<td>
					<input type= "text" id = "city" name="city"/>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<input type= "text" id = "state" name="state"/>
				</td>
				<td>&nbsp;</td>
				<td>Pin Code</td>
				<td>
					<input type= "text" id = "pin" name="pin"/>
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
 
 <script type= "text/javascript">
 	function fnOnLoad(){
		alert("M onload");
		var pin = "<%=session.getAttribute("pin")%>";
		alert(pin);
		if(pin !=  'null'){
		document.forms[0].house.value  = "<%=session.getAttribute("house")%>";
		document.forms[0].city.value   = "<%=session.getAttribute("city")%>";
		document.forms[0].state.value = "<%=session.getAttribute("state")%>";
		document.forms[0].pin.value = "<%=session.getAttribute("pin")%>";
		}
 	}
 </script>



</body>
</html>