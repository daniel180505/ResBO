package Modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String dni;
    private String rol;
    private String clave;


    public Usuario() {}
    public Usuario(int id, String nombre, String dni, String rol, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.rol = rol;
        this.clave = clave;
    }

    // Getters y Setters+

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
