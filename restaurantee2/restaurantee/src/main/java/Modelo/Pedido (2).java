package Modelo;

public class Pedido {
    private int id;
    private int idUsuario;
    private String fecha;

    public Pedido() {}
    public Pedido(int id, int idUsuario, String fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
