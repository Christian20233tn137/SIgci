package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.dao.CarreraDao;
import utez.edu.mx.sicci.dao.DivisionDao;
import utez.edu.mx.sicci.model.Carrrera;
import utez.edu.mx.sicci.model.Usuario_has_Materia;

import java.io.IOException;


@WebServlet(name = "AsignarDocenteMateriaServlet", value = "/asignarMateriaDocente")
public class AsignarDocenteMateriaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario_has_Materia usuario_has_materia = new Usuario_has_Materia();
        usuario_has_materia.setUsuario_id_usuario(Integer.parseInt(req.getParameter("usuario_id_usuario")));
        usuario_has_materia.setMateria_id_materia(Integer.parseInt(req.getParameter("materia_id_materia")));

        // Se llama al DAO para insertar

        DivisionDao dao = new DivisionDao();
        if (dao.asignar(usuario_has_materia)){
            resp.sendRedirect("getListaDocenteMateria");
        }else {
            // La info no a sido insertada y regresa al formulario
            HttpSession session = req.getSession();
            session.setAttribute("mensajaeError", "Puede que el grupo ya haya sido registrado");
            resp.sendRedirect("asignarMateriaDocente");
        }
    }
}
