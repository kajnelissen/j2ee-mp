/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.servlets.ads.bids;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.rkk.marktplaats.facades.AdFacadeLocal;
import nl.rkk.marktplaats.facades.BidFacadeLocal;
import nl.rkk.marktplaats.models.Ad;
import nl.rkk.marktplaats.models.Bid;
import nl.rkk.marktplaats.models.MyUser;
import nl.rkk.marktplaats.validation.Validator;
import nl.rkk.marktplaats.validation.ValidatorFactory;
import nl.rkk.marktplaats.validation.rules.BidRules;
import nl.rkk.marktplaats.validation.rules.UserRules;

/**
 *
 * @author Kaj
 */
public class CreateBidServlet extends HttpServlet {
    
    @EJB
    private BidFacadeLocal bids;
    
    @EJB
    private AdFacadeLocal ads;

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
            out.println("<title>Servlet CreateBidServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateBidServlet at " + request.getContextPath() + "</h1>");
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
        
        MyUser user = (MyUser) request.getSession().getAttribute("currentUser");
        
        if ( user == null ) {
            
            response.sendRedirect("/marktplaats-war/login");
            
        } else {
            
            Integer adId = Integer.parseInt(request.getParameter("adId"));
            
            Dictionary<String, String> input = new Hashtable<>();
            input.put("amount", request.getParameter("amount"));
        
            Validator validator = ValidatorFactory.make(BidRules.rules, input);
            
            if ( validator.passes() ) {
                
                Ad ad = this.ads.find(adId);
                
                Bid bid = new Bid();
                bid.setAmount(Double.parseDouble(input.get("amount").replace(',','.')));
                bid.setDate(new Timestamp(System.currentTimeMillis()));
                bid.setUser(user);
                bid.setAd(ad);
                
                this.bids.create(bid);
                
            } else {
                
            }
            
        }
        
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
