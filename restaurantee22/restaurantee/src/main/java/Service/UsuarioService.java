package Service;

import Dao.UsuarioDAO;
import Modelo.Usuario;
import org.apache.commons.lang3.StringUtils;
import java.security.MessageDigest;
import java.util.logging.Logger;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAO();
    private static final Logger logger = Logger.getLogger(UsuarioService.class.getName());

    public Usuario login(String dni, String clave) {
        if (StringUtils.isBlank(dni) || StringUtils.isBlank(clave)) {
            return null;
        }
        String claveHasheada = hashClave(clave);
        return dao.login(dni, claveHasheada);
    }

    public boolean registrar(Usuario u) {
        if (StringUtils.isBlank(u.getNombre()) || StringUtils.isBlank(u.getDni()) || StringUtils.isBlank(u.getClave())) {
            return false;
        }
        u.setClave(hashClave(u.getClave()));
        return dao.insertar(u);
    }

    private String hashClave(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(clave.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            logger.severe("Error al hashear clave: " + e.getMessage());
            return null;
        }
    }
}
