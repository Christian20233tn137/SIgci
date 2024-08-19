package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.MateriaDao;
import utez.edu.mx.sicci.model.Materia;

import java.io.IOException;

@WebServlet(name="RegistrarMateriasServlet", value = "/registrarMateria")

public class RegistrarMateriasServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Materia materia = new Materia();
        materia.setNombre_materia(req.getParameter("nombre_materia"));

        // Se llama al DAO para insertar

        MateriaDao dao = new MateriaDao();
        if (dao.insert(materia)){
            resp.sendRedirect("gestionarMat.jsp");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("mensajaeError", "Puede que la materia ya haya sido registrada");
            resp.sendRedirect("registrarMateria.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registrarMateria.jsp").forward(req, resp);
    }
}
