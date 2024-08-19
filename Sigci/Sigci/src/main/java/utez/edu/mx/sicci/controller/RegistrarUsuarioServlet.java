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
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name="RegistrarUsuarioServlet", value = "/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User();
            user.setNombre(req.getParameter("nombre"));
            user.setApellidos(req.getParameter("apellidos"));
            user.setEmail(req.getParameter("email"));
            user.setCurp(req.getParameter("curp"));
            user.setFecha_nacimiento(req.getParameter("fecha_nacimiento"));
            user.setPassword(req.getParameter("password"));
            user.setNombre_usuario(req.getParameter("nombre_usuario"));
            user.setId_division(Integer.parseInt(req.getParameter("id_division")));
            user.setId_grupo(Integer.parseInt(req.getParameter("id_grupo")));

            //Se debe mandar a llamar un DAO que permita insertar
            UserDao dao = new UserDao();
            if (dao.insert(user)) {
                //respuesta hacia un jsp
                resp.sendRedirect("gestionarDoc.jsp");
            } else {
                //la info no se insertó y regresa al formulario
                HttpSession session = req.getSession();
                session.setAttribute("mensajeError", "Puede que el usuario ya esté registrado");
                resp.sendRedirect("registrar.jsp");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("mensajeError", "ID de tipo de usuario, división o grupo no válidos.");
            req.getRequestDispatcher("registrar.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("mensajeError", "Error inesperado: " + e.getMessage());
            req.getRequestDispatcher("registrar.jsp").forward(req, resp);
        }
    }
}


