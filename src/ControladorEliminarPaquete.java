import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorEliminarPaquete implements ActionListener {
    private VentanaEliminarPaquete ventanaEliminarPaquete;
    private ControladorMenu controladorMenu;

    public ControladorEliminarPaquete(VentanaEliminarPaquete ventanaEliminarPaquete, ControladorMenu controladorMenu) {
        this.ventanaEliminarPaquete = ventanaEliminarPaquete;
        this.controladorMenu = controladorMenu;

        this.ventanaEliminarPaquete.btnEliminar.addActionListener(this);
        this.ventanaEliminarPaquete.btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaEliminarPaquete.btnEliminar) {
            int rut = Integer.parseInt(ventanaEliminarPaquete.txtRut.getText());
            Cliente cliente = controladorMenu.buscarCliente(rut);
            if (cliente != null) {
                String nombrePaquete = ventanaEliminarPaquete.txtNombrePaquete.getText();
                ArrayList<Paquete> paquetes = cliente.getPaquetes();
                boolean paqueteEncontrado = false;
                for (int i = 0; i < paquetes.size(); i++) {
                    Paquete paquete = paquetes.get(i);
                    if (paquete.getNombrePaquete().equalsIgnoreCase(nombrePaquete)) {
                        paquetes.remove(i);
                        JOptionPane.showMessageDialog(ventanaEliminarPaquete, "Paquete eliminado correctamente.");
                        paqueteEncontrado = true;
                        break;
                    }
                }
                if (!paqueteEncontrado) {
                    JOptionPane.showMessageDialog(ventanaEliminarPaquete, "No se encontró ningún paquete con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ventanaEliminarPaquete, "No se encontró ningún cliente con el RUT especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaEliminarPaquete.btnCancelar) {
            ventanaEliminarPaquete.dispose();
        }
    }
}
