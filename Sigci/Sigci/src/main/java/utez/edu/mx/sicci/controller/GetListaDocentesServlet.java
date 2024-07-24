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
import java.util.ArrayList;

@WebServlet(name="GetListaDocentesServlet", value = "/getListaDocentes")
public class GetListaDocentesServlet extends HttpServlet {

    private UserDao dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> lista_user = dao.getAll();
        req.setAttribute("lista_user", lista_user);
        RequestDispatcher rd = req.getRequestDispatcher("listaUsuarios.jsp");
        rd.forward(req,resp);
    }
}
