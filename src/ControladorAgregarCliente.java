import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

// Definición de la clase ControladorAgregarCliente que implementa la interfaz ActionListener
public class ControladorAgregarCliente implements ActionListener {
    private VentanaAgregarCliente vista; // Referencia a la ventana de agregar cliente
    private ControladorMenu controladorMenu; // Referencia al controlador del menú
    private Cliente cliente; // Referencia al cliente que se está agregando
    private int rut = 0; // Variable para almacenar el RUT del cliente
    
    // Constructor que recibe la ventana de agregar cliente y el controlador del menú
    public ControladorAgregarCliente(VentanaAgregarCliente vista, ControladorMenu controladorMenu) {
        this.vista = vista; // Inicializa la referencia a la ventana
        this.controladorMenu = controladorMenu; // Inicializa la referencia al controlador del menú

        // Agrega el controlador como oyente a los botones de la ventana
        this.vista.btnAnadirPaquetes.addActionListener(this);
        this.vista.btnConfirmar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource(); // Obtiene el objeto que generó el evento

        // Verifica si el evento proviene del botón Confirmar o Añadir Paquetes
        if (source == vista.btnConfirmar || source == vista.btnAnadirPaquetes) {
            try {
                // Obtiene el RUT del cliente desde la vista
                rut = vista.obtenerRut();
            } catch(Exception ex) { // Captura cualquier excepción de formato en el RUT
                JOptionPane.showMessageDialog(vista, "Ingrese un valor válido para el RUT", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Obtiene el nombre del cliente desde la vista
            String nombre = vista.obtenerNombre();

            // Intenta agregar el cliente al controlador del menú
            cliente = controladorMenu.agregarCliente(rut, nombre);
            
            // Verifica si el cliente ya existe
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese rut", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Si se presionó el botón Añadir Paquetes, abre la ventana para agregar paquetes
            if (source == vista.btnAnadirPaquetes) {
                VentanaAgregarPaquete ventanaAgregarPaquete = new VentanaAgregarPaquete();
                ControladorAgregarPaquete controladorAgregarPaquete = new ControladorAgregarPaquete(ventanaAgregarPaquete, cliente);
                ventanaAgregarPaquete.setVisible(true);
            }
            vista.dispose(); // Cierra la ventana de agregar cliente
        } else if (source == vista.btnCancelar) { // Si se presionó el botón Cancelar, cierra la ventana
            vista.dispose();
        }
    }
}
