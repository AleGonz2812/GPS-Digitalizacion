import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Generador {
    public static void generarDatos (String ArchivoCSV){
        ArrayList<GPSData> datos = new ArrayList<>();
        Random random = new Random();

        String busId = "BUS01";

        //Coordenadas Sevilla Centro
        double lat = 37.3886;
        double lon = -5.9823;

        LocalDateTime startTime = LocalDateTime.of(2025, 3, 25, 8, 0);
        double maxSpeed = 50.0;

        for (int i = 0; i < 60; i++) {
            //Genera hora actual
            String timestamp = startTime.plusMinutes(i).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            //Genera velocidad aleatoria
            double speed = random.nextDouble() * maxSpeed;

            lat += (random.nextDouble() - 0.5)* 0.001;
            lon += (random.nextDouble() - 0.5)* 0.001;

            GPSData punto = new GPSData(busId, timestamp, lat, lon, speed);
            datos.add(punto);
        }
    }
}
