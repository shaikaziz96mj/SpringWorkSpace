<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<h1 style="color:blue;text-align: center;">WELCOME TO SO AND SO HOSPITAL</h1>
	<h2 style="color:blue;text-align: center;">ENTER PATIENT DETAILS BELOW TO CREATE RECORD</h2>
	<hr><br><br>
	<form:form method="POST" modelAttribute="patientCmd">
		<table border="3" bordercolor="blue" align="center">
			<tr>
				<td>PATIENT NAME</td>
				<td><form:input path="pname"/><form:errors path="pname"/></td>
			</tr>
			<tr>
				<td>PATIENT AGE</td>
				<td><form:input path="age"/><form:errors path="age"/></td>
			</tr>
			<tr>
				<td>PATIENT GENDER</td>
				<td><form:input path="gender"/><form:errors path="gender"/></td>
			</tr>
			<tr>
				<td>PATIENT ADDRESS</td>
				<td><form:input path="address"/><form:errors path="address"/></span></td>
			</tr>
			<tr>
				<td>PATIENT PROBLEM</td>
				<td><form:input path="problem"/><form:errors path="problem"/></td>
			</tr>
			<tr>
				<td>DOCTOR NAME</td>
				<td><form:input path="doctor"/><form:errors path="doctor"/></td>
			</tr>
			<tr>
				<td>CONTACT NUMBER</td>
				<td><form:input path="contactNumber"/><form:errors path="contactNumber"/></td>
			</tr>
			<tr>
				<td>WARD NUMBER</td>
				<td><form:input path="wardNumber"/><form:errors path="wardNumber"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input type="submit" value="INSERT">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="CLEAR"></td>
			</tr>
		</table>
	</form:form>
	<p style="text-align: center;">
		<a href="getdetails.cpp"><img src="images/home.jpg" title="back to result page" width="70" height="70"></a>
	</p>
	<br><br>
	<h1 style="color:green;text-align:center">THANK YOU</h1>