package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActualizarAdminServlet", value = "/actualizarAdmin")
public class ActualizarAdminServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(){
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            int id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
            String nombre = req.getParameter("nombre");
            String apellidos = req.getParameter("apellidos");
            String email = req.getParameter("email");
            String curp = req.getParameter("curp");
            int estado_usuario = Integer.parseInt(req.getParameter("estado_usuario"));
            String nombre_usuario = req.getParameter("nombre_usuario");

            User user = new User(id_usuario, nombre, apellidos, email, curp ,estado_usuario,nombre_usuario);
            userDao.update(user);
            resp.sendRedirect("getListaAdmin");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
