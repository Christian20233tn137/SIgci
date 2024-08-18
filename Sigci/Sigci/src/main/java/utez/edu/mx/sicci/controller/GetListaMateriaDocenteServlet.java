package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;
import utez.edu.mx.sicci.model.Usuario_has_Materia;

import java.io.IOException;
import java.util.List;

@WebServlet(name="GetListaMateriaDocenteServlet", value = "/getListaMateriaDocente")
public class GetListaMateriaDocenteServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId")); // Obtener el ID del usuario desde la solicitud
        List<Usuario_has_Materia> usuario_has_materiaa = userDao.getMateriasByUser(userId);
        req.setAttribute("usuario_has_materiaa", usuario_has_materiaa);
        RequestDispatcher rd = req.getRequestDispatcher("listaRelacionDocenteMateria.jsp");
        rd.forward(req, resp);
    }
}

