/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Shoppingapp.controllers;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.User;
import com.Shoppingapp.models.UserCartItems;
import com.Shoppingapp.service.CartService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author isi
 */
@WebServlet(name = "cartController", urlPatterns = {"/cart"})
public class cartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, Userexception {
        CartService service = new CartService();
        HttpSession session= request.getSession(true);
        User user = (User) session.getAttribute("loggeduser");

        String action = request.getParameter("action");
        String quantity = request.getParameter("quantity");
        String productid = request.getParameter("productid");
        String cartid=request.getParameter("cartid");
        if (user!=null) {
            if ("add".equals(action)) {
            service.addQuantity(user.getUsername(),productid,quantity);
        }
        if ("remove".equals(action)) {
            service.removeQuantity(user.getUsername(),productid,quantity);
        } 
        }
        
        
        if (quantity!=null && cartid!=null) {
        int cart = Integer.parseInt(cartid);
     
        
        
        }
          if (user!=null) {
            ArrayList<UserCartItems> cartitems = service.fetchCartItems(user.getUsername());
            request.setAttribute("usercartitems", cartitems);
        }
        request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException | Userexception ex) {
            Logger.getLogger(cartController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException | Userexception ex) {
            Logger.getLogger(cartController.class.getName()).log(Level.SEVERE, null, ex);
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
