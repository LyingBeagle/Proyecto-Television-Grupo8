public class Persona {
    protected String nombre;
    protected int rut;
    
    // Constructor por defecto
    public Persona() {
        this.nombre = "N/A";
        this.rut = 0;
    }
    
    // Constructor con parámetros
    public Persona(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }
    
    // Métodos getter y setter para el nombre
    protected String getNombre() {
        return nombre;
    }
    
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Métodos getter y setter para el rut
    protected int getRut() {
        return rut;
    }
    
    protected void setRut(int rut) {
       this.rut = rut;
    }
}
