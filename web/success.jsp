<%-- 
    Document   : success
    Created on : Nov 4, 2016, 3:23:43 PM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

        <h1>Success!</h1>
        <div id="nav">
            <a href="index.jsp">Home</a>&nbsp;
            <a href="login.jsp">Login</a>&nbsp;
            <a href="new_customer.jsp">New Customer</a>&nbsp;
            <a href="account_activity.jsp">Account Activity</a>&nbsp;
            <a href="transaction.jsp">Transaction</a>
        </div>
        <h2>The account has been successfully created</h2>
        <p>Here is the information that you entered <br> 
            along with your username and password:</p>

        <label>User ID:</label>
        <span>${user.userId}</span><br>
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        <label>Phone:</label>
        <span>${user.phone}</span><br>
        <label>Address:</label>
        <span>${user.address}</span><br>
        <label>City:</label>
        <span>${user.city}</span><br>
        <label>State:</label>
        <span>${user.state}</span><br>
        <label>Zipcode:</label>
        <span>${user.zipcode}</span><br>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>Username:</label>
        <span>${user.username}</span><br>
        <label>Password:</label>
        <span>${user.password}</span><br>

<%@ include file="/includes/footer.jsp" %>
