package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BorrarAsignacionMatDocServlet", value = "/borrarAsignacion")
public class BorrarAsignacionMatDocServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            int id_asignacion = Integer.parseInt(req.getParameter("id_asignacion"));
            userDao.deleteAsig(id_asignacion);
            resp.sendRedirect("getListaDocenteMateria");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
