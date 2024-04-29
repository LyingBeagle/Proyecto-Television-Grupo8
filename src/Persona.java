public class Persona {
    protected String nombre;
    protected int rut;
    
    public Persona() {
        this.nombre = "N/A";
        this.rut = 0;
    }
    
    public Persona(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }
    
    protected String getNombre() {
        return nombre;
    }
    
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    protected int getRut() {
        return rut;
    }
    
    protected void setRut(int rut) {
       this.rut = rut;
    }
}
