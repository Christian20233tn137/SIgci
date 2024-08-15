package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;

@WebServlet(name = "AdminUpdateServlet", value = "/updateAdmin")
public class AdminUpdateServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        User existingUsuario = userDao.selectUser(id_usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("actualizarAdmin.jsp");
        request.setAttribute("user", existingUsuario);
        dispatcher.forward(request, response);
    }
}
