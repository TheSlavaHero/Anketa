package com.example.Anketa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet (name = "Results", urlPatterns = {"/results"})
public class ResultsServlet extends HttpServlet {

    private AtomicInteger javaYesCounter = new AtomicInteger(0);
    private AtomicInteger javaNoCounter = new AtomicInteger(0);
    private AtomicInteger htmlYesCounter = new AtomicInteger(0);
    private AtomicInteger htmlNoCounter = new AtomicInteger(0);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException {
        try {
            resp.setContentType("text/html");

            String java = req.getParameter("JAVA");
            String html = req.getParameter("HTML");

            if (java.equals("yes")) {
                javaYesCounter.getAndIncrement();
            }
            if (java.equals("no")) {
                javaNoCounter.getAndIncrement();
            }
            if (html.equals("yes")) {
                htmlYesCounter.getAndIncrement();
            }
            if (html.equals("no")) {
                htmlNoCounter.getAndIncrement();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            PrintWriter pw = resp.getWriter();
            pw.println("<html><h2 style=\"color:#ff0000\">Attention! You did not answer all the questions, your answer will not count. Please, try again.</h2></html>");
        }
        PrintWriter pw = resp.getWriter();
        pw.println("<html><table> <tr><td>table</td> <td>yes</td> <td>no</td> </tr> <tr>" +
                "<th>HTML</th> <td>" + htmlYesCounter + "</td> <td>" + htmlNoCounter + "</td></tr>" +
                "<tr> <th>Java</th> <td>" + javaYesCounter + "</td><td>" + javaNoCounter + "</td> </tr> </table></html>");
        pw.println("<html><br>Click <a href=/>here</a> to vote again. </br></html>");
    }
}
