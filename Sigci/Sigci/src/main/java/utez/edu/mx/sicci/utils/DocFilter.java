package utez.edu.mx.sicci.utils;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;

public class DocFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user != null && user.getIdtipo_usuario() == 2) { // Verifica si el usuario es administrador
            chain.doFilter(request, response); // Permite el acceso
        } else {
            httpResponse.sendRedirect("index.jsp"); // Redirige a la página de no entrar en el perfil
        }
    }

    public void destroy() {

    }
}
