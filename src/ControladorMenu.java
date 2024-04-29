import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControladorMenu implements ActionListener{

    private VentanaMenu view;
    private Hashtable<Integer, Cliente> tablaClientes;
    
    
    public ControladorMenu(VentanaMenu view){
        this.view = view;
        this.tablaClientes = new Hashtable<>();
        this.view.btnAgregarCliente.addActionListener(this);
        this.view.btnBuscarCliente.addActionListener(this);
        this.view.btnMostrarClientes.addActionListener(this);
        this.view.btnSalir.addActionListener(this);
        
    }
    
    public void iniciar() throws IOException{
        view.setTitle("Menu");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == view.btnAgregarCliente){
            VentanaAgregarCliente ventanaAgregarCliente = new VentanaAgregarCliente();
            ControladorAgregarCliente controladorAgregarCliente = new ControladorAgregarCliente(ventanaAgregarCliente, this);
            ventanaAgregarCliente.setVisible(true);
        } else if(e.getSource() == view.btnBuscarCliente) {
            VentanaBuscarCliente ventanaBuscarCliente = new VentanaBuscarCliente();
            ControladorBuscarCliente controladorBuscarCliente = new ControladorBuscarCliente(ventanaBuscarCliente, this);
            ventanaBuscarCliente.setVisible(true);
        } else if(e.getSource() == view.btnMostrarClientes) {
            VentanaClientes ventanaCliente = new VentanaClientes();
            ControladorMostrarClientes controladorMostrarCliente = new ControladorMostrarClientes(tablaClientes, ventanaCliente);
            ventanaCliente.setVisible(true);
        } else if(e.getSource() == view.btnSalir) {
            System.exit(0);
        }
            
    }
    
    public Cliente agregarCliente(int rut, String nombre){
        
        if(tablaClientes.containsKey(rut)) return null;
        Cliente nuevoCliente = new Cliente(nombre,rut);
        tablaClientes.put(rut,nuevoCliente);     
        return nuevoCliente;
    }
    
    public Cliente buscarCliente(int rut){
        if(!tablaClientes.containsKey(rut)){
            JOptionPane.showMessageDialog(null, "No se encontro al cliente", "Error", JOptionPane.DEFAULT_OPTION);
            return null;
        }
        Cliente clienteBuscado = (Cliente)tablaClientes.get(rut);
        return clienteBuscado;
    }
    
}