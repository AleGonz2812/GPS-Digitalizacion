import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Primero generamos el CSV
        GPSDataGenerator.generarDatos("gps_data.csv");

        // Luego lo leemos
        ArrayList<GPSData> datos = GPSDataLoader.cargar("gps_data.csv");

        // Verificamos si se han cargado bien
        System.out.println("Se cargaron " + datos.size() + " registros.");
        System.out.println("Primer dato: " + datos.get(0));
    }
}
