/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import root.model.dao.MasterClienteDAO;
import root.model.entities.MasterCliente;

/**
 *
 * @author ateoa
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

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
        
        String identificacion = request.getParameter("identificacion");
        String nombres = request.getParameter("nombres");
        String apellido1 = request.getParameter("apellido1");
        
        MasterCliente cliente = new MasterCliente();
        cliente.setCliNombres(identificacion);
        cliente.setCliNombres(nombres);
        cliente.setCliApellido1(apellido1);
        
        MasterClienteDAO dao = new MasterClienteDAO();
        try {
            dao.create(cliente);
            Logger.getLogger("log").log(Level.INFO, "valor identificacion cliente: {0}", cliente.getCliIdentificacion());
        } catch (Exception ex) {
            Logger.getLogger("log").log(Level.SEVERE, "error al ingresar cliente {0}", ex.getMessage());
            
        }
        
        request.getRequestDispatcher("salida.jsp").forward(request, response);
        
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
