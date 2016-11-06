<%-- 
    Document   : footer
    Created on : Nov 3, 2016, 12:47:50 AM
    Author     : David
--%>

<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>&copy; Copyright <%= currentYear %> Dave Pinoos &amp; Associates</p>
</body>
</html>