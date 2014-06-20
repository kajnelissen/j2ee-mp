/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.servlets.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.rkk.marktplaats.facades.AdFacadeLocal;
import nl.rkk.marktplaats.facades.MyUserFacadeLocal;
import nl.rkk.marktplaats.models.MyUser;
import nl.rkk.marktplaats.models.UserRole;
import nl.rkk.marktplaats.validation.Validator;
import nl.rkk.marktplaats.validation.ValidatorFactory;
import nl.rkk.marktplaats.validation.rules.UserRules;
//import nl.rkk.marktplaats.models.UserRole;

/**
 *
 * @author Kaj
 */
public class RegisterServlet extends HttpServlet {

    @EJB
    private MyUserFacadeLocal users;
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
            //PrintWriter out = response.getWriter();
            //int count = users.count();
            //out.println(count);
        //}
        
        Dictionary<String, String> input = new Hashtable<>();
        input.put("email", request.getParameter("email"));
        input.put("password", request.getParameter("password"));
        
        
        Validator validator = ValidatorFactory.make(UserRules.rules, input);
        
        if ( validator.passes() ) {
            out.println("Yay!");
        } else {
            for ( String error : validator.getErrors() ) {
                out.println(error);
            }
        }
        
        String email = request.getParameter("email");
        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        //users.create(email, password);
        
        // registered user, proceed to login page
        //getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register servlet";
    }// </editor-fold>

}
