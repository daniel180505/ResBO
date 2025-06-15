package Vista;

import Modelo.Usuario;

import javax.swing.*;

public class VistaAdmin extends JFrame {
    public VistaAdmin(Usuario admin) {
        setTitle("Panel Admin - " + admin.getNombre());
        setSize(400, 300);
        setLayout(null);

        JButton btnAgregarPlato = new JButton("Agregar Plato");
        btnAgregarPlato.setBounds(100, 50, 200, 30);
        add(btnAgregarPlato);

        JButton btnVerPedidos = new JButton("Ver Pedidos");
        btnVerPedidos.setBounds(100, 100, 200, 30);
        add(btnVerPedidos);

        // Eventos para mostrar formularios que tú definas (como VistaAgregarPlato, VistaPedidos)

        setVisible(true);
    }
}
