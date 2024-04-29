import java.util.*;

public class Cliente extends Persona{
    
    private ArrayList<Paquete> listaPaquetes;
    
    public Cliente() {
        super();
        this.listaPaquetes = new ArrayList<>();
    }
    
    public Cliente(String nombre, int rut) {
        super(nombre,rut);
        this.listaPaquetes = new ArrayList<>();
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
