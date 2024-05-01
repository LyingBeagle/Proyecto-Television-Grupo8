import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// Clase ControladorBuscarCliente que implementa la interfaz ActionListener
public class ControladorBuscarCliente implements ActionListener {
    private VentanaBuscarCliente view; // Referencia a la ventana de búsqueda de cliente
    private ControladorMenu controladorMenu; // Referencia al controlador del menú

    // Constructor que recibe la ventana de búsqueda de cliente y el controlador del menú
    public ControladorBuscarCliente(VentanaBuscarCliente view, ControladorMenu controladorMenu) {
        this.view = view; // Inicializa la referencia a la ventana
        this.controladorMenu = controladorMenu; // Inicializa la referencia al controlador del menú

        // Agrega el controlador como oyente a los botones de la ventana
        this.view.btnBuscar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana
    public void actionPerformed(ActionEvent e) {
        // Verifica si el evento proviene del botón Buscar
        if (e.getSource() == view.btnBuscar) {
            try {
                // Intenta convertir el texto del campo de texto de RUT a un entero
                int rut = Integer.parseInt(view.txtRut.getText());
                // Busca al cliente en el controlador del menú
                Cliente clienteBuscado = controladorMenu.buscarCliente(rut);
                // Si se encontró el cliente
                if (clienteBuscado != null) {
                    // Muestra la ventana de detalle del cliente
                    mostrarVentanaDetalleCliente(clienteBuscado);
                } else { // Si no se encontró el cliente, muestra un mensaje de error
                    JOptionPane.showMessageDialog(view, "No se encontró ningún cliente con ese RUT.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) { // Si ocurrió un error al convertir el RUT a entero, muestra un mensaje de error
                JOptionPane.showMessageDialog(view, "Ingrese un valor válido para el RUT.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == view.btnCancelar) { // Si el evento proviene del botón Cancelar, cierra la ventana
            view.dispose();
        }
    }

    // Método para mostrar la ventana de detalle del cliente
    private void mostrarVentanaDetalleCliente(Cliente cliente) {
        // Crea una nueva ventana de detalle del cliente
        VentanaDetalleCliente ventanaDetalleCliente = new VentanaDetalleCliente();
        // Crea un controlador para la ventana de detalle del cliente y le pasa el cliente encontrado
        ControladorDetalleCliente controladorDetalleCliente = new ControladorDetalleCliente(ventanaDetalleCliente, cliente);
        // Hace visible la ventana de detalle del cliente
        ventanaDetalleCliente.setVisible(true);
    }
}
