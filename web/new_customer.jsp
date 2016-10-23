<%-- 
    Document   : new_customer
    Created on : Oct 22, 2016, 9:23:38 PM
    Author     : David
--%>
<!DOCTYPE html>

<html>
    <head>
        <title>New Customer</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>New Customer</h1>
        <div id="nav">
            <a href="index.html">Home</a>&nbsp;
            <a href="login.html">Login</a>&nbsp;
            <a href="new_customer.jsp">New Customer</a>&nbsp;
            <a href="account_activity.html">Account Activity</a>&nbsp;
            <a href="transaction.html">Transaction</a>
        </div>
        <p><i>${message}</i></p>
        <h2>New customers please fill in all fields below</h2>
        <form action="newCustomer" method="post">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName" value="${customer.firstName}"><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName" value="${customer.lastName}"><br>
            <label class="pad_top">Phone:</label>
            <input type="tel" name="phone" value="${customer.phone}"><br>
            <label class="pad_top">Address:</label>
            <input type="text" name="address" value="${customer.address}"><br>
            <label class="pad_top">City:</label>
            <input type="text" name="city" value="${customer.city}"><br>
            <label class="pad_top">State:</label>
            <input type="text" name="state" value="${customer.state}"><br>
            <label class="pad_top">Zipcode:</label>
            <input type="text" name="zipcode" value="${customer.zipcode}"><br>
            <label class="pad_top">Email:</label>
            <input type="email" name="email" value="${customer.email}"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Submit" class="margin_left">
        </form>
    </body>
</html>
