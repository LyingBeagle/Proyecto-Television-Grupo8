import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ControladorEliminarCliente implements ActionListener {
    private VentanaEliminarCliente ventanaEliminarCliente;
    private ControladorMenu controladorMenu;
    private Hashtable<Integer, Cliente> tablaClientes;

    public ControladorEliminarCliente(VentanaEliminarCliente ventanaEliminarCliente, ControladorMenu controladorMenu, Hashtable<Integer, Cliente> tablaClientes) {
        this.ventanaEliminarCliente = ventanaEliminarCliente;
        this.controladorMenu = controladorMenu;
        this.tablaClientes = tablaClientes;

        this.ventanaEliminarCliente.btnEliminar.addActionListener(this);
        this.ventanaEliminarCliente.btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaEliminarCliente.btnEliminar) {
            try {
                int rut = Integer.parseInt(ventanaEliminarCliente.txtRut.getText());
                if (tablaClientes.containsKey(rut)) {
                    // Confirmar eliminación del cliente
                    int confirmacion = JOptionPane.showConfirmDialog(ventanaEliminarCliente, "¿Estás seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        controladorMenu.eliminarCliente(rut);
                        JOptionPane.showMessageDialog(ventanaEliminarCliente, "Cliente eliminado correctamente.");
                    }
                } else {
                    JOptionPane.showMessageDialog(ventanaEliminarCliente, "No se encontró un cliente con ese RUT.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventanaEliminarCliente, "Ingrese un valor válido para el RUT.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaEliminarCliente.btnCancelar) {
            ventanaEliminarCliente.dispose();
        }
    }
}
