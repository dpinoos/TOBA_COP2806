<%-- 
    Document   : account_activity
    Created on : Nov 6, 2016, 12:44:43 AM
    Author     : David
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

<h1>Account Activity</h1>
<div id="nav">
    <a href="index.jsp">Home</a>&nbsp;
    <a href="login.jsp">Login</a>&nbsp;
    <a href="new_customer.jsp">New Customer</a>&nbsp;
    <a href="account_activity.jsp">Account Activity</a>&nbsp;
    <a href="transaction.jsp">Transaction</a>
    <a href="transfer.jsp">Transfer</a>
</div>
<c:if test="${user != null}">
    <h2>  Welcome &nbsp;${user.firstName}&nbsp;${user.lastName}</h2>
    <h1>Your Account Transactions</h1>
    <table>
        <tr>
            <th>Transaction Type: </th>
            <th>Transfer Amount: </th>
            <th>Starting Balance: </th>
            <th>Ending Balance: </th>
        </tr>
        <c:forEach var="t" items="${savings.transactions}">
            <tr>
                <td><c:out value="${t.transType}"/>: Savings</td>
                <td class="right"><c:out value= "${t.transCurrencyFormat}"/></td>
                <td class="right"><c:out value= "${t.startCurrencyFormat}"/></td>
                <td class="right"><c:out value= "${t.endCurrencyFormat}"/></td>
            </tr>
        </c:forEach>
            <c:forEach var="t" items="${checking.transactions}">
            <tr>
                <td><c:out value="${t.transType}"/>: Checking</td>
                <td><c:out value= "${t.transCurrencyFormat}"/></td>
                <td><c:out value= "${t.startCurrencyFormat}"/></td>
                <td><c:out value= "${t.endCurrencyFormat}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${user == null}">
    <h2> You are not logged in</h2>
</c:if>
<%@ include file="/includes/footer.jsp" %>
