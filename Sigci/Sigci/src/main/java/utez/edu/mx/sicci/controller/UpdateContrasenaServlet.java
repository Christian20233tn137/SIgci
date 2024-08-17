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

@WebServlet(name = "UpdateContrasenaServlet", value = "/actu-password")
public class UpdateContrasenaServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("email");
        String newPassword = request.getParameter("password");
        int tipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));

        try {
            boolean success = userDao.updatePass(correo, newPassword);
            if (success && tipoUsuario == 1) {
                response.sendRedirect("menuAdminppal.jsp");
            } else if(success && tipoUsuario == 2){
                response.sendRedirect("menuDocppal.jsp");
            }else {
                response.sendRedirect(request.getContextPath() + "/views/ResetPassword.jsp?error=true");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
