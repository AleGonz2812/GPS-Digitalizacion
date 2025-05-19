import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Generar datos GPS simulados
        GPSDataGenerator.generarDatos("gps_data.csv");

        // Cargar los datos desde el CSV
        ArrayList<GPSData> datos = GPSDataLoader.cargar("gps_data.csv");

        // Validar los datos (lat, lon, velocidad, timestamp)
        ArrayList<GPSData> datosValidos = GPSDataProcessor.validarDatos(datos);

        // IDs de los autobuses simulados
        String[] buses = {"BUS01", "BUS02", "BUS03"};

        // Procesar y exportar datos de cada autobús
        for (String busId : buses) {
            System.out.println("\n==============================");
            System.out.println("    Resultados para " + busId);
            System.out.println("==============================");

            ArrayList<GPSData> busFiltrado = GPSDataProcessor.filtrarPorBus(datosValidos, busId);

            GPSDataReport.mostrarResumen(datos, datosValidos, busFiltrado);
            GPSDataReport.mostrarRecorrido(busFiltrado);
            GPSDataReport.calcularVelocidadMedia(busFiltrado);
            GPSDataReport.detectarParadas(busFiltrado);

            String nombreBase = busId.toLowerCase();
            GPSDataReport.guardarInforme(datos, datosValidos, busFiltrado, nombreBase + "_informe.txt");
            GPSDataReport.exportarAJSON(busFiltrado, nombreBase + ".json");
        }
    }
}
