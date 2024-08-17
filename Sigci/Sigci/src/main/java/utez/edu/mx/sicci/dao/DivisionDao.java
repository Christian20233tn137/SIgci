package utez.edu.mx.sicci.dao;

import utez.edu.mx.sicci.model.Division;
import utez.edu.mx.sicci.model.Usuario_has_Materia;
import utez.edu.mx.sicci.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utez.edu.mx.sicci.utils.DatabaseConnectionManager.getConnection;

public class DivisionDao {
    private static final String SELECT_ALL_DIVISION = "SELECT * FROM division";

    private static final String SELECT_DIVISION_BY_ID = "select id_division, nombre from division where id_division = ?";


    public List<Division> getAllDivision() {
        List<Division> division = new ArrayList<>();
        try(
                Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_DIVISION);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) { // Iteramos cada fila resultado de la query
                int id_division = rs.getInt("id_division");
                String nombre = rs.getString("nombre");
                division.add(new Division(id_division, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }

    public boolean insertDiv (Division division){
        boolean flag = false;
        String query = "INSERT INTO division(id_division, nombre) values(?,?)";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,division.getId_division());
            ps.setString(2,division.getNombre());

            if(ps.executeUpdate()==1){
                flag = true; //si se inserto el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean asignar (Usuario_has_Materia usuario_has_materia){
        boolean flag = false;
        String query = "INSERT INTO usuario_has_materia(usuario_id_usuario, materia_id_materia) values(?,?)";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, usuario_has_materia.getUsuario_id_usuario());
            ps.setInt(2, usuario_has_materia.getMateria_id_materia());

            if(ps.executeUpdate()==1){
                flag = true; //si se inserto el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateDivision(Division division) throws SQLException {
        boolean flag;
        String query = "UPDATE division SET nombre = ? WHERE id_division = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, division.getNombre());
            ps.setInt(2, division.getId_division());
            flag = ps.executeUpdate() > 0;
        }
        return flag;
    }

    public Division selectDivision(int id_division) {
        Division division = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_DIVISION_BY_ID)) {
            ps.setInt(1, id_division);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                division = new Division(id_division, nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }

    public boolean deleteDiv(int id_division) throws SQLException{
        boolean flag;
        String query = "DELETE FROM division WHERE id_division = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id_division);
            flag = ps.executeUpdate()>0;
        }
        return flag;
    }

}
