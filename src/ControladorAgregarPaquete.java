import java.awt.event.*;

public class ControladorAgregarPaquete implements ActionListener {
    private VentanaAgregarPaquete view;
    private Cliente cliente;

    public ControladorAgregarPaquete(VentanaAgregarPaquete view, Cliente cliente) {
        this.view = view;
        this.cliente = cliente;
        
        this.view.btnConfirmar.addActionListener(this);
        this.view.btnAgregarOtro.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnConfirmar || e.getSource() == view.btnAgregarOtro) {

            String nombrePaquete = view.txtNombrePaquete.getText();
            String[] canales = view.txtCanales.getText().split(",");
            int precio = Integer.parseInt(view.txtPrecio.getText());

            Paquete nuevoPaquete = new Paquete(canales, precio, nombrePaquete);
            cliente.agregarPaquete(nuevoPaquete);

            if (e.getSource() == view.btnAgregarOtro) {
                view.txtNombrePaquete.setText("");
                view.txtCanales.setText("");
                view.txtPrecio.setText("");
            } else {
                view.dispose();
            }
        } else if (e.getSource() == view.btnCancelar) {
            view.dispose();
        }
    }
}
