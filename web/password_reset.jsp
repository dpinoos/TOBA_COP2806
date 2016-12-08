<%-- 
    Document   : password_reset
    Created on : Nov 3, 2016, 1:33:11 AM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

<h1>Password Reset</h1>
<div id="nav">
    <a href="index.jsp">Home</a>&nbsp;
    <a href="login.jsp">User Login</a>&nbsp;
    <a href="new_customer.jsp">New Customer</a>&nbsp;
    <a href="account_activity.jsp">Account Activity</a>&nbsp;
    <a href="transaction.jsp">Transaction</a>
    <a href="admin/login.jsp">Admin Login</a>&nbsp;
    <a href="admin/reports.jsp">Reports</a>&nbsp;
</div>
<h2>Enter new password below</h2>
<form action="newPassword" method="post">
    <input type="hidden" name="action" value="change">        
    <label class="pad_top">Password:</label>
    <input type="text" name="newPassword" value="${user.password}" id="newPassword"><br>
    <input type="submit" value="Change" class="margin_left">
</form>
<%@ include file="/includes/footer.jsp" %>
