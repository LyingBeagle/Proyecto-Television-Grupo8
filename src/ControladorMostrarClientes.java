import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

// Clase ControladorMostrarClientes que implementa la interfaz ActionListener
public class ControladorMostrarClientes implements ActionListener {
    private VentanaClientes ventanaClientes; // Referencia a la ventana de clientes
    private Hashtable<Integer, Cliente> tablaClientes; // Tabla hash para almacenar clientes

    // Constructor que recibe la tabla de clientes y la ventana de clientes
    public ControladorMostrarClientes(Hashtable<Integer, Cliente> tablaClientes, VentanaClientes ventanaClientes) {
        this.tablaClientes = tablaClientes; // Inicializa la tabla de clientes
        this.ventanaClientes = ventanaClientes; // Inicializa la ventana de clientes
        this.ventanaClientes.btnAtras.addActionListener(this); // Agrega el controlador como oyente al botón "Atrás"
        mostrarClientes(); // Muestra los clientes en la ventana al iniciar
    }

    // Método para mostrar los clientes en la ventana de clientes
    private void mostrarClientes() {
        StringBuilder clientesText = new StringBuilder(); // Crea un StringBuilder para construir el texto de los clientes
        // Itera sobre los clientes en la tabla de clientes
        for (Cliente cliente : tablaClientes.values()) {
            clientesText.append("\"").append(cliente.getNombre()).append("\" - "); // Agrega el nombre del cliente al texto
            clientesText.append(cliente.getRut()).append("\n"); // Agrega el rut del cliente al texto
        }
        ventanaClientes.txtClientes.setText(clientesText.toString()); // Establece el texto en el área de texto de la ventana de clientes
    }

    // Método invocado cuando se realiza una acción en la ventana de clientes
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaClientes.btnAtras) { // Si el evento proviene del botón "Atrás"
            ventanaClientes.dispose(); // Cierra la ventana de clientes
        }
    }
}
