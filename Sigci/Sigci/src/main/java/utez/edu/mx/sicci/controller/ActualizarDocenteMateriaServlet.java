package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;
import utez.edu.mx.sicci.model.Usuario_has_Materia;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActualizarDocenteMateriaServlet", value = "/actualizarDocenteMateria")
public class ActualizarDocenteMateriaServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(){
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id_asignacion = Integer.parseInt(req.getParameter("id_asignacion"));
            int usuario_id_usuario = Integer.parseInt(req.getParameter("usuario_id_usuario"));
            int materia_id_materia = Integer.parseInt(req.getParameter("materia_id_materia"));

            Usuario_has_Materia usuario_has_materia = new Usuario_has_Materia(id_asignacion,usuario_id_usuario, materia_id_materia);
            userDao.updateDocenteMateria(usuario_has_materia);
            resp.sendRedirect("getListaDocenteMateria");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
