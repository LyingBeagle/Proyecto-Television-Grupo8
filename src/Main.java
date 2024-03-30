import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Hashtable tablaClientes = new Hashtable();
        
        int rut, opcion;
        String nombre;
        
        Cliente cliente1 = new Cliente("Manolo",32);
        Cliente cliente2 = new Cliente("Teleforo",51);
        Cliente cliente3 = new Cliente("Mastonanto",24);
        
        String[] canalRecien = {"TVN","MEGA","CHILEVISION"};
        
        Paquete paquete1 = new Paquete(canalRecien,10000,"Noticieros");
        
        canalRecien = new String[]{"FOX","FOX NEWS"};
        
        Paquete paquete2 = new Paquete(canalRecien,15000,"FOXs");
        
        canalRecien = new String[]{"SONY","NE","THQ"};
        
        Paquete paquete3 = new Paquete(canalRecien,20000,"Peliculas clasicas");
        
        cliente1.agregarPaquete(paquete3);
        cliente2.agregarPaquete(paquete2);
        cliente2.agregarPaquete(paquete1);
        cliente3.agregarPaquete(paquete1);
        cliente3.agregarPaquete(paquete2);
        cliente3.agregarPaquete(paquete3);
        
        tablaClientes.put(32, cliente1);
        tablaClientes.put(51, cliente2);
        tablaClientes.put(24, cliente3);
        
        boolean continuar = true;

        do {
            System.out.println("\n |---------------------------------------------------|");
            System.out.println(" |                *Menú de Búsqueda*                |");
            System.out.println(" |---------------------------------------------------|");
            System.out.println("  1. Agregar Cliente");
            System.out.println("  2. Buscar Cliente");
            System.out.println("  3. Eliminar Cliente");
            System.out.println("  4. Mostrar Todos los Clientes");
            System.out.println("  5. Agregar un paquete a un cliente");
            System.out.println("  0. Salir");
            System.out.print("\n Elija una opción: ");
            opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    
                    System.out.println("Ingrese RUT del cliente:");
                    rut = Integer.parseInt(lector.readLine());
                            
                    if(tablaClientes.containsKey(rut)){
                        System.out.println("Ya existe un cliente con ese rut");
                        break;
                    }
                    
                    System.out.println("Ingrese nombre del cliente:");
                    nombre = lector.readLine();

                    Cliente nuevoCliente = new Cliente(nombre,rut);
                    tablaClientes.put(rut, nuevoCliente);
                    
                    System.out.println("Quiere añadir paquetes al cliente (s/n)");
                    String opc = lector.readLine();
                    
                    if(opc.contentEquals("s")){
                        
                        System.out.println("Ingrese la cantidad de Paquetes que quiere ingresar: ");
                        int cantPaquetes = Integer.parseInt(lector.readLine());
                        
                        for(int i = 0; i < cantPaquetes; i++){

                            System.out.println("Paquete " + (i+1));
                            System.out.println("Ingrese la cantidad de canales que quiere ingresar: ");
                            int cantCanales = Integer.parseInt(lector.readLine());

                            System.out.println("Ingrese canales");

                            String[] canales = new String[cantCanales];

                            for(int j = 0; j < cantCanales; j++){
                                canales[j] = lector.readLine();
                            }

                            System.out.println("Ingrese precio de paquete");
                            int precioPaquete = Integer.parseInt(lector.readLine());

                            System.out.println("Ingrese nombre de paquete");
                            String nombrePaquete = lector.readLine();

                            Paquete nuevoPaquete = new Paquete(canales,precioPaquete,nombrePaquete);

                            nuevoCliente.agregarPaquete(nuevoPaquete);
                        }
                    }
                            
                    System.out.println("Cliente agregado correctamente.");
                    break;

                case 2:
                    System.out.println("Ingrese RUT del cliente a buscar:");
                    rut = Integer.parseInt(lector.readLine());

                    if(!tablaClientes.containsKey(rut)){
                        System.out.println("No se encontro al cliente");
                        break;
                    }
                    
                    Cliente clienteBuscado = (Cliente)tablaClientes.get(rut);
                    
                    System.out.println("----------Cliente---------");
                    System.out.println("Nombre: " + clienteBuscado.getNombre());
                    System.out.println("Rut: " + clienteBuscado.getRut());
                    System.out.println();
                    
                    if(clienteBuscado.elementosEnPaquete()){
                        System.out.println("--Paquetes--");
                        
                        ArrayList<Paquete> listaPaquetesCliente = clienteBuscado.getPaquetes();
                        
                        for(int i = 0; i < listaPaquetesCliente.size(); i++){
                            Paquete paqueteActual = listaPaquetesCliente.get(i);
                           
                            System.out.println("Nombre: " + paqueteActual.getNombrePaquete());
                            System.out.println("Precio: " + paqueteActual.getPrecio() + "$");
                            System.out.println("Canales");
                            System.out.println(Arrays.toString(paqueteActual.getCanales()));
                        }
                    }
                    else{
                        System.out.println("--Sin paquetes--");
                    }
  
                    break;

                case 3:
                   
                    break;

                case 4:
                    
                    break;
                
                case 5:
                    
                    break;

                case 0:
                        continuar = false;
                        break;

                default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                    }
                 } while (continuar);

                        lector.close();
                    }
    
}
