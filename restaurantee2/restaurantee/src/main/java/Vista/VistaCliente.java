package Vista;

import Modelo.Usuario;

import javax.swing.*;

public class VistaCliente extends JFrame {
    public VistaCliente(Usuario cliente) {
        setTitle("Bienvenido Cliente - " + cliente.getNombre());
        setSize(400, 300);
        setLayout(null);

        JButton btnVerPlatos = new JButton("Ver Platos y Pedir");
        btnVerPlatos.setBounds(100, 50, 200, 30);
        add(btnVerPlatos);

        // Evento que abre formulario para ver platos y pedir (como VistaMenuCliente)

        setVisible(true);
    }
}
