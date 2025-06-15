package Vista;

import Dao.UsuarioDAO;
import Modelo.Usuario;

import javax.swing.*;

public class VistaRegistro extends JFrame {
    private JTextField txtNombre, txtDni;
private JComboBox<String> cboRol;
    private JPasswordField txtClave;
    private JButton btnRegistrar;

    public VistaRegistro() {
        setTitle("Registrar Nuevo Usuario");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Solo cerrar esta ventana

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 30, 150, 25);
        add(txtNombre);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 70, 100, 25);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(130, 70, 150, 25);
        add(txtDni);

        JLabel lblRol = new JLabel("Rol (ADMIN/CLIENTE):");
        lblRol.setBounds(30, 110, 150, 25);
        add(lblRol);

        cboRol = new JComboBox<>(new String[]{"ADMIN", "CLIENTE"});
        cboRol.setBounds(180, 110, 100, 25);
        add(cboRol);


        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(30, 150, 100, 25);
        add(lblClave);

        txtClave = new JPasswordField();
        txtClave.setBounds(130, 150, 150, 25);
        add(txtClave);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(110, 200, 120, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            Usuario u = new Usuario();
            u.setNombre(txtNombre.getText());
            u.setDni(txtDni.getText());
            u.setRol((String) cboRol.getSelectedItem());
            u.setClave(new String(txtClave.getPassword()));

            UsuarioDAO dao = new UsuarioDAO();
            if (dao.insertar(u)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                dispose(); // Cierra la ventana
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
            }
        });


        setVisible(true);
    }
}
