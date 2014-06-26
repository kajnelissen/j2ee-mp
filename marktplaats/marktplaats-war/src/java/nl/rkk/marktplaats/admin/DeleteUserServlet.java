/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.rkk.marktplaats.facades.MyUserFacadeLocal;
import nl.rkk.marktplaats.models.MyUser;
import nl.rkk.marktplaats.models.UserRole;

/**
 *
 * @author Kaj
 */
public class DeleteUserServlet extends HttpServlet {
    
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
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
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
        
        MyUser user = (MyUser) request.getSession().getAttribute("currentUser");
        String param = request.getParameter("id");
        
        if ( user == null ) {
            
            response.sendRedirect("/marktplaats-war/login");
            
        } else {
        
            if ( user.getType() == UserRole.Admin ) { 

                if ( param != null ) {
                    Integer userId = Integer.parseInt(param);
                    MyUser deleteUser = this.users.find(userId);

                    if ( deleteUser == null ) {
                        request.setAttribute("errorMsg", "Geen gebruiker gevonden met id = " + param + "!");
                    } else if ( deleteUser.getType() == UserRole.Admin ) {
                        request.setAttribute("errorMsg", "Je kunt geen beheerders verwijderen!");
                    } else {
                        this.users.remove(deleteUser);
                        request.setAttribute("notification", "Gebruiker met e-mailadres \"" + deleteUser.getEmail() + "\" is verwijderd!");
                    }     

                } else {
                    request.setAttribute("errorMsg", "Kan geen gebruiker verwijderen: geen userId gevonden.");
                }

                request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
            }

            response.sendRedirect("/marktplaats-war");
            
        }
        
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
