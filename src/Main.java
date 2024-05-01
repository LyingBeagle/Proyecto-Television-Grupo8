import java.io.IOException;

// Clase Main que contiene el método main para iniciar la aplicación
public class Main {
    public static void main(String[] args) throws IOException {
        // Crea una instancia de la ventana de inicio de sesión
        VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
        // Crea una instancia del controlador de inicio de sesión y pasa la ventana de inicio de sesión como parámetro
        ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion(ventanaInicioSesion);
        // Hace visible la ventana de inicio de sesión
        ventanaInicioSesion.setVisible(true);
    }
}
