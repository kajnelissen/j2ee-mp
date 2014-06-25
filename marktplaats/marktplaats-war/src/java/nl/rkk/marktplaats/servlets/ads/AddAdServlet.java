/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.servlets.ads;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nl.rkk.marktplaats.facades.AdFacadeLocal;
import nl.rkk.marktplaats.facades.CategoryFacadeLocal;
import nl.rkk.marktplaats.models.MyUser;
import nl.rkk.marktplaats.security.Encryption;
import nl.rkk.marktplaats.validation.Validator;
import nl.rkk.marktplaats.validation.ValidatorFactory;
import nl.rkk.marktplaats.validation.rules.AdRules;
import nl.rkk.marktplaats.validation.rules.UserRules;

/**
 *
 * @author Kaj
 */
public class AddAdServlet extends HttpServlet {
    
    @EJB
    private AdFacadeLocal ads;
    private CategoryFacadeLocal catogory;
    private Object user;

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
            out.println("<title>Servlet AddAdServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAdServlet at " + request.getContextPath() + "</h1>");
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
               
        HttpSession session = request.getSession(true);
        Object check = session.getAttribute("currentUser");
            if (check == null) {
                response.sendRedirect("/marktplaats-war/login");
            } else {
                 getServletContext().getRequestDispatcher("/ads/create.jsp").forward(request, response);
                 
            }
       
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet respe
     * @throws ServletException if a servonslet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //processRequest(request, response);
        
               
        MyUser user = (MyUser) request.getSession(true).getAttribute("currentUser");
        if(user == null){
             response.sendRedirect("/marktplaats-war/login");
        }
        
        Dictionary<String, String> input = new Hashtable<>();
        input.put("title", request.getParameter("titel"));
        input.put("description", request.getParameter("beschrijving"));
        input.put("category", request.getParameter("categorie"));
        input.put("price", request.getParameter("prijs"));
         
        Validator validator = ValidatorFactory.make(AdRules.rules, input);
       
        if ( validator.passes() ) {
            
            String titel= request.getParameter("titel");
            String beschrijving = request.getParameter("beschrijving");
            String categorie = request.getParameter("categorie");
            String prijs = request.getParameter("prijs");
         
            ads.create(user, titel, beschrijving, categorie, Double.parseDouble(prijs.replace(',','.')));
            // advertentie aangemaakt, doorverwezen naar advertentie pagina
            getServletContext().getRequestDispatcher("/ads/ads.jsp").forward(request, response);   
            
        } else {
            
            request.setAttribute("errorMsg", "Gegevens incorrect!");
            request.setAttribute("formErrors", validator.getErrors());
            getServletContext().getRequestDispatcher("/ads/create.jsp").forward(request, response);  
            
        }        
           
        
        
         //getServletContext().getRequestDispatcher("/ads/show.jsp").forward(request, response); 
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
