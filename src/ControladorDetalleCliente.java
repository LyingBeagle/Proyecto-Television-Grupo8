import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Clase ControladorDetalleCliente que implementa la interfaz ActionListener
public class ControladorDetalleCliente implements ActionListener {
    private VentanaDetalleCliente view; // Referencia a la ventana de detalle del cliente
    Cliente cliente; // Cliente a mostrar en la ventana

    // Constructor que recibe la ventana de detalle del cliente y el cliente a mostrar
    public ControladorDetalleCliente(VentanaDetalleCliente view, Cliente cliente) {
        this.view = view; // Inicializa la referencia a la ventana
        this.cliente = cliente; // Inicializa el cliente a mostrar

        // Si el cliente no es nulo, muestra la información del cliente en la ventana
        if (cliente != null) {
            // Muestra el nombre del cliente en el campo de texto correspondiente
            view.txtNombre.setText(cliente.getNombre());
            // Muestra el RUT del cliente en el campo de texto correspondiente
            view.txtRut.setText(String.valueOf(cliente.getRut()));
            // Si el cliente tiene paquetes asociados, muestra la información de los paquetes
            if (cliente.elementosEnPaquete()) {
                StringBuilder paquetesText = new StringBuilder();
                // Itera sobre los paquetes del cliente para construir el texto de los paquetes
                for (Paquete paquete : cliente.getPaquetes()) {
                    // Construye el texto del paquete con el formato deseado
                    StringBuilder paqueteText = new StringBuilder();
                    paqueteText.append("\"").append(paquete.getNombrePaquete()).append("\" - ");
                    for (int i = 0; i < paquete.getCanales().length; i++) {
                        paqueteText.append("\"").append(paquete.getCanales()[i]).append("\"");
                        if (i < paquete.getCanales().length - 1) {
                            paqueteText.append(", ");
                        }
                    }
                    paqueteText.append(" - \"Precio: ").append(paquete.getPrecio()).append("\"");
                    // Agrega el texto del paquete al texto general de los paquetes
                    paquetesText.append(paqueteText).append("\n");
                }
                // Muestra el texto de los paquetes en el área de texto correspondiente
                view.txtPaquetes.setText(paquetesText.toString());
            } else {
                // Si el cliente no tiene paquetes, muestra un mensaje indicando eso
                view.txtPaquetes.setText("El cliente no tiene paquetes.");
            }
        } else { // Si el cliente es nulo, vacía los campos de texto
            view.txtNombre.setText("");
            view.txtRut.setText("");
        }

        // Agrega el controlador como oyente al botón Atrás de la ventana
        this.view.btnAtras.addActionListener(this);
    }

    // Método invocado cuando se realiza una acción en la ventana
    public void actionPerformed(ActionEvent e) {
        // Si el evento proviene del botón Atrás, cierra la ventana de detalle del cliente
        if (e.getSource() == view.btnAtras) {
            view.dispose();
        }
    }

    // Método para mostrar la ventana de detalle del cliente
    public void mostrarVentana() {
        view.setVisible(true);
    }

    // Método para cerrar la ventana de detalle del cliente
    public void cerrarVentana() {
        view.dispose();
    }
}
