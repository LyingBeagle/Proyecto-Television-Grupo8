import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Clase ControladorEliminarPaquete que implementa la interfaz ActionListener
public class ControladorEliminarPaquete implements ActionListener {
    private VentanaEliminarPaquete ventanaEliminarPaquete; // Referencia a la ventana de eliminación de paquete
    private ControladorMenu controladorMenu; // Referencia al controlador del menú principal

    // Constructor que recibe la ventana de eliminación de paquete y el controlador del menú principal
    public ControladorEliminarPaquete(VentanaEliminarPaquete ventanaEliminarPaquete, ControladorMenu controladorMenu) {
        this.ventanaEliminarPaquete = ventanaEliminarPaquete; // Inicializa la referencia a la ventana
        this.controladorMenu = controladorMenu; // Inicializa la referencia al controlador del menú principal

        // Agrega el controlador como oyente a los botones de eliminar y cancelar de la ventana
        this.ventanaEliminarPaquete.btnEliminar.addActionListener(this);
        this.ventanaEliminarPaquete.btnCancelar.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana de eliminación de paquete
    public void actionPerformed(ActionEvent e) {
        // Si el evento proviene del botón Eliminar
        if (e.getSource() == ventanaEliminarPaquete.btnEliminar) {
            try {
                int rut = Integer.parseInt(ventanaEliminarPaquete.txtRut.getText()); // Obtiene el RUT del cliente
                Cliente cliente = controladorMenu.buscarCliente(rut); // Busca al cliente por su RUT
                // Si se encontró al cliente
                if (cliente != null) {
                    String nombrePaquete = ventanaEliminarPaquete.txtNombrePaquete.getText(); // Obtiene el nombre del paquete a eliminar
                    ArrayList<Paquete> paquetes = cliente.getPaquetes(); // Obtiene la lista de paquetes del cliente
                    boolean paqueteEncontrado = false; // Variable para indicar si se encontró el paquete
                    // Itera sobre la lista de paquetes del cliente
                    for (int i = 0; i < paquetes.size(); i++) {
                        Paquete paquete = paquetes.get(i); // Obtiene el paquete en la posición actual
                        // Si el nombre del paquete coincide con el nombre especificado
                        if (paquete.getNombrePaquete().equalsIgnoreCase(nombrePaquete)) {
                            paquetes.remove(i); // Elimina el paquete de la lista
                            // Muestra un mensaje indicando que el paquete ha sido eliminado correctamente
                            JOptionPane.showMessageDialog(ventanaEliminarPaquete, "Paquete eliminado correctamente.");
                            paqueteEncontrado = true; // Marca que se encontró el paquete
                            break; // Sale del bucle
                        }
                    }
                    // Si no se encontró el paquete
                    if (!paqueteEncontrado) {
                        // Muestra un mensaje de error indicando que no se encontró ningún paquete con el nombre especificado
                        JOptionPane.showMessageDialog(ventanaEliminarPaquete, "No se encontró ningún paquete con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { // Si no se encontró al cliente
                    // Muestra un mensaje de error indicando que no se encontró ningún cliente con el RUT especificado
                    JOptionPane.showMessageDialog(ventanaEliminarPaquete, "No se encontró ningún cliente con el RUT especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) { // Si ocurre un error al convertir el RUT a entero
                // Muestra un mensaje de error indicando que se debe ingresar un valor válido para el RUT
                JOptionPane.showMessageDialog(ventanaEliminarPaquete, "Ingrese un valor válido para el RUT.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaEliminarPaquete.btnCancelar) { // Si el evento proviene del botón Cancelar
            // Cierra la ventana de eliminación de paquete
            ventanaEliminarPaquete.dispose();
        }
    }
}
