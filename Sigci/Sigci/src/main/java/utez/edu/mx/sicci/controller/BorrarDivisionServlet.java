package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.dao.MateriaDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BorrarDivisionServlet", value = "/borrarDivision")

public class BorrarDivisionServlet extends HttpServlet {

    private DivisionDao divisionDao;

    @Override
    public void init() throws ServletException {
        divisionDao = new DivisionDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            int id_division = Integer.parseInt(req.getParameter("id_division"));
            divisionDao.deleteDiv(id_division);
            resp.sendRedirect("getListaDivision");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
