import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        VentanaMenu vistaMenu = new VentanaMenu();
        
        ControladorMenu controladorMenu = new ControladorMenu(vistaMenu);
        controladorMenu.iniciar();
        vistaMenu.setVisible(true);
    }
}