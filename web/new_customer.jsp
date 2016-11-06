<%-- 
    Document   : new_customer
    Created on : Oct 22, 2016, 9:23:38 PM
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html"%>

        <h1>New Customer</h1>
        <div id="nav">
            <a href="index.jsp">Home</a>&nbsp;
            <a href="login.jsp">Login</a>&nbsp;
            <a href="new_customer.jsp">New Customer</a>&nbsp;
            <a href="account_activity.jsp">Account Activity</a>&nbsp;
            <a href="transaction.jsp">Transaction</a>
        </div>
        <p><i>${message}</i></p>
        <h2>New customers please fill in all fields below</h2>
        <form action="newCustomer" method="post">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}"><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}"><br>
            <label class="pad_top">Phone:</label>
            <input type="tel" name="phone" value="${user.phone}"><br>
            <label class="pad_top">Address:</label>
            <input type="text" name="address" value="${user.address}"><br>
            <label class="pad_top">City:</label>
            <input type="text" name="city" value="${user.city}"><br>
            <label class="pad_top">State:</label>
            <input type="text" name="state" value="${user.state}"><br>
            <label class="pad_top">Zipcode:</label>
            <input type="text" name="zipcode" value="${user.zipcode}"><br>
            <label class="pad_top">Email:</label>
            <input type="email" name="email" value="${user.email}"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Submit" class="margin_left">
        </form>
<%@ include file="/includes/footer.jsp" %>
