package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;
import java.util.List;


@WebServlet(name="GetListaEstadoAspirantesServlet", value = "/getListaEstadoAspirantes")

public class GetListaEstadoAspirantesServlet extends HttpServlet {

    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> lista_admin_aspirantes = dao.getAllAspirantes();
        req.setAttribute("lista_admin_aspirantes", lista_admin_aspirantes);
        RequestDispatcher rd = req.getRequestDispatcher("estadoAspirantes.jsp");
        rd.forward(req,resp);
    }

}
