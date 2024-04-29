import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ControladorAgregarCliente implements ActionListener {
    private VentanaAgregarCliente vista;
    private ControladorMenu controladorMenu;
    private Cliente cliente;
    private int rut = 0;
    
    public ControladorAgregarCliente(VentanaAgregarCliente vista, ControladorMenu controladorMenu) {
        this.vista = vista;
        this.controladorMenu = controladorMenu;

        this.vista.btnAnadirPaquetes.addActionListener(this);
        this.vista.btnConfirmar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        
        if (source == vista.btnConfirmar || source == vista.btnAnadirPaquetes) {
            try{
            rut = vista.obtenerRut();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(vista, "Ingrese un valor válido para el RUT", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            String nombre = vista.obtenerNombre();

            cliente = controladorMenu.agregarCliente(rut, nombre);
            
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese rut", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (source == vista.btnAnadirPaquetes) {
                System.out.println("Entro");
                VentanaAgregarPaquete ventanaAgregarPaquete = new VentanaAgregarPaquete();
                ControladorAgregarPaquete controladorAgregarPaquete = new ControladorAgregarPaquete(ventanaAgregarPaquete, cliente);
                ventanaAgregarPaquete.setVisible(true);
            }
            vista.dispose();
        } else if (source == vista.btnCancelar) {
            vista.dispose();
        }
    }
}
