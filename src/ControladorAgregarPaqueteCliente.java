import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAgregarPaqueteCliente implements ActionListener {
    private VentanaAgregarPaqueteCliente ventanaAgregarPaqueteCliente;
    private ControladorMenu controladorMenu;

    public ControladorAgregarPaqueteCliente(VentanaAgregarPaqueteCliente ventanaAgregarPaqueteCliente, ControladorMenu controladorMenu) {
        this.ventanaAgregarPaqueteCliente = ventanaAgregarPaqueteCliente;
        this.controladorMenu = controladorMenu;

        this.ventanaAgregarPaqueteCliente.btnAgregar.addActionListener(this);
        this.ventanaAgregarPaqueteCliente.btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaAgregarPaqueteCliente.btnAgregar) {
            int rut = Integer.parseInt(ventanaAgregarPaqueteCliente.txtRut.getText());
            Cliente cliente = controladorMenu.buscarCliente(rut);
            if (cliente != null) {
                VentanaAgregarPaquete ventanaAgregarPaquete = new VentanaAgregarPaquete();
                ControladorAgregarPaquete controladorAgregarPaquete = new ControladorAgregarPaquete(ventanaAgregarPaquete, cliente);
                ventanaAgregarPaquete.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(ventanaAgregarPaqueteCliente, "No se encontró ningún cliente con el RUT especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaAgregarPaqueteCliente.btnCancelar) {
            ventanaAgregarPaqueteCliente.dispose();
        }
    }
}
