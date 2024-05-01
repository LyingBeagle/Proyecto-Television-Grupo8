import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// Clase ControladorMenu que implementa la interfaz ActionListener
public class ControladorMenu implements ActionListener{

    private VentanaMenu view; // Referencia a la ventana de menú
    private Hashtable<Integer, Cliente> tablaClientes; // Tabla hash para almacenar clientes
    private final String ARCHIVO_CLIENTES = "clientes.txt"; // Nombre del archivo de clientes
    
    // Constructor que recibe la ventana de menú
    public ControladorMenu(VentanaMenu view){
        this.view = view; // Inicializa la referencia a la ventana
        this.tablaClientes = new Hashtable<>(); // Inicializa la tabla de clientes
        // Agrega el controlador como oyente a los botones de la ventana
        this.view.btnAgregarCliente.addActionListener(this);
        this.view.btnBuscarCliente.addActionListener(this);
        this.view.btnMostrarClientes.addActionListener(this);
        this.view.btnEliminarCliente.addActionListener(this);
        this.view.btnEliminarPaquete.addActionListener(this);
        this.view.btnAgregarPaquete.addActionListener(this);
        this.view.btnSalir.addActionListener(this);
        this.view.btnNpaquetes.addActionListener(this);
    }
    
    // Método para inicializar la ventana de menú
    public void iniciar() throws IOException{
        cargarDatos(); // Cargar datos desde el archivo al iniciar la aplicación
        view.setTitle("Menu");
        view.setLocationRelativeTo(null);
    }
    
    // Método invocado cuando se realiza una acción en la ventana de menú
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource(); // Obtiene el objeto que disparó el evento
        
        // Si el evento proviene del botón Agregar Cliente
        if(source == view.btnAgregarCliente){
            // Abre la ventana para agregar cliente
            VentanaAgregarCliente ventanaAgregarCliente = new VentanaAgregarCliente();
            ControladorAgregarCliente controladorAgregarCliente = new ControladorAgregarCliente(ventanaAgregarCliente, this);
            ventanaAgregarCliente.setVisible(true);
        } else if(source == view.btnBuscarCliente) { // Si el evento proviene del botón Buscar Cliente
            // Abre la ventana para buscar cliente
            VentanaBuscarCliente ventanaBuscarCliente = new VentanaBuscarCliente();
            ControladorBuscarCliente controladorBuscarCliente = new ControladorBuscarCliente(ventanaBuscarCliente, this);
            ventanaBuscarCliente.setVisible(true);
        } else if(source == view.btnMostrarClientes) { // Si el evento proviene del botón Mostrar Clientes
            // Abre la ventana para mostrar clientes
            VentanaClientes ventanaCliente = new VentanaClientes();
            ControladorMostrarClientes controladorMostrarCliente = new ControladorMostrarClientes(tablaClientes, ventanaCliente);
            ventanaCliente.setVisible(true);
        } else if(source == view.btnEliminarCliente) { // Si el evento proviene del botón Eliminar Cliente
            // Abre la ventana para eliminar cliente
            VentanaEliminarCliente ventanaEliminarClientes = new VentanaEliminarCliente();
            ControladorEliminarCliente controladorEliminarCliente = new ControladorEliminarCliente(ventanaEliminarClientes,this,tablaClientes);
            ventanaEliminarClientes.setVisible(true);
        } else if(source == view.btnEliminarPaquete) { // Si el evento proviene del botón Eliminar Paquete
            // Abre la ventana para eliminar paquete
            VentanaEliminarPaquete ventanaEliminarPaquete = new VentanaEliminarPaquete();
            ControladorEliminarPaquete controladorEliminarPaquete = new ControladorEliminarPaquete(ventanaEliminarPaquete,this);
            ventanaEliminarPaquete.setVisible(true);
        } else if(source == view.btnAgregarPaquete) { // Si el evento proviene del botón Agregar Paquete
            // Abre la ventana para agregar paquete
            VentanaAgregarPaqueteCliente ventanaAgregarPaqueteCliente = new VentanaAgregarPaqueteCliente();
            ControladorAgregarPaqueteCliente controladorAgregarPaquete = new ControladorAgregarPaqueteCliente(ventanaAgregarPaqueteCliente,this);
            ventanaAgregarPaqueteCliente.setVisible(true);
        } else if(source == view.btnNpaquetes) { // Si el evento proviene del botón Número de Paquetes
            // Abre la ventana para revisar clientes
            VentanaRevisionClientes ventanaRevisionClientes = new VentanaRevisionClientes();
            ControladorRevisionClientes controladorRevisionClientes = new ControladorRevisionClientes(ventanaRevisionClientes,tablaClientes);
            ventanaRevisionClientes.setVisible(true);
        } else if(source == view.btnSalir) { // Si el evento proviene del botón Salir
            guardarClientesEnArchivo(); // Guarda los clientes en el archivo
            System.exit(0); // Cierra la aplicación
        }
    }
    
    // Método para agregar un cliente a la tabla de clientes
    public Cliente agregarCliente(int rut, String nombre){
        if(tablaClientes.containsKey(rut)) return null; // Si el cliente ya existe, devuelve null
        Cliente nuevoCliente = new Cliente(nombre,rut); // Crea un nuevo cliente
        tablaClientes.put(rut,nuevoCliente); // Agrega el cliente a la tabla
        return nuevoCliente; // Retorna el cliente agregado
    }
    
    // Método para buscar un cliente en la tabla de clientes
    public Cliente buscarCliente(int rut){
        if(!tablaClientes.containsKey(rut)){ // Si el cliente no existe en la tabla
            JOptionPane.showMessageDialog(null, "No se encontro al cliente", "Error", JOptionPane.DEFAULT_OPTION);
            return null; // Retorna null
        }
        return tablaClientes.get(rut); // Retorna el cliente encontrado
    }
    
    // Método para eliminar un cliente de la tabla de clientes
    public void eliminarCliente(int rut){
        tablaClientes.remove(rut); // Elimina el cliente de la tabla
    }
    
    // Método para cargar datos desde el archivo de clientes
    private void cargarDatos() {
        try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    continue;
                }
                String nombreCliente = partes[0].trim();
                int rutCliente = Integer.parseInt(partes[1].trim());
                Cliente cliente = new Cliente(nombreCliente, rutCliente);
                tablaClientes.put(rutCliente, cliente);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos desde el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al cargar los datos desde el archivo.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error de formato en el archivo.");
        }
    }

    // Método para guardar los clientes en el archivo de clientes
    private void guardarClientesEnArchivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
            for (Cliente cliente : tablaClientes.values()) {
                escritor.write(cliente.getNombre() + "," + cliente.getRut() + ",\n");
            }
            JOptionPane.showMessageDialog(view, "Clientes guardados en el archivo " + ARCHIVO_CLIENTES, "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error al guardar los clientes en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al guardar los clientes en el archivo.");
        }
    }
}
