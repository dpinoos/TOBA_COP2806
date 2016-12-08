/*
ReportsServlet
 */
package TOBA.banking;

import TOBA.business.User;
import TOBA.data.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class ReportsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = UserDB.selectUsers();
        List<User> monthUsers = new ArrayList();
        Date currentDate = new Date();
        int currentMonth = currentDate.getMonth();

        for (User u : users) {
            Date userDate = new Date(u.getDate());
            int userMonth = userDate.getMonth();

            if (userMonth == currentMonth) {
                monthUsers.add(u);
            }
        }
        request.setAttribute("users", monthUsers);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
