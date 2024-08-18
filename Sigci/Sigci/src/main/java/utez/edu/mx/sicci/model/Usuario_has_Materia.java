package utez.edu.mx.sicci.model;

public class Usuario_has_Materia {

    private int id_asignacion;
    private int usuario_id_usuario;
    private int materia_id_materia;
    private String nombreDocente;
    private String nombreMateria;



    public Usuario_has_Materia(int id_asignacion,int usuario_id_usuario, int materia_id_materia) {
        this.id_asignacion = id_asignacion;
        this.usuario_id_usuario = usuario_id_usuario;
        this.materia_id_materia = materia_id_materia;
    }

    public Usuario_has_Materia(int usuario_id_usuario, int materia_id_materia, String nombreDocente, String nombreMateria) {
        this.usuario_id_usuario = usuario_id_usuario;
        this.materia_id_materia = materia_id_materia;
        this.nombreDocente = nombreDocente;
        this.nombreMateria = nombreMateria;
    }



    public Usuario_has_Materia(){

    }



    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getMateria_id_materia() {
        return materia_id_materia;
    }

    public void setMateria_id_materia(int materia_id_materia) {
        this.materia_id_materia = materia_id_materia;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }
}
