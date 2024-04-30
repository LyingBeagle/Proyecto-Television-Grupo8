import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;

public class ControladorRevisionClientes implements ActionListener {
    private VentanaRevisionClientes vista;
    private Hashtable<Integer, Cliente> tablaClientes;

    public ControladorRevisionClientes(VentanaRevisionClientes vista, Hashtable<Integer, Cliente> tablaClientes) {
        this.vista = vista;
        this.tablaClientes = tablaClientes;

        this.vista.btnRevisar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRevisar) {
            try {
                int cantidadPaquetes = Integer.parseInt(vista.txtCantidad.getText());
                mostrarClientesConMasPaquetes(cantidadPaquetes);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == vista.btnSalir) {
            vista.dispose();
        }
    }

    private void mostrarClientesConMasPaquetes(int cantidadPaquetes) {
        StringBuilder clientesConMasPaquetes = new StringBuilder();
        for (Cliente cliente : tablaClientes.values()) {
            if (cliente.getPaquetes().size() > cantidadPaquetes) {
                clientesConMasPaquetes.append("Nombre: ").append(cliente.getNombre()).append(", Rut: ").append(cliente.getRut()).append("\n");
            }
        }
        if (clientesConMasPaquetes.length() > 0) {
            JOptionPane.showMessageDialog(vista, "Clientes con más de " + cantidadPaquetes + " paquetes:\n" + clientesConMasPaquetes.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontraron clientes con más de " + cantidadPaquetes + " paquetes.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
