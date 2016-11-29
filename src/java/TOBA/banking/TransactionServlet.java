/*
 TRansaction Servlet
 */
package TOBA.banking;

import TOBA.business.Account;
import TOBA.business.Transaction;
import TOBA.business.User;
import TOBA.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class TransactionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Double transferAmount = Double.parseDouble(request.getParameter("transAmount"));
        String transferType = request.getParameter("transfer");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Account checking = (Account) session.getAttribute("checking");
        Account savings = (Account) session.getAttribute("savings");
        double startAmnt;

        if(transferType.matches("Sav-Check")){
            startAmnt = savings.getBalance();
            savings.debit(transferAmount);
            savings.addTransactions(
                    new Transaction(startAmnt, savings.getBalance(), transferAmount, "DEBIT"));
            
            startAmnt = checking.getBalance();
            checking.credit(transferAmount);
            checking.addTransactions(
                    new Transaction(startAmnt, checking.getBalance(), transferAmount, "CREDIT"));
        }
        else{
            startAmnt = savings.getBalance();
            savings.credit(transferAmount);
            savings.addTransactions(
                    new Transaction(startAmnt, savings.getBalance(), transferAmount, "CREDIT"));
            
            startAmnt = checking.getBalance();
            checking.debit(transferAmount);
            checking.addTransactions(new Transaction(
                    startAmnt, checking.getBalance(), transferAmount, "DEBIT"));
        }
        AccountDB.update(checking);
        AccountDB.update(savings);
        session.setAttribute("checking", checking);
        session.setAttribute("savings", savings);
        
        getServletContext()
                .getRequestDispatcher("/transfer.jsp")
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
