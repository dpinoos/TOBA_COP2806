<%-- 
    Document   : login
    Created on : Dec 7, 2016, 4:58:47 PM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

<h1>Admin Login Form</h1>
<div id="nav">
    <a href="../index.jsp">Home</a>&nbsp;
    <a href="../login.jsp">User Login</a>&nbsp;
    <a href="../new_customer.jsp">New Customer</a>&nbsp;
    <a href="login.jsp">Admin Login</a>
    <a href="reports.jsp">Reports</a>
</div>
<p>Please enter your username and password to continue.</p>
<form action="j_security_check" method="get">
    <label class="pad_top">Username</label>
    <input type="text" name="j_username"><br>
    <label class="pad_top">Password</label>
    <input type="password" name="j_password"><br>
    <label>&nbsp;</label>
    <input type="submit" value="Login" class="margin_left">    
</form>
<%@ include file="/includes/footer.jsp" %>
