package com.christancho.mars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Class used to Test the Mars Rovers by Http GET and POST
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */

public class MarsRoverRestServlet extends HttpServlet {


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("MarsRoverRestServlet");
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        String paramValue;
        try {
            paramValue = request.getParameter("input");
            if (paramValue == null || paramValue.trim().isEmpty()) {
                paramValue = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
                out.println("You have to pass a valid input as GET or POST parameter.");
                out.println(" Example: ");
                out.println("          input =  " + paramValue);
                out.println("");
            }
            Mars mars = new Mars();
            mars.deployRovers(paramValue);
            out.write("output = ");
            out.write(mars + "");
        } catch (Exception ex) {
            paramValue = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
            out.println("Error: " + ex.getMessage());
            out.println("");
            out.println("You have to pass a valid input as GET or POST parameter.");
            out.println(" Example: ");
            out.println("          input =  " + paramValue);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}