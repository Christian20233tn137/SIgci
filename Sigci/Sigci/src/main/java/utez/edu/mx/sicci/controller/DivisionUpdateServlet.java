package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.model.Division;
import utez.edu.mx.sicci.model.Grupo;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;

@WebServlet(name = "DivisionUpdateServlet", value = "/updateDivision")

public class DivisionUpdateServlet extends HttpServlet {

    private DivisionDao divisionDao;

    @Override
    public void init() throws ServletException {
        divisionDao = new DivisionDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_division = Integer.parseInt(request.getParameter("id_division"));
        Division existingDivision = divisionDao.selectDivision(id_division);
        RequestDispatcher dispatcher = request.getRequestDispatcher("actualizarDivision.jsp");
        request.setAttribute("division", existingDivision);
        dispatcher.forward(request, response);
    }
}
