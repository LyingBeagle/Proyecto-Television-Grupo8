import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        List<Cliente> clientes = new ArrayList<>();
        boolean continuar = true;

        do {
            System.out.println("\n |---------------------------------------------------|");
            System.out.println(" |                *Menú de Búsqueda*                |");
            System.out.println(" |---------------------------------------------------|");
            System.out.println("  1. Agregar Cliente");
            System.out.println("  2. Buscar Cliente");
            System.out.println("  3. Eliminar Cliente");
            System.out.println("  4. Mostrar Todos los Clientes");
            System.out.println("  5. Asignar un paquete a un cliente");
            System.out.println("  0. Salir");
            System.out.print("\n Elija una opción: ");
            int opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese RUT del cliente:");
                    String rut = lector.readLine();

                    System.out.println("Ingrese nombre del cliente:");
                    String nombre = lector.readLine();

                    Cliente nuevoCliente = new Cliente("a", 324);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente agregado correctamente.");
                    break;

                case 2:
                    /*
                    System.out.println("Ingrese RUT del cliente a buscar:");
                    rut = lector.readLine();

                    boolean encontrado = false;
                    for (Cliente cliente : clientes) {
                        
                        if (cliente.getRut().equals(rut)) {
                            System.out.println("Cliente encontrado:");
                            System.out.println("Nombre: " + cliente.getNombre());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró ningún cliente con ese RUT.");
                    }
                    */
                    break;

                case 3:
                    System.out.println("Ingrese RUT del cliente a eliminar:");
                    rut = lector.readLine();
                       /*
                    boolean eliminado = false;
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getRut().equals(rut)) {
                            clientes.remove(i);-
                            eliminado = true;
                            System.out.println("Cliente eliminado correctamente.");
                            break;
                        }
                    }
                    if (!eliminado) {
                        System.out.println("No se encontró ningún cliente con ese RUT.");
                    }
                    */
                    break;

                case 4:
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        System.out.println("Clientes registrados:");
                        for (Cliente cliente : clientes) {
                            System.out.println("RUT: " + cliente.getRut() + ", Nombre: " + cliente.getNombre());
                        }
                    }
                    break;
                
                case 5:
                    /*
                    System.out.println("Ingrese RUT del cliente al que desea asignar un paquete:");
                    rut = lector.readLine();

                    Cliente clienteAsignar = null;
                    for (Cliente cliente : clientes) {
                        if (cliente.getRut().equals(rut)) {
                            clienteAsignar = cliente;
                            break;
                        }
                    }

                    if (clienteAsignar == null) {
                        System.out.println("No se encontró ningún cliente con ese RUT.");
                    } else {
                        System.out.println("Se ha asignado el paquete al cliente: " + clienteAsignar.getNombre());
                    }
                    */
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
