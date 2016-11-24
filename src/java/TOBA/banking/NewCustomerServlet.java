/*
NewCustomerServlet
 */
package TOBA.banking;

import TOBA.business.Account;
import TOBA.business.User;
import TOBA.data.AccountDB;
import TOBA.data.UserDB;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author David
 */
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new_customer.jsp";

        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);
        response.setContentType("text/html");

        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");
            String username = request.getParameter("lastName") + request.getParameter("zipcode");
            String password = "welcome1";

//             validate the parameters
            String message;
            if (firstName == null || lastName == null || phone == null || address == null
                    || city == null || state == null || zipcode == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || address.isEmpty()
                    || city.isEmpty() || state.isEmpty() || zipcode.isEmpty() || email.isEmpty()) {
                message = "Please fill out all text boxes.";
                url = "/new_customer.jsp";
            } else {

                message = "";
                url = "/success.jsp";
            }
            // store the data in a User object
            User user = new User(firstName, lastName, phone, address,
                    city, state, zipcode, email, username, password);
            UserDB.insert(user);
            Account savings = new Account("SAVINGS", 25.00, user);
            Account checking = new Account("CHECKING", 0.00, user);
            AccountDB.insert(savings);
            AccountDB.insert(checking);
//
            request.setAttribute("message", message);
            // store the User object as a session attribute
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
