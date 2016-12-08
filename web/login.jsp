<%-- 
    Document   : login
    Created on : Nov 6, 2016, 1:15:24 AM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

<h1>Login</h1>
<div id="nav">
    <a href="index.jsp">Home</a>&nbsp;
    <a href="login.jsp">User Login</a>&nbsp;
    <a href="new_customer.jsp">New Customer</a>&nbsp;
    <a href="admin/login.jsp">Admin Login</a>&nbsp;
    <a href="admin/reports.jsp">Reports</a>&nbsp;
</div>

<h2>Enter Login information or select <a href="new_customer.jsp">New Customer</a></h2>
<form action="login" method="post">
    <input type="hidden" name="action" value="log">        
    <label class="pad_top">Username:</label>
    <input type="text" name="username" required><br>
    <label class="pad_top">Password:</label>
    <input type="password" name="password" required><br>
    <label>&nbsp;</label>
    <input type="submit" value="Login" class="margin_left">
    <a href="password_reset.jsp">Reset Password</a>
</form>
<%@ include file="/includes/footer.jsp" %>
