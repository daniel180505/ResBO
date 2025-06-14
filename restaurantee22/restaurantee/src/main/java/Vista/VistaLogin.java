package Vista;

import Dao.UsuarioDAO;
import Modelo.Usuario;

import javax.swing.*;

public class VistaLogin extends JFrame {
    private JTextField txtDni;
    private JPasswordField txtClave;
    private JButton btnLogin, btnCrearCuenta;

    public VistaLogin() {
        setTitle("Login Usuario");
        setSize(300, 250); // Aumenté un poco el alto
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 30, 100, 25);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(100, 30, 150, 25);
        add(txtDni);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(30, 70, 100, 25);
        add(lblClave);

        txtClave = new JPasswordField();
        txtClave.setBounds(100, 70, 150, 25);
        add(txtClave);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 110, 100, 30);
        add(btnLogin);

        // 🔽 Botón Crear Cuenta 🔽
        btnCrearCuenta = new JButton("Crear Cuenta");
        btnCrearCuenta.setBounds(100, 150, 120, 25);
        add(btnCrearCuenta);

        // Acción para crear cuenta
        btnCrearCuenta.addActionListener(e -> new VistaRegistro());

        // Acción para login
        btnLogin.addActionListener(e -> {
            String dni = txtDni.getText();
            String clave = new String(txtClave.getPassword());
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.login(dni, clave);
            if (u != null) {
                JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombre());
                if (u.getRol().equals("ADMIN")) {
                    new VistaAdmin(u).setVisible(true);
                } else {
                    new VistaCliente(u).setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
            }
        });

        setVisible(true);
    }
}
