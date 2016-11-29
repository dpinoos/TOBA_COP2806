<%-- 
    Document   : transfer
    Created on : Nov 16, 2016, 6:03:53 PM
    Author     : David
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

<h1>Transfer Page</h1>
<div id="nav">
    <a href="index.jsp">Home</a>&nbsp;
    <a href="login.jsp">Login</a>&nbsp;
    <a href="new_customer.jsp">New Customer</a>&nbsp;
    <a href="account_activity.jsp">Account Activity</a>&nbsp;
    <a href="transaction.jsp">Transaction</a>
    <a href="transfer.jsp">Transfer</a>
</div>
<label>Savings Balance:</label>
<span>${savings.balance}</span>
<br>
<label>Checking Balance:</label>
<span>${checking.balance}</span>
<br>

<!--<p>Please select transfer accounts:</p>
<select name="transfer">
    <option value="Sav-Check" selected>Savings to Checking</option>
    <option value="Check-Sav">Checking to Savings</option>
</select><br>
<p>Please enter transfer amount, not to exceed available balance</p>-->

<br>
<form action="transaction" method="post">
    <p>Please select transfer accounts:</p>
<select name="transfer">
    <option value="Sav-Check" selected>Savings to Checking</option>
    <option value="Check-Sav">Checking to Savings</option>
</select><br>
    <p>Please enter transfer amount, not to exceed available balance</p>
    <input type="number" name="transAmount" required><br><br>
    <input type="submit" value="Submit Transfer" class="margin_left">

</form>

<%@ include file="/includes/footer.jsp" %>
