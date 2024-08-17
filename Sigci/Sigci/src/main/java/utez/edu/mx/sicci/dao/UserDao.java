package utez.edu.mx.sicci.dao;

import utez.edu.mx.sicci.model.Materia;
import utez.edu.mx.sicci.model.User;
import utez.edu.mx.sicci.model.Usuario_has_Materia;
import utez.edu.mx.sicci.utils.DatabaseConnectionManager;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static utez.edu.mx.sicci.utils.DatabaseConnectionManager.getConnection;


public class UserDao {
    private static final String SELECT_ALL_USERS = "SELECT * FROM usuario where idtipo_usuario = 2";

    private static final String SELECT_ALL_DOCENTE = "SELECT u.id_usuario, u.nombre, u.apellidos, u.email, u.curp, u.fecha_nacimiento, u.password, u.estado_password, u.nombre_usuario, u.fecha_creacion, u.estado_usuario, u.idtipo_usuario, d.nombre AS division_nombre, u.id_grupo FROM usuario u INNER JOIN division d ON u.id_division = d.id_division WHERE u.idtipo_usuario = 2;";

    private static final String SELECT_ALL_ADMIN = "SELECT * from usuario WHERE idtipo_usuario = 1;";

    private static final String SELECT_ALL_ASPIRANTES = "SELECT u.id_usuario, u.nombre, u.apellidos, u.email, u.curp, u.fecha_nacimiento, u.password, u.estado_password, u.nombre_usuario, u.fecha_creacion, u.estado_usuario, u.idtipo_usuario, d.nombre AS division_nombre, u.id_grupo FROM usuario u INNER JOIN division d ON u.id_division = d.id_division WHERE u.idtipo_usuario = 3;";

    private static final String SELECT_USER_BY_ID = "SELECT id_usuario, nombre, apellidos, email, curp, nombre_usuario, estado_usuario FROM usuario WHERE id_usuario = ?";

    private static final String SELECT_DOCENTE_MATERIA_BY_ID = "SELECT CONCAT(u.nombre, ' ', u.apellidos) AS nombre_completo, m.nombre_materia AS nombre , u.id_usuario , m.id_materia FROM usuario_has_materia um INNER JOIN usuario u ON um.usuario_id_usuario = u.id_usuario INNER JOIN materia m ON um.materia_id_materia = m.id_materia where usuario_id_usuario = ?";

    private static final String SELECT_ALL_MATERIA_DOCENTE = "SELECT CONCAT(u.nombre, ' ', u.apellidos) AS nombre_completo, m.nombre_materia AS nombre , u.id_usuario , m.id_materia, id_asignacion FROM usuario_has_materia um INNER JOIN usuario u ON um.usuario_id_usuario = u.id_usuario INNER JOIN materia m ON um.materia_id_materia = m.id_materia";


    // Encontrar el usuario a partir del correo
    public User getOne(String correo, String pass){
        User u = new User();
        //Los simbolos ? son para evitar la inyección de código SQL
        String query = "select * from usuario where email = ? and password = sha2(?,256)";

        try{
            //Conectarme a la base de datos
            Connection con = getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")
            ps.setString(1 , correo);
            ps.setString(2 , pass);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //Que el usuario si exite en la base de datos
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public User getOneByEmail(String correo){
        User u = new User();
        //Los simbolos ? son para evitar la inyección de código SQL
        String query = "select * from usuario where email = ?";

        try{
            //Conectarme a la base de datos
            Connection con = getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")
            ps.setString(1 , correo);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //Que el usuario si exite en la base de datos
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }


    public boolean insert(User user) {
        boolean flag = false;
        String query = "INSERT INTO usuario(nombre, apellidos, email, curp, fecha_nacimiento, password, estado_password, estado_usuario, nombre_usuario, fecha_creacion, idtipo_usuario, id_division, id_grupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraFormatted = fechaHora.format(formatter);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCurp());
            ps.setString(5, user.getFecha_nacimiento());
            ps.setString(6, user.getPassword());
            ps.setString(7, "Active"); // Usa constantes para estos valores
            ps.setInt(8, 1);
            ps.setString(9, user.getNombre_usuario());
            ps.setString(10, fechaHoraFormatted);
            ps.setInt(11, 2);
            ps.setInt(12, user.getId_division());
            ps.setInt(13, user.getId_grupo());

            if (ps.executeUpdate() == 1) {
                flag = true; // Si se insertó el dato
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera registrar la excepción en lugar de imprimirla
        }

        return flag;
    }

    public ArrayList<User> getAll() {
        ArrayList<User> usuario = new ArrayList<>();
        try(
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                User u = new User();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
                u.setId_division(rs.getInt("id_division"));
                u.setId_grupo(rs.getInt("id_grupo"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public ArrayList<User> getAllDocente() {
        ArrayList<User> usuario = new ArrayList<>();
        try(
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_DOCENTE);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                User u = new User();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
                u.setId_grupo(rs.getInt("id_grupo"));
                // Reemplazar el id_division con el nombre de la división
                u.setDivisionNombre(rs.getString("division_nombre"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public ArrayList<User> getAllAdmin() {
        ArrayList<User> usuario = new ArrayList<>();
        try(
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_ADMIN);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                User u = new User();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public User selectUser(int id_usuario) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID)) {
             ps.setInt(1, id_usuario);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String curp = rs.getString("curp");
                String nombre_usuario = rs.getString("nombre_usuario");
                int estado_usuario = rs.getInt("estado_usuario");
                user = new User(id_usuario, nombre, apellidos, email, curp, estado_usuario, nombre_usuario);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public User getOne(int id_usuario){
        User u = new User();
        String query = "select * from usuario where id_usuario = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1 , id_usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public User getOne(String email){
        User u = new User();
        String query = "select * from usuario where email = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("id_division"));
                u.setId_grupo(rs.getInt("id_grupo"));
                u.setEstado(u.getEstado_usuario() == 1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean update(User user) throws SQLException {
        boolean flag;
        String query = "update usuario set nombre = ?, apellidos = ?, email = ?, curp = ?, nombre_usuario = ?, estado_usuario = ? where id_usuario = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCurp());
            ps.setString(5, user.getNombre_usuario());
            ps.setInt(6, user.getEstado_usuario());
            ps.setInt(7, user.getId_usuario());
            flag = ps.executeUpdate() > 0;
        }
            return flag;
    }

    public boolean updateCode(String correo, String code) {
        boolean flag = false;
        String query = "update usuario set cody = ? where email = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, code);
            ps.setString(2, correo);
            flag = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(int id_usuario) throws SQLException{
        boolean flag;
        String sql = "update usuario set estado_usuario = 0 where id_usuario = ? ";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id_usuario);
            flag = ps.executeUpdate()>0;
        }
        return flag;
    }

    public boolean aprobar(int id_usuario) throws SQLException{
        boolean flag;
        String sql = "update usuario set estado_usuario = 1 where id_usuario = ? ";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id_usuario);
            flag = ps.executeUpdate()>0;
        }
        return flag;
    }

    public ArrayList<User> getAllAspirantes() {
        ArrayList<User> usuario = new ArrayList<>();
        try(
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_ASPIRANTES);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                User u = new User();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setCurp(rs.getString("curp"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setPassword(rs.getString("password"));
                u.setEstado_password(rs.getString("estado_password"));
                u.setEstado_usuario(rs.getInt("estado_usuario"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setFecha_creacion(rs.getString("fecha_creacion"));
                u.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
                u.setId_grupo(rs.getInt("id_grupo"));
                // Reemplazar el id_division con el nombre de la división
                u.setDivisionNombre(rs.getString("division_nombre"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public boolean resetPassword(String correo, String newPassword, String codigo) throws SQLException {
        String sql = "UPDATE usuario SET password = sha2(?,256) WHERE email = ? AND cody = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, correo);
            stmt.setString(3, codigo);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    public boolean insertAdmin(User user) {
        boolean flag = false;
        String query = "INSERT INTO usuario(nombre, apellidos, email, curp, fecha_nacimiento, password, estado_password, estado_usuario, nombre_usuario, fecha_creacion, idtipo_usuario) VALUES (?, ?, ?, ?, ?, sha2(?,256), ?, ?, ?, ?, ?);";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraFormatted = fechaHora.format(formatter);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCurp());
            ps.setString(5, user.getFecha_nacimiento());
            ps.setString(6, user.getPassword());
            ps.setString(7, "Active"); // Usa constantes para estos valores
            ps.setInt(8, 1);
            ps.setString(9, user.getNombre_usuario());
            ps.setString(10, fechaHoraFormatted);
            ps.setInt(11, 1);

            if (ps.executeUpdate() == 1) {
                flag = true; // Si se insertó el dato
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera registrar la excepción en lugar de imprimirla
        }

        return flag;
    }

    public ArrayList<Usuario_has_Materia> getAllDocenteMateria() {
        ArrayList<Usuario_has_Materia> usuario_has_materia = new ArrayList<>();
        try(
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_MATERIA_DOCENTE);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                Usuario_has_Materia um = new Usuario_has_Materia();
                um.setNombreDocente(rs.getString("nombre_completo"));
                um.setNombreMateria(rs.getString("nombre"));
                um.setUsuario_id_usuario(rs.getInt("id_usuario"));
                um.setMateria_id_materia(rs.getInt("id_materia"));
                um.setId_asignacion(rs.getInt("id_asignacion"));
                usuario_has_materia.add(um);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario_has_materia;
    }

    public Usuario_has_Materia selectDocenteMateria(int usuario_id_usuario) {
        Usuario_has_Materia usuario_has_materia = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_DOCENTE_MATERIA_BY_ID)) {
            ps.setInt(1, usuario_id_usuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreDocente = rs.getString("nombre_completo");
                String nombreMateria = rs.getString("nombre");
                int id_usuario = rs.getInt("id_usuario");
                int materia_id_materia = rs.getInt("id_materia");
                usuario_has_materia = new Usuario_has_Materia(id_usuario, materia_id_materia ,nombreDocente,nombreMateria );
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuario_has_materia;
    }

    public boolean updateDocenteMateria(Usuario_has_Materia usuario_has_materia) throws SQLException {
        boolean flag;
        String query = "update usuario_has_materia set usuario_id_usuario = ?, materia_id_materia = ? where id_asignacion = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, usuario_has_materia.getUsuario_id_usuario());
            ps.setInt(2, usuario_has_materia.getMateria_id_materia());
            ps.setInt(3,usuario_has_materia.getId_asignacion());
            flag = ps.executeUpdate() > 0;
        }
        return flag;
    }

    public boolean updatePass(String correo, String newPassword) throws SQLException {
        String sql = "UPDATE usuario SET password = sha2(?,256) WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, correo);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public boolean deleteAsig(int id_asignacion) throws SQLException{
        boolean flag;
        String query = "DELETE FROM usuario_has_materia WHERE id_asignacion = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id_asignacion);
            flag = ps.executeUpdate()>0;
        }
        return flag;
    }
}

