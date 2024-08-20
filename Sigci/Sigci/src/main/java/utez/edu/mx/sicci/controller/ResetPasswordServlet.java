package utez.edu.mx.sicci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "resetPasswordServlet", value = "/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    private UserDao usuarioDao;

    public void init() {
        usuarioDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("email");
        String newPassword = request.getParameter("password");
        String codigo = request.getParameter("cody");

        // Validar que los parámetros no sean nulos
        if (correo == null || newPassword == null || codigo == null) {
            response.sendRedirect(request.getContextPath() + "/views/ResetPassword.jsp?error=missingParams");
            return;
        }

        try {
            boolean success = usuarioDao.resetPassword(correo, newPassword, codigo);
            if (success) {
                response.sendRedirect(request.getContextPath() + "/index.jsp?passwordReset=true");
            } else {
                response.sendRedirect(request.getContextPath() + "/views/ResetPassword.jsp?error=true");
            }
        } catch (SQLException e) {
            log("Error al restablecer la contraseña", e);
            response.sendRedirect(request.getContextPath() + "/views/ResetPassword.jsp?error=true");
        }
    }
}