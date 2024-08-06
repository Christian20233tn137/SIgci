package utez.edu.mx.sicci.model;

public class User {

    private String divisionNombre;
    private int id_usuario;
    private String nombre;
    private String apellidos;
    private String email;
    private String curp;
    private String fecha_nacimiento;
    private String password;
    private String estado_password;
    private int estado_usuario;
    private String nombre_usuario;
    private String fecha_creacion;
    private int idtipo_usuario;
    private int id_division;
    private int id_grupo;

    private boolean estado;



    public User() {

    }

    public User(int id_usuario, String nombre, String apellidos, String email, String curp, int estado_usuario, String nombre_usuario) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curp = curp;
        this.estado_usuario = estado_usuario;
        this.nombre_usuario = nombre_usuario;
    }

    public User(String nombre, String apellidos, String email, String curp, String fecha_nacimiento, String password, String estado_password, int estado_usuario, String nombre_usuario, String fecha_creacion, int idtipo_usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curp = curp;
        this.fecha_nacimiento = fecha_nacimiento;
        this.password = password;
        this.estado_password = estado_password;
        this.estado_usuario = estado_usuario;
        this.nombre_usuario = nombre_usuario;
        this.fecha_creacion = fecha_creacion;
        this.idtipo_usuario = idtipo_usuario;
    }

    public User(int id_usuario, String nombre, String apellidos, String email, String curp, String fecha_nacimiento, String password, String estado_password, int estado_usuario, String nombre_usuario, String fecha_creacion, int idtipo_usuario, int id_division, int id_grupo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curp = curp;
        this.fecha_nacimiento = fecha_nacimiento;
        this.password = password;
        this.estado_password = estado_password;
        this.estado_usuario = estado_usuario;
        this.nombre_usuario = nombre_usuario;
        this.fecha_creacion = fecha_creacion;
        this.idtipo_usuario = idtipo_usuario;
        this.id_division = id_division;
        this.id_grupo = id_grupo;
    }

    public User(String nombre, String apellidos, String email, String curp, String fecha_nacimiento, String password, String nombre_usuario, int idtipo_usuario, int id_division, int id_grupo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curp = curp;
        this.fecha_nacimiento = fecha_nacimiento;
        this.password = password;
        this.nombre_usuario = nombre_usuario;
        this.idtipo_usuario = idtipo_usuario;
        this.id_division = id_division;
        this.id_grupo = id_grupo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado_password() {
        return estado_password;
    }

    public void setEstado_password(String estado_password) {
        this.estado_password = estado_password;
    }

    public int getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(int estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdtipo_usuario() {
        return idtipo_usuario;
    }

    public void setIdtipo_usuario(int idtipo_usuario) {
        this.idtipo_usuario = idtipo_usuario;
    }

    public int getId_division() {
        return id_division;
    }

    public void setId_division(int id_division) {
        this.id_division = id_division;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getDivisionNombre() {
        return divisionNombre;
    }

    public void setDivisionNombre(String divisionNombre) {
        this.divisionNombre = divisionNombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
