public class Paquete {
    
    private String[] canales;
    
    public Paquete(){
        canales = null;
    }
    
    public Paquete(int cantidadCanales){
        canales = new String[cantidadCanales];
    }
    
    public String[] getCanales(){
        return canales;
    }
    
    public void setCanales(String[] canales){
        this.canales = canales;
    }
    
    
}
