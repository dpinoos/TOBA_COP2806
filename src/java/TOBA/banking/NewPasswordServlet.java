/*
New Password Servlet
 */
package TOBA.banking;

import TOBA.business.User;
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
public class NewPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/password_reset.jsp";

        response.setContentType("text/html");

        // get current action
        String action = request.getParameter("action");

        if (action.equals("change")) {
            String newPassword = request.getParameter("newPassword");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user.setPassword(newPassword);
            UserDB.update(user);
            session.setAttribute("user", user);
            url = "/account_activity.jsp";
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
