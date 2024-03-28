public class Cliente {
    private String nombre;
    private String rut;
    private Paquete paquetes;
    
    public Cliente() {
        this.nombre = "N/A";
        this.rut = "0";
    }
    
    public Cliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRut() {
        return rut;
    }
    
    public void setRut(String rut) {
       this.rut = rut;
    }
    
    public Paquete getPaquetes() {
        return paquetes;
    }
    
    public void setPaquetes(Paquete paquetes) {
        this.paquetes = paquetes;
    }
}
