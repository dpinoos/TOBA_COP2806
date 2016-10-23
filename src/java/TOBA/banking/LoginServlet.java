/*
      LoginServlet.
 */
package TOBA.banking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/login.html";

        response.setContentType("text/html");

        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        if (action.equals("log")) {
            // get parameters from the request
            String Username = request.getParameter("username");
            String Password = request.getParameter("password");

            // validate the parameters
            String message;
            if (Username.equals("jsmith@toba.com") && Password.equals("letmein")) {
                message = "Login Successful.";
                url = "/account_activity.html";
            }
            else {
                message = "Login failed. Please return to Login page"
                        + " and enter a valid Username & Password.";
                url = "/login_failure.html";
            }
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
