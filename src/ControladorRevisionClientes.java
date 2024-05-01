import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;

// Clase ControladorRevisionClientes que implementa la interfaz ActionListener
public class ControladorRevisionClientes implements ActionListener {
    private VentanaRevisionClientes vista; // Referencia a la ventana de revisión de clientes
    private Hashtable<Integer, Cliente> tablaClientes; // Tabla hash para almacenar clientes

    // Constructor que recibe la ventana de revisión de clientes y la tabla de clientes
    public ControladorRevisionClientes(VentanaRevisionClientes vista, Hashtable<Integer, Cliente> tablaClientes) {
        this.vista = vista; // Inicializa la ventana de revisión de clientes
        this.tablaClientes = tablaClientes; // Inicializa la tabla de clientes

        // Agrega el controlador como oyente a los botones "Revisar" y "Salir"
        this.vista.btnRevisar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana de revisión de clientes
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRevisar) { // Si el evento proviene del botón "Revisar"
            try {
                int cantidadPaquetes = Integer.parseInt(vista.txtCantidad.getText()); // Obtiene la cantidad de paquetes ingresada
                mostrarClientesConMasPaquetes(cantidadPaquetes); // Llama al método para mostrar los clientes con más paquetes
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error si no se ingresa un número válido
            }
        } else if (e.getSource() == vista.btnSalir) { // Si el evento proviene del botón "Salir"
            vista.dispose(); // Cierra la ventana de revisión de clientes
        }
    }

    // Método para mostrar los clientes con más paquetes que la cantidad especificada
    private void mostrarClientesConMasPaquetes(int cantidadPaquetes) {
        StringBuilder clientesConMasPaquetes = new StringBuilder(); // Crea un StringBuilder para construir el texto de los clientes
        // Itera sobre los clientes en la tabla de clientes
        for (Cliente cliente : tablaClientes.values()) {
            // Si el cliente tiene más paquetes que la cantidad especificada
            if (cliente.getPaquetes().size() > cantidadPaquetes) {
                // Agrega el nombre y el rut del cliente al texto
                clientesConMasPaquetes.append("Nombre: ").append(cliente.getNombre()).append(", Rut: ").append(cliente.getRut()).append("\n");
            }
        }
        // Muestra un mensaje con los clientes encontrados o informa que no se encontraron clientes con más paquetes
        if (clientesConMasPaquetes.length() > 0) {
            JOptionPane.showMessageDialog(vista, "Clientes con más de " + cantidadPaquetes + " paquetes:\n" + clientesConMasPaquetes.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontraron clientes con más de " + cantidadPaquetes + " paquetes.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
