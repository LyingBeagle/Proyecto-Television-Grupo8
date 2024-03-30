import java.util.*;

public class Cliente {
    private String nombre;
    private int rut;
    private ArrayList<Paquete> listaPaquetes;
    
    public Cliente() {
        this.nombre = "N/A";
        this.rut = 0;
        this.listaPaquetes = new ArrayList<>();
    }
    
    public Cliente(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.listaPaquetes = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getRut() {
        return rut;
    }
    
    public void setRut(int rut) {
       this.rut = rut;
    }
    
    public ArrayList<Paquete> getPaquetes(){
        return listaPaquetes;
    }
    
    public void agregarPaquete(Paquete paquete) {
        listaPaquetes.add(paquete);
    }
    
    public void eliminarPaquete(Paquete paquete) {
        listaPaquetes.remove(paquete);
    }
    
    public boolean elementosEnPaquete(){
        return !listaPaquetes.isEmpty();
    }
    
    
    
}
