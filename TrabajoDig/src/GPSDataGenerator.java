import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GPSDataGenerator {

    /**
     * Genera un archivo CSV con datos GPS para múltiples autobuses.
     * @param archivoCSV Nombre del archivo donde se guardarán los datos.
     */
    public static void generarDatos(String archivoCSV) {
        String[] buses = {"BUS01", "BUS02", "BUS03"};
        int registrosPorBus = 60;

        double baseLat = 37.389;
        double baseLon = -5.984;
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(archivoCSV)) {
            writer.write("busId,timestamp,latitude,longitude,speed\n");

            for (String busId : buses) {
                for (int i = 0; i < registrosPorBus; i++) {
                    String timestamp = String.format("2025-03-25T08:%02d:00", i % 60);
                    double lat = baseLat + rand.nextDouble() * 0.01;
                    double lon = baseLon + rand.nextDouble() * 0.01;
                    double speed = rand.nextDouble() * 60;

                    writer.write(busId + "," + timestamp + "," + lat + "," + lon + "," + speed + "\n");
                }
            }

            System.out.println("Datos generados correctamente para " + buses.length + " autobuses.");
        } catch (IOException e) {
            System.out.println("Error al generar datos: " + e.getMessage());
        }
    }
}
