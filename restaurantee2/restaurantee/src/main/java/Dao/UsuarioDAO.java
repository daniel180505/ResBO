package Dao;

import Modelo.Usuario;
import conexion.Conexion;
import java.sql.*;

public class UsuarioDAO {
    Connection con = Conexion.conectar();

    public Usuario login(String dni, String clave) {
        Usuario u = null;
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE dni=? AND clave=?");
            ps.setString(1, dni);
            ps.setString(2, clave);
            System.out.println("Consulta: " + ps.toString()); // Imprime la consulta preparada
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario(rs.getInt("id"), rs.getString("nombre"),
                                rs.getString("dni"), rs.getString("rol"), rs.getString("clave"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
    
    public boolean insertar(Usuario u) {
    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO usuario(nombre, dni, rol, clave) VALUES (?, ?, ?, ?)");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getDni());
        ps.setString(3, u.getRol());
        ps.setString(4, u.getClave());
        ps.executeUpdate();
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}
