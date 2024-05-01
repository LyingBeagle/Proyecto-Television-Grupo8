import java.awt.event.*;

// Definición de la clase ControladorAgregarPaquete que implementa la interfaz ActionListener
public class ControladorAgregarPaquete implements ActionListener {
    private VentanaAgregarPaquete view; // Referencia a la ventana para agregar paquetes
    private Cliente cliente; // Referencia al cliente al que se le agregará el paquete

    // Constructor que recibe la ventana para agregar paquetes y el cliente
    public ControladorAgregarPaquete(VentanaAgregarPaquete view, Cliente cliente) {
        this.view = view; // Inicializa la referencia a la ventana
        this.cliente = cliente; // Inicializa la referencia al cliente
        
        // Agrega el controlador como oyente a los botones de la ventana
        this.view.btnConfirmar.addActionListener(this);
        this.view.btnAgregarOtro.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
    }
    
    // Método invocado cuando se realiza una acción en la ventana
    public void actionPerformed(ActionEvent e) {
        // Verifica si el evento proviene del botón Confirmar o Agregar Otro
        if (e.getSource() == view.btnConfirmar || e.getSource() == view.btnAgregarOtro) {
            // Obtiene los datos del paquete desde la vista
            String nombrePaquete = view.txtNombrePaquete.getText();
            String[] canales = view.txtCanales.getText().split(",");
            int precio = Integer.parseInt(view.txtPrecio.getText());

            // Crea un nuevo paquete con los datos obtenidos
            Paquete nuevoPaquete = new Paquete(canales, precio, nombrePaquete);
            
            // Agrega el paquete al cliente
            cliente.agregarPaquete(nuevoPaquete);

            // Si se presionó el botón Agregar Otro, limpia los campos de entrada
            if (e.getSource() == view.btnAgregarOtro) {
                view.txtNombrePaquete.setText("");
                view.txtCanales.setText("");
                view.txtPrecio.setText("");
            } else { // Si se presionó el botón Confirmar, cierra la ventana
                view.dispose();
            }
        } else if (e.getSource() == view.btnCancelar) { // Si se presionó el botón Cancelar, cierra la ventana
            view.dispose();
        }
    }
}
