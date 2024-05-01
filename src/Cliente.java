import java.util.*;

// Definición de la clase Cliente que hereda de la clase Persona
public class Cliente extends Persona {
    
    // ArrayList para almacenar los paquetes del cliente
    private ArrayList<Paquete> listaPaquetes;
    
    // Constructor sin argumentos que inicializa los campos y la lista de paquetes
    public Cliente() {
        super(); // Llama al constructor de la clase base Persona
        this.listaPaquetes = new ArrayList<>(); // Inicializa la lista de paquetes
    }
    
    // Constructor que recibe nombre y rut del cliente, inicializa los campos y la lista de paquetes
    public Cliente(String nombre, int rut) {
        super(nombre, rut); // Llama al constructor de la clase base Persona
        this.listaPaquetes = new ArrayList<>(); // Inicializa la lista de paquetes
    }
     
    // Método para obtener la lista de paquetes del cliente
    public ArrayList<Paquete> getPaquetes() {
        return listaPaquetes;
    }
    
    // Método para agregar un paquete a la lista de paquetes del cliente
    public void agregarPaquete(Paquete paquete) {
        listaPaquetes.add(paquete);
    }
    
    // Método para eliminar un paquete de la lista de paquetes del cliente
    public void eliminarPaquete(Paquete paquete) {
        listaPaquetes.remove(paquete);
    }
    
    // Método para verificar si el cliente tiene elementos en su lista de paquetes
    public boolean elementosEnPaquete() {
        return !listaPaquetes.isEmpty();
    }
    
}
