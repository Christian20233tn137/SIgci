package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.model.Division;
import utez.edu.mx.sicci.model.Grupo;
import utez.edu.mx.sicci.model.Materia;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActualizarDivisionServlet", value = "/actualizarDivision")

public class ActualizarDivisionServlet extends HttpServlet {

    private DivisionDao divisionDao;

    @Override
    public void init() throws ServletException {
        divisionDao = new DivisionDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id_division = Integer.parseInt(req.getParameter("id_division"));
            String nombre = req.getParameter("nombre");
            Division division = new Division(id_division, nombre);
            divisionDao.updateDivision(division);
            resp.sendRedirect("getListaDivision");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
