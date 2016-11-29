/*
      LoginServlet.
 */
package TOBA.banking;

import TOBA.business.Account;
import TOBA.business.User;
import TOBA.data.AccountDB;
import TOBA.data.UserDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/login.jsp";

        response.setContentType("text/html");

        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        if (action.equals("log")) {
            // get parameters from the request
            String Username = request.getParameter("username");
            String Password = request.getParameter("password");

            // validate the parameters
            String message = "";
            HttpSession session = request.getSession();
            User user = UserDB.selectUser(Username, Password);
            if (user == null) {
                url = "/new_customer.jsp";
            } else {
                if (Username.equals(user.getUsername())
                        && Password.equals(user.getPassword())) {
                    message = "Login Successful.";
                    url = "/account_activity.jsp";
                    
                    Account checking = AccountDB.selectAccount("CHECKING", user);
                    Account savings = AccountDB.selectAccount("SAVINGS", user);
                    session.setAttribute("user", user);
                    session.setAttribute("checking", checking);
                    session.setAttribute("savings", savings);
                } else {
                    message = "Login failed. Please return to Login page"
                            + " and enter a valid Username & Password.";
                    url = "/login_failure.jsp";
                }
            }
            request.setAttribute("message", message);
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
