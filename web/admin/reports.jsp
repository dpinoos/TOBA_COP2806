<%-- 
    Document   : reports
    Created on : Dec 2, 2016, 10:40:15 PM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
<%@ include file="/includes/header.html"%>

<h1>Reports</h1>
<div id="nav">
    <a href="../index.jsp">Home</a>&nbsp;
    <a href="../login.jsp">User Login</a>&nbsp;
    <a href="../new_customer.jsp">New Customer</a>&nbsp;
    <a href="login.jsp">Admin Login</a>&nbsp;
    <a href="reports.jsp">Reports</a>&nbsp;
</div>
<label>Users registered this month:</label>

<c:forEach var="u" items="${users}">
    <span>${user.firstName} &nbsp; ${user.lastName}</span><br>
</c:forEach>
<br>
<p><a href="../userTableSpreadsheet">Return as an XLS file</a></p>
<p><a href="../userTableGZIP">Return using GZIP compression</a></p>
<br>
<br>
<%@ include file="/includes/footer.jsp" %>
