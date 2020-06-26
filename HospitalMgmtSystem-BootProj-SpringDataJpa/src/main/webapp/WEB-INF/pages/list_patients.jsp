<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty listDTO}">
		<h1 style="color:blue;text-align: center;">WELCOME TO SO AND SO HOSPITAL</h1>
		<h2 style="color:green;text-align: center;">DISPLAYING RECORD SEARCH MADE AT TIME::${sysDate}</h2>
		<hr>
		<p style="text-align: center;background-color: yellow">
			${result}
		</p>
		<hr>
		<table border="4" align="center" bordercolor="blue">
			<tr style="background-color:cyan;color: red">
				<th>S.NO</th><th>PID</th><th>PNAME</th><th>GENDER</th><th>AGE</th><th>ADDRESS</th>
				<th>CONTACTNUMBER</th><th>PROBLEM</th><th>DOCTOR</th><th>WARDNUMBER</th><th>OPERATIONS</th>
			</tr>
			<c:forEach var="dto" items="${listDTO}">
				<tr style="background-color:lime;">
					<td>${dto.srNum}</td>
					<td>${dto.pid}</td>
					<td>${dto.pname}</td>
					<td>${dto.gender}</td>
					<td>${dto.age}</td>
					<td>${dto.address}</td>
					<td>${dto.contactNumber}</td>
					<td>${dto.problem}</td>
					<td>${dto.doctor}</td>
					<td>${dto.wardNumber}</td>
					<td><a href="edit_form.cpp?id=${dto.pid}"><img src="images/edit.jpg" title="edit patient" width="30" height="30"></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="remove_record.cpp?id=${dto.pid}" onclick="return confirm('!!SURE, YOU WANT TO DELETE RECORD!!')"><img src="images/delete.jpg" title="delete patient" width="30" height="30" alt=""></a></td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<p style="text-align:center;background-color: pink">
			<b>CLICK HERE TO INSERT NEW RECORD-></b><a href="insert_patient.cpp"><img src="images/insert.jpg" title="click to insert" width="60" height="60"></a>
		</p>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align: center">NO RECORDS FOUND FOR THE CURRENT SEARCH</h1>
		<hr>
		<h2>PLEASE TRY AGAIN LATER</h2><br><br>
		<hr>
		<p style="text-align:center;background-color: pink">
			<b>CLICK HERE TO INSERT NEW RECORD-></b><a href="insert_patient.cpp"><img src="images/insert.jpg" title="click to insert" width="60" height="60"></a>
		</p>
	</c:otherwise>
</c:choose>
<hr>
<br>
<p style="text-align: center;">
	<a href="home.cpp"><img src="images/home.jpg" title="back to home" width="70" height="70"></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="JavaScript:doPrint()"><img src="images/print.jpg" width="70" height="70" title="click here to print"></a>
</p>
<script language="JavaScript" >
	function doPrint(){
			frames.focus();
			frames.print();
		}
</script>