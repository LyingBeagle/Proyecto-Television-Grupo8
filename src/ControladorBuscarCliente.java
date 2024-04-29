import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorBuscarCliente implements ActionListener {
    private VentanaBuscarCliente view;
    private ControladorMenu controladorMenu;

    public ControladorBuscarCliente(VentanaBuscarCliente view, ControladorMenu controladorMenu) {
        this.view = view;
        this.controladorMenu = controladorMenu;

        this.view.btnBuscar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnBuscar) {
            try {
                int rut = Integer.parseInt(view.txtRut.getText());
                Cliente clienteBuscado = controladorMenu.buscarCliente(rut);
                if (clienteBuscado != null) {
                    mostrarVentanaDetalleCliente(clienteBuscado);
                } else {
                    JOptionPane.showMessageDialog(view, "No se encontró ningún cliente con ese RUT.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Ingrese un valor válido para el RUT.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == view.btnCancelar) {
            view.dispose();
        }
    }

    private void mostrarVentanaDetalleCliente(Cliente cliente) {
        VentanaDetalleCliente ventanaDetalleCliente = new VentanaDetalleCliente();
        ControladorDetalleCliente controladorDetalleCliente = new ControladorDetalleCliente(ventanaDetalleCliente,cliente);
        ventanaDetalleCliente.setVisible(true);
    }
}
