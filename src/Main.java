import java.io.*;
import java.util.*;

public class Main {
    private static final String ARCHIVO_CLIENTES = "clientes.csv";
    private static Map<Integer, Cliente> tablaClientes = new HashMap<>();

    public static void main(String[] args) {
        cargarDatos(); // Cargar datos desde el archivo al iniciar la aplicación

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion, rut;
        String nombre;
        boolean continuar = true;

        do {
            try {
                System.out.println("\n |---------------------------------------------------|");
                System.out.println(" |                *Menu de Busqueda*                |");
                System.out.println(" |---------------------------------------------------|");
                System.out.println("  1. Agregar Cliente");
                System.out.println("  2. Buscar Cliente");
                System.out.println("  3. Eliminar Cliente /En Construccion");
                System.out.println("  4. Mostrar Todos los Clientes");
                System.out.println("  5. Agregar un paquete a un cliente /En Construccion");
                System.out.println("  0. Salir");
                System.out.print("\n Elija una opcion: ");
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
                    System.out.println("En Contruccion");
                    break;

                case 4:
                    
                    Enumeration<Cliente> enumeracion = Collections.enumeration(tablaClientes.values());

                    
                    while(enumeracion.hasMoreElements()){
                       
                        Cliente clienteActual = enumeracion.nextElement();
                        System.out.println("----------");
                        System.out.println("Nombre: " + clienteActual.getNombre());
                        System.out.println("Rut: " + clienteActual.getRut());
                        System.out.println("----------");
                    }
                    
                    break;
                
                case 5:
                    System.out.println("En Contruccion");
                    break;

                case 0:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (IOException e) {
                System.err.println("Error de entrada/salida.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Ingrese un número válido.");
            }
        } while (continuar);

        try {
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        guardarDatos();
    }

    private static void cargarDatos() {
    try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] partes = linea.split(",");
            int rut = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            Cliente cliente = new Cliente(nombre, rut);
            
            if (partes.length > 2) {
                for (int i = 2; i < partes.length; i += 3) {
                    String[] canales = partes[i].split(";"); // Canales separados por ;
                    int precio = Integer.parseInt(partes[i + 1]);
                    String nombrePaquete = partes[i + 2];
                    Paquete paquete = new Paquete(canales, precio, nombrePaquete);
                    cliente.agregarPaquete(paquete);
                }
            }
            
            tablaClientes.put(rut, cliente);
        }
    } catch (IOException e) {
        System.err.println("Error al cargar los datos desde el archivo.");
        e.printStackTrace();
    }
}


    private static void guardarDatos() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
            for (Cliente cliente : tablaClientes.values()) {
                StringBuilder sb = new StringBuilder();
                sb.append(cliente.getRut()).append(",");
                sb.append(cliente.getNombre()).append(",");
                escritor.write(sb.toString());
                escritor.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo.");
            e.printStackTrace();
        }
    }
}
