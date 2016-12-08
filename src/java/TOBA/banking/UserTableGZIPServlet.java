package TOBA.banking;

import TOBA.business.User;
import TOBA.data.UserDB;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author David
 */
public class UserTableGZIPServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The User table");

        List<User> users = UserDB.selectUsers();

        try {
            // read database rows
            // create the spreadsheet rows
            int i = 2;
            for (User u : users) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(u.getUserID());
                row.createCell(1).setCellValue(u.getLastName());
                row.createCell(2).setCellValue(u.getFirstName());
                row.createCell(3).setCellValue(u.getEmail());
                i++;
            }

        } catch (Exception e) {
            this.log(e.toString());
        }

        // set the response headers
        response.setHeader("content-disposition",
                "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");
        String encodingString = request.getHeader("accept-encoding");
        OutputStream out;
        if (encodingString != null && encodingString.contains("gzip")) {
            out = new GZIPOutputStream(response.getOutputStream());
            response.setHeader("content-encoding", "gzip");
            // System.out.println("User table encoded with gzip");
        } else {
            out = response.getOutputStream();
            // System.out.println("User table not encoded with gzip");
        }
        // get the output stream and send the workbook to the browser
        // OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
    }
}
