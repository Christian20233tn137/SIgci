package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.MateriaDao;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.Materia;
import utez.edu.mx.sicci.model.User;
import utez.edu.mx.sicci.model.Usuario_has_Materia;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DocenteMateriaUpdateServlet", value = "/updateDocenteMateria")
public class DocenteMateriaUpdateServlet extends HttpServlet {

    private UserDao userDao;
    private MateriaDao materiaDao;


    @Override
    public void init() {
        userDao = new UserDao();
        materiaDao = new MateriaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_asignacion = Integer.parseInt(request.getParameter("id_asignacion"));
        request.setAttribute("id_asignacion", id_asignacion);
        List<User> lista_docente = userDao.getAllDocente();
        List<Materia> lista_materia = materiaDao.getAllMateria();
        RequestDispatcher dispatcher = request.getRequestDispatcher("actualizarDocenteMateria.jsp");
        request.setAttribute("lista_docente", lista_docente);
        request.setAttribute("lista_materia", lista_materia);
        dispatcher.forward(request, response);
    }
}
