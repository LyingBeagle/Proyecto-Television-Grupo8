import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ControladorMostrarClientes implements ActionListener {
    private VentanaClientes ventanaClientes;
    private Hashtable<Integer, Cliente> tablaClientes;

    public ControladorMostrarClientes(Hashtable<Integer, Cliente> tablaClientes, VentanaClientes ventanaClientes) {
        this.tablaClientes = tablaClientes;
        this.ventanaClientes = ventanaClientes;
        this.ventanaClientes.btnAtras.addActionListener(this);
        mostrarClientes();
    }

    private void mostrarClientes() {
        StringBuilder clientesText = new StringBuilder();
        for (Cliente cliente : tablaClientes.values()) {
            clientesText.append("\"").append(cliente.getNombre()).append("\" - ");
            clientesText.append(cliente.getRut()).append("\n");
        }
        ventanaClientes.txtClientes.setText(clientesText.toString());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaClientes.btnAtras) {
            ventanaClientes.dispose();
        }
    }
}
