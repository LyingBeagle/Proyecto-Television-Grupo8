import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Definición de la clase ControladorAgregarPaqueteCliente que implementa la interfaz ActionListener
public class ControladorAgregarPaqueteCliente implements ActionListener {
    private VentanaAgregarPaqueteCliente ventanaAgregarPaqueteCliente; // Referencia a la ventana para agregar paquete al cliente
    private ControladorMenu controladorMenu; // Referencia al controlador del menú

    // Constructor que recibe la ventana para agregar paquete al cliente y el controlador del menú
    public ControladorAgregarPaqueteCliente(VentanaAgregarPaqueteCliente ventanaAgregarPaqueteCliente, ControladorMenu controladorMenu) {
        this.ventanaAgregarPaqueteCliente = ventanaAgregarPaqueteCliente; // Inicializa la referencia a la ventana
        this.controladorMenu = controladorMenu; // Inicializa la referencia al controlador del menú

        // Agrega el controlador como oyente a los botones de la ventana
        this.ventanaAgregarPaqueteCliente.btnAgregar.addActionListener(this);
        this.ventanaAgregarPaqueteCliente.btnCancelar.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana
    public void actionPerformed(ActionEvent e) {
        // Verifica si el evento proviene del botón Agregar
        if (e.getSource() == ventanaAgregarPaqueteCliente.btnAgregar) {
            // Obtiene el RUT del cliente desde la vista
            int rut = Integer.parseInt(ventanaAgregarPaqueteCliente.txtRut.getText());
            // Busca el cliente en el controlador del menú
            Cliente cliente = controladorMenu.buscarCliente(rut);
            // Si se encontró el cliente
            if (cliente != null) {
                // Crea una nueva ventana para agregar paquete
                VentanaAgregarPaquete ventanaAgregarPaquete = new VentanaAgregarPaquete();
                // Crea un controlador para la ventana de agregar paquete y le pasa el cliente encontrado
                ControladorAgregarPaquete controladorAgregarPaquete = new ControladorAgregarPaquete(ventanaAgregarPaquete, cliente);
                // Hace visible la ventana de agregar paquete
                ventanaAgregarPaquete.setVisible(true);
            } else { // Si no se encontró el cliente, muestra un mensaje de error
                JOptionPane.showMessageDialog(ventanaAgregarPaqueteCliente, "No se encontró ningún cliente con el RUT especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaAgregarPaqueteCliente.btnCancelar) { // Si el evento proviene del botón Cancelar, cierra la ventana
            ventanaAgregarPaqueteCliente.dispose();
        }
    }
}
