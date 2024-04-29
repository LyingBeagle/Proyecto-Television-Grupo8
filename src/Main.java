import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
        ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion(ventanaInicioSesion);
        ventanaInicioSesion.setVisible(true);
    }
}