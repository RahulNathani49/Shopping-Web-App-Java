/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Shoppingapp.controllers;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.Product;
import com.Shoppingapp.service.ProductService;
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
import javax.validation.ValidationException;

/**
 *
 * @author isi
 */
@WebServlet(name = "fetchproducts", urlPatterns = {"/fetchproducts"})
public class fetchproducts extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, Userexception {
//        try{  
//             ProductService service = new ProductService();
//             ArrayList<Product> productList = null;
//           try {
//               productList = service.fetchProducts();
//           } catch (SQLException | Userexception ex) {
//               Logger.getLogger(fetchproducts.class.getName()).log(Level.SEVERE, null, ex);
//           }
//             if (productList!=null) {
//                request.setAttribute("productList", productList);
//             }
//          request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
//
//      }catch(Userexception ex){
//          String exceptionMessage = ex.getMessage();
//          request.setAttribute("message", exceptionMessage);
//      }
//           request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        ProductService service = new ProductService();
        ArrayList<Product> productList = service.fetchProducts();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);


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
            Logger.getLogger(fetchproducts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(fetchproducts.class.getName()).log(Level.SEVERE, null, ex);
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
