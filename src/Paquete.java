public class Paquete {
    private String[] canales;
    private int precio;
    private int canalesEnPaquete;
    
    public Paquete(){
        this.canales = null;
        this.precio = 0;
        this.canalesEnPaquete = 0;
    }
    
    public Paquete(String[] canales){
        this.canales = canales;
    }
    
    public Paquete(int cantidadCanales) {
        canales = new String[cantidadCanales];
    }
    
    public String[] getCanales() {
        return canales;
    }
    
    public void setCanales(String[] canales) {
        this.canales = canales;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public void agregarCanal(String canalNuevo){
        if(canalesEnPaquete >= canales.length){
            
            String[] arrayAux = new String[canales.length * 2];
            System.arraycopy(canales, 0, arrayAux, 0, canales.length);
            canales = arrayAux;
        }
        canales[canalesEnPaquete++] = canalNuevo;
    }
    
}

