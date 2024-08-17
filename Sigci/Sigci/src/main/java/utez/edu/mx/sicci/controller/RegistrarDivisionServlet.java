package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.model.Division;
import utez.edu.mx.sicci.model.Grupo;

import java.io.IOException;

@WebServlet(name="RegistrarDivisionServlet", value = "/registrarDivision")
public class RegistrarDivisionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Division division = new Division();
        division.setNombre(req.getParameter("nombre"));

        // Se llama al DAO para insertar

        DivisionDao dao = new DivisionDao();
        if (dao.insertDiv(division)){
            resp.sendRedirect("menuAdminppal.jsp");
        }else{
            // La info no a sido insertada y regresa al formulario
            HttpSession session = req.getSession();
            session.setAttribute("mensajaeError", "Puede que el grupo ya haya sido registrado");
            resp.sendRedirect("registrarDivision");
        }
    }
}
