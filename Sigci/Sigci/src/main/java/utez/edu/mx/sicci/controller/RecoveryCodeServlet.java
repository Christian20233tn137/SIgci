package utez.edu.mx.sicci.controller;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utez.edu.mx.sicci.dao.UserDao;
import utez.edu.mx.sicci.model.User;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

@WebServlet(name = "RecoveryCodeServlet", value = "/recovery-code")
public class RecoveryCodeServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correo = req.getParameter("correo");
        System.out.println("Correo enviado: " + correo);

        User user = userDao.getOneByEmail(correo);

        String code = generateCode(6);

        System.out.println("Se manda Código: " + code);

        if (user != null) {
            // El usuario existe
            boolean updateCode = userDao.updateCode(correo, code);
            if (updateCode) {
                // El código se insertó en la base
                try {
                    sendEmail(correo, code);
                    resp.sendRedirect("resetPassword.jsp");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            // El usuario no existe
        }
    }

    // Define los caracteres permitidos: dígitos y letras
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Tamaño del código
    private static final int CODE_LENGTH = 6;
    public static String generateCode(int length) {
        StringBuilder builder = new StringBuilder();
        SecureRandom random = new SecureRandom(); // Usar SecureRandom para una mejor aleatoriedad

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHA_NUMERIC_STRING.length());
            char randomChar = ALPHA_NUMERIC_STRING.charAt(randomIndex);
            builder.append(randomChar);
        }

        return builder.toString();
    }


    // Mandar Correo ↓↓↓ ------------------------------------------------------------------------
    private void sendEmail(String to, String recoveryCode) throws MessagingException {
        // Configuración del correo
        String username = "sigcisigci@gmail.com";
        String password = "bmzr byks geqh bjnv";

        // Propiedades del correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Obtener la sesión de correo
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Crear el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sigcisigci@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Código de Recuperación de Cuenta SIGCI");
        message.setText("Hola somos SIGCI, tu código de recuperación es: " + recoveryCode);

        // Enviar el mensaje
        Transport.send(message);
        System.out.println("Correo enviado exitosamente...");
    }
    // Mandar Correo ↑↑↑ ------------------------------------------------------------------------
}
