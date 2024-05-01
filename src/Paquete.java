public class Paquete {
    private String nombrePaquete;
    private String[] canales;
    private int precio;
    private int canalesEnPaquete;
    
    // Constructor por defecto
    public Paquete(){
        this.canales = null;
        this.precio = 0;
        this.nombrePaquete = "N/A";
        this.canalesEnPaquete = 0;
    }
    
    // Constructor con parámetros
    public Paquete(String[] canales, int precio, String nombrePaquete){
        this.canales = canales;
        this.precio = precio;
        this.nombrePaquete = nombrePaquete;
        this.canalesEnPaquete = canales.length;
    }
    
    // Constructor que inicializa el array de canales con una cantidad específica
    public Paquete(int cantidadCanales) {
        canales = new String[cantidadCanales];
    }
    
    // Métodos getter y setter para el array de canales
    public String[] getCanales() {
        return canales;
    }
    
    public void setCanales(String[] canales) {
        this.canales = canales;
    }
    
    // Métodos getter y setter para el precio
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    // Métodos getter y setter para el nombre del paquete
    public String getNombrePaquete(){
        return nombrePaquete;
    }
    
    public void setNombrePaquete(String nombrePaquete){
        this.nombrePaquete = nombrePaquete;
    }
    
    // Método para agregar un nuevo canal al paquete
    public void agregarCanal(String canalNuevo){
        if(canalesEnPaquete >= canales.length){
            String[] arrayAux = new String[canales.length * 2];
            System.arraycopy(canales, 0, arrayAux, 0, canales.length);
            canales = arrayAux;
        }
        canales[canalesEnPaquete++] = canalNuevo;
    }
}
