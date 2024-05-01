import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

// Clase ControladorEliminarCliente que implementa la interfaz ActionListener
public class ControladorEliminarCliente implements ActionListener {
    private VentanaEliminarCliente ventanaEliminarCliente; // Referencia a la ventana de eliminación de cliente
    private ControladorMenu controladorMenu; // Referencia al controlador del menú principal
    private Hashtable<Integer, Cliente> tablaClientes; // Tabla hash que almacena los clientes

    // Constructor que recibe la ventana de eliminación de cliente, el controlador del menú principal y la tabla de clientes
    public ControladorEliminarCliente(VentanaEliminarCliente ventanaEliminarCliente, ControladorMenu controladorMenu, Hashtable<Integer, Cliente> tablaClientes) {
        this.ventanaEliminarCliente = ventanaEliminarCliente; // Inicializa la referencia a la ventana
        this.controladorMenu = controladorMenu; // Inicializa la referencia al controlador del menú principal
        this.tablaClientes = tablaClientes; // Inicializa la tabla de clientes

        // Agrega el controlador como oyente a los botones de eliminar y cancelar de la ventana
        this.ventanaEliminarCliente.btnEliminar.addActionListener(this);
        this.ventanaEliminarCliente.btnCancelar.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana de eliminación de cliente
    public void actionPerformed(ActionEvent e) {
        // Si el evento proviene del botón Eliminar
        if (e.getSource() == ventanaEliminarCliente.btnEliminar) {
            try {
                int rut = Integer.parseInt(ventanaEliminarCliente.txtRut.getText()); // Obtiene el RUT del cliente a eliminar
                // Si la tabla de clientes contiene al cliente con el RUT especificado
                if (tablaClientes.containsKey(rut)) {
                    // Pregunta al usuario si está seguro de eliminar al cliente
                    int confirmacion = JOptionPane.showConfirmDialog(ventanaEliminarCliente, "¿Estás seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    // Si el usuario confirma la eliminación del cliente
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        // Llama al método del controlador del menú principal para eliminar al cliente
                        controladorMenu.eliminarCliente(rut);
                        // Muestra un mensaje indicando que el cliente ha sido eliminado correctamente
                        JOptionPane.showMessageDialog(ventanaEliminarCliente, "Cliente eliminado correctamente.");
                    }
                } else { // Si la tabla de clientes no contiene al cliente con el RUT especificado
                    // Muestra un mensaje de error indicando que no se encontró un cliente con ese RUT
                    JOptionPane.showMessageDialog(ventanaEliminarCliente, "No se encontró un cliente con ese RUT.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) { // Si ocurre un error al convertir el RUT a entero
                // Muestra un mensaje de error indicando que se debe ingresar un valor válido para el RUT
                JOptionPane.showMessageDialog(ventanaEliminarCliente, "Ingrese un valor válido para el RUT.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaEliminarCliente.btnCancelar) { // Si el evento proviene del botón Cancelar
            // Cierra la ventana de eliminación de cliente
            ventanaEliminarCliente.dispose();
        }
    }
}
