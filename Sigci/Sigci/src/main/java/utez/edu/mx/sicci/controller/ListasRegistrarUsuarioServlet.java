package utez.edu.mx.sicci.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.dao.GrupoDao;
import utez.edu.mx.sicci.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ListasRegistrarUsuarioServlet", value = "/listasParaUsuario")
public class ListasRegistrarUsuarioServlet extends HttpServlet {

            private DivisionDao divisionDao;
            private GrupoDao grupoDao;

            @Override
            public void init() throws ServletException {
                divisionDao = new DivisionDao();
                grupoDao = new GrupoDao();
            }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Grupo> grupoList = grupoDao.getAllGrupo();
        req.setAttribute("grupoList", grupoList);
        List<Division> divisionList = divisionDao.getAllDivision();
        req.setAttribute("divisionList",divisionList);
        RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
        rd.forward(req,resp);

    }
}
