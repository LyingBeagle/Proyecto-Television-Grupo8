import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorInicioSesion implements ActionListener {
    private VentanaInicioSesion vista;
    private Trabajador trabajador;

    public ControladorInicioSesion(VentanaInicioSesion vista) {
        this.vista = vista;
        this.trabajador = new Trabajador();
        this.vista.btnEntrar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnEntrar) {
            trabajador.setNombre(vista.txtNombre.getText());
            trabajador.setRut(Integer.parseInt(vista.txtRut.getText()));
            
            if (validarCredenciales(trabajador.getNombre(), trabajador.getRut())) {
                try {
                    abrirMenu();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == vista.btnSalir) {
            vista.dispose();
        }
    }

    private boolean validarCredenciales(String nombre, int rut) {
        return !nombre.isEmpty() && rut > 0;
    }

    private void abrirMenu() throws IOException {
        vista.dispose();

        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(ventanaMenu);
        controladorMenu.iniciar();
        ventanaMenu.setVisible(true);
    }
}
