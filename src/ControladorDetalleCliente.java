import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorDetalleCliente implements ActionListener {
    private VentanaDetalleCliente view;
    Cliente cliente;
    
    public ControladorDetalleCliente(VentanaDetalleCliente view, Cliente cliente) {
        this.view = view;
        this.cliente = cliente;
        if (cliente != null) {
            view.txtNombre.setText(cliente.getNombre());
            view.txtRut.setText(String.valueOf(cliente.getRut()));
            if (cliente.elementosEnPaquete()) {
                StringBuilder paquetesText = new StringBuilder();
                for (Paquete paquete : cliente.getPaquetes()) {
                    // Construir el texto del paquete con el formato deseado
                    StringBuilder paqueteText = new StringBuilder();
                    paqueteText.append("\"").append(paquete.getNombrePaquete()).append("\" - ");
                    for (int i = 0; i < paquete.getCanales().length; i++) {
                        paqueteText.append("\"").append(paquete.getCanales()[i]).append("\"");
                        if (i < paquete.getCanales().length - 1) {
                            paqueteText.append(", ");
                        }
                    }
                    paqueteText.append(" - \"Precio: ").append(paquete.getPrecio()).append("\"");
                    
                    // Agregar el texto del paquete al texto general de los paquetes
                    paquetesText.append(paqueteText).append("\n");
                }
                view.txtPaquetes.setText(paquetesText.toString());
            } else {
                // Si el cliente no tiene paquetes, mostrar un mensaje indicando eso
                view.txtPaquetes.setText("El cliente no tiene paquetes.");
            }
        } else {
            view.txtNombre.setText("");
            view.txtRut.setText("");
        }
        
        this.view.btnAtras.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAtras) {
            view.dispose();
        }
    }

    public void mostrarVentana() {
        view.setVisible(true);
    }

    public void cerrarVentana() {
        view.dispose();
    }
}
