import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// Clase ControladorInicioSesion que implementa la interfaz ActionListener
public class ControladorInicioSesion implements ActionListener {
    private VentanaInicioSesion vista; // Referencia a la ventana de inicio de sesión
    private Trabajador trabajador; // Instancia de la clase Trabajador para almacenar la información del usuario

    // Constructor que recibe la ventana de inicio de sesión
    public ControladorInicioSesion(VentanaInicioSesion vista) {
        this.vista = vista; // Inicializa la referencia a la ventana
        this.trabajador = new Trabajador(); // Inicializa la instancia de Trabajador
        // Agrega el controlador como oyente a los botones de entrar y salir de la ventana
        this.vista.btnEntrar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana de inicio de sesión
    public void actionPerformed(ActionEvent e) {
        // Si el evento proviene del botón Entrar
        if (e.getSource() == vista.btnEntrar) {
            // Obtiene el nombre y el RUT del trabajador desde la ventana y los asigna al objeto Trabajador
            trabajador.setNombre(vista.txtNombre.getText());
            trabajador.setRut(Integer.parseInt(vista.txtRut.getText()));
            
            // Si las credenciales son válidas
            if (validarCredenciales(trabajador.getNombre(), trabajador.getRut())) {
                try {
                    abrirMenu(); // Abre el menú principal
                } catch (IOException ex) {
                    // Si ocurre un error al abrir el menú, muestra un mensaje de error
                    Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { // Si las credenciales no son válidas
                // Muestra un mensaje de error
                JOptionPane.showMessageDialog(vista, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == vista.btnSalir) { // Si el evento proviene del botón Salir
            vista.dispose(); // Cierra la ventana de inicio de sesión
        }
    }

    // Método para validar las credenciales del trabajador
    private boolean validarCredenciales(String nombre, int rut) {
        // Las credenciales son válidas si el nombre no está vacío y el RUT es mayor que 0
        return !nombre.isEmpty() && rut > 0;
    }

    // Método para abrir el menú principal
    private void abrirMenu() throws IOException {
        vista.dispose(); // Cierra la ventana de inicio de sesión

        // Crea una nueva ventana de menú
        VentanaMenu ventanaMenu = new VentanaMenu();
        // Crea un nuevo controlador de menú y lo inicializa
        ControladorMenu controladorMenu = new ControladorMenu(ventanaMenu);
        controladorMenu.iniciar();
        // Hace visible la ventana de menú
        ventanaMenu.setVisible(true);
    }
}
