package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.CarreraDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.model.Carrrera;
import utez.edu.mx.sicci.model.Carrrera;
import utez.edu.mx.sicci.model.Grupo;

import java.io.IOException;

@WebServlet(name="RegistrarCarreraServlet", value = "/registrarCarrera")

public class RegistrarCarreraServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Carrrera carrrera = new Carrrera();
        carrrera.setDescripcion(req.getParameter("descripcion"));
        carrrera.setId_division(Integer.parseInt(req.getParameter("id_division")));

        // Se llama al DAO para insertar

        CarreraDao dao = new CarreraDao();
        if (dao.insert(carrrera)){
            resp.sendRedirect("gestCarrera.jsp");
        }else {
            // La info no a sido insertada y regresa al formulario
            HttpSession session = req.getSession();
            session.setAttribute("mensajaeError", "Puede que el grupo ya haya sido registrado");
            resp.sendRedirect("registrarCarrera");
        }
    }
}
