import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Generar el archivo CSV con 60 registros simulados de GPS
        GPSDataGenerator.generarDatos("gps_data.csv");

        // Cargar los datos desde el archivo CSV
        ArrayList<GPSData> datos = GPSDataLoader.cargar("gps_data.csv");

        // Validar los datos cargados (verifica latitud, longitud, velocidad, timestamp)
        ArrayList<GPSData> datosValidos = GPSDataProcessor.validarDatos(datos);

        // Filtrar registros que pertenecen solo al BUS01
        ArrayList<GPSData> bus01 = GPSDataProcessor.filtrarPorBus(datosValidos, "BUS01");

        // Mostrar resultados en consola
        System.out.println("Registros totales: " + datos.size());
        System.out.println("Registros válidos: " + datosValidos.size());
        System.out.println("Registros del BUS01: " + bus01.size());

        // Mostrar el primer dato del BUS01 como ejemplo
        if (!bus01.isEmpty()) {
            System.out.println("Primer dato de BUS01: " + bus01.get(0));
        } else {
            System.out.println("No hay datos para BUS01.");
        }
        GPSDataReport.mostrarResumen(datos, datosValidos, bus01);
        GPSDataReport.mostrarRecorrido(bus01);
        GPSDataReport.calcularVelocidadMedia(bus01);
        GPSDataReport.guardarInforme(datos, datosValidos, bus01, "informe_bus01.txt");
        GPSDataReport.detectarParadas(bus01);

    }
}
