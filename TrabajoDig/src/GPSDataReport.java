import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;



public class GPSDataReport {
    /**
     * Muestra un resumen general: registros totales, válidos y del autobús seleccionado.
     * @param todos Lista original de registros cargados desde CSV.
     * @param validos Lista de registros válidos tras el filtrado.
     * @param filtrados Lista de registros filtrados por autobús.
     */
    public static void mostrarResumen(ArrayList<GPSData> todos, ArrayList<GPSData> validos, ArrayList<GPSData> filtrados) {
        System.out.println("----- RESUMEN GENERAL -----");
        System.out.println("Registros totales en el archivo: " + todos.size());
        System.out.println("Registros válidos: " + validos.size());
        System.out.println("Registros del autobús seleccionado: " + filtrados.size());
    }
    public static void mostrarRecorrido(ArrayList<GPSData> registros) {
        System.out.println("\n----- RECORRIDO DEL AUTOBÚS -----");
        for (GPSData dato : registros) {
            System.out.println(dato.getTimestamp() + " - (" + dato.getLatitude() + ", " + dato.getLongitude() + ")");
        }
    }

    public static void calcularVelocidadMedia(ArrayList<GPSData> registros) {
        if (registros.isEmpty()) {
            System.out.println("\nNo hay datos para calcular la velocidad media.");
            return;
        }

        double suma = 0;
        for (GPSData dato : registros) {
            suma += dato.getSpeed();
        }

        double media = suma / registros.size();
        System.out.printf("\nVelocidad media del autobús: %.2f km/h\n", media);
    }
    /**
     * Guarda un informe resumen en un archivo de texto.
     * @param todos Lista total de registros cargados.
     * @param validos Lista de registros válidos.
     * @param filtrados Lista de registros del bus filtrado.
     * @param archivoNombre Nombre del archivo donde se guardará el informe.
     */
    public static void guardarInforme(ArrayList<GPSData> todos, ArrayList<GPSData> validos,
                                      ArrayList<GPSData> filtrados, String archivoNombre) {

        try (FileWriter writer = new FileWriter(archivoNombre)) {
            writer.write("----- INFORME DE DATOS GPS -----\n");
            writer.write("Total de registros: " + todos.size() + "\n");
            writer.write("Registros válidos: " + validos.size() + "\n");
            writer.write("Registros del autobús: " + filtrados.size() + "\n");

            double sumaVel = 0;
            for (GPSData dato : filtrados) {
                sumaVel += dato.getSpeed();
            }

            double media = filtrados.isEmpty() ? 0 : sumaVel / filtrados.size();
            writer.write(String.format("Velocidad media: %.2f km/h\n\n", media));
            writer.write("Recorrido (timestamp, latitud, longitud):\n");

            for (GPSData dato : filtrados) {
                writer.write(dato.getTimestamp() + " - (" + dato.getLatitude() + ", " + dato.getLongitude() + ")\n");
            }

            System.out.println("\nInforme guardado en: " + archivoNombre);

        } catch (IOException e) {
            System.out.println("Error al guardar el informe: " + e.getMessage());
        }
    }
    /**
     * Detecta y muestra los momentos en los que el autobús estuvo parado.
     * Considera una parada si la velocidad es menor o igual a 0.5 km/h.
     * @param registros Lista de datos GPS de un autobús.
     */
    public static void detectarParadas(ArrayList<GPSData> registros) {
        System.out.println("\n----- PARADAS DETECTADAS -----");
        boolean algunaParada = false;

        for (GPSData dato : registros) {
            if (dato.getSpeed() <= 0.5) {
                System.out.printf("%s - Parado en (%.5f, %.5f)%n",
                        dato.getTimestamp(), dato.getLatitude(), dato.getLongitude());
                algunaParada = true;
            }
        }

        if (!algunaParada) {
            System.out.println("No se detectaron paradas.");
        }
    }

    /**
     * Exporta una lista de datos GPS a un archivo JSON sin usar librerías externas.
     * @param registros Lista de objetos GPSData.
     * @param archivoNombre Nombre del archivo de salida (ej: "bus01.json").
     */
    public static void exportarAJSON(ArrayList<GPSData> registros, String archivoNombre) {
        try (FileWriter writer = new FileWriter(archivoNombre)) {
            writer.write("[\n");

            for (int i = 0; i < registros.size(); i++) {
                GPSData d = registros.get(i);

                writer.write("  {\n");
                writer.write("    \"busId\": \"" + d.getBusId() + "\",\n");
                writer.write("    \"timestamp\": \"" + d.getTimestamp() + "\",\n");
                writer.write("    \"latitude\": " + d.getLatitude() + ",\n");
                writer.write("    \"longitude\": " + d.getLongitude() + ",\n");
                writer.write("    \"speed\": " + d.getSpeed() + "\n");
                writer.write("  }");

                if (i < registros.size() - 1) {
                    writer.write(","); // Coma entre objetos
                }
                writer.write("\n");
            }

            writer.write("]\n");

            System.out.println("Archivo JSON generado correctamente: " + archivoNombre);

        } catch (IOException e) {
            System.out.println("Error al guardar el JSON: " + e.getMessage());
        }
    }

}
