package com.example.Anketa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "Results", urlPatterns = {"/results"})
public class ResultsServlet extends HttpServlet {

    private int javaYesCounter = 0;
    private int javaNoCounter = 0;
    private int htmlYesCounter = 0;
    private int htmlNoCounter = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String java = req.getParameter("JAVA");
        String html = req.getParameter("HTML");

        if (java.equals("yes")) {
            javaYesCounter++;
        }
        if (java.equals("no")) {
            javaNoCounter++;
        }
        if (html.equals("yes")) {
            htmlYesCounter++;
        }
        if (html.equals("no")) {
            htmlNoCounter++;
        }

        PrintWriter pw = resp.getWriter();
        pw.println("<html><table> <tr><td>table</td> <td>yes</td> <td>no</td> </tr> <tr>" +
                "<th>HTML</th> <td>" + htmlYesCounter + "</td> <td>" + htmlNoCounter + "</td></tr>" +
                "<tr> <th>Java</th> <td>" + javaYesCounter + "</td><td>" + javaNoCounter + "</td> </tr> </table></html>");
        pw.println("<html><br>Click <a href=/>here</a> to vote again. </br></html>");
    }
}
