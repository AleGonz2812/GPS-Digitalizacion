import java.util.ArrayList;

public class GPSDataProcessor {

    /**
     * Método que valida una lista de registros GPS y devuelve solo los que son válidos.
     *
     * @param datos Lista de objetos GPSData que han sido cargados desde el archivo CSV.
     * @return Lista nueva que contiene solo los registros válidos.
     */
    public static ArrayList<GPSData> validarDatos(ArrayList<GPSData> datos) {
        ArrayList<GPSData> validos = new ArrayList<>();
        for (GPSData dato : datos) {

            boolean valido = true;

            if (dato.getLatitude() < -90 || dato.getLatitude() > 90) {
                valido = false;
            }
            if (dato.getLongitude() < -180 || dato.getLongitude() > 180) {
                valido = false;
            }
            if (dato.getSpeed() < 0 || dato.getSpeed() > 90) {
                valido = false;
            }
            if (dato.getTimestamp() == null || dato.getTimestamp().isEmpty()) {
                valido = false;
            }
            if (valido) {
                validos.add(dato);
            }

        }
        return validos;
    }
    /**
     * Metodo que filtra los registros de un autobús específico a partir de una lista de datos GPS.
     *
     * @param datos Lista completa de objetos GPSData.
     * @param busId Identificador del autobús que se desea filtrar (ejemplo: "BUS01").
     * @return Lista con solo los registros correspondientes a ese busId.
     */
    public static ArrayList<GPSData> filtrarPorBus(ArrayList<GPSData> datos, String busId) {
        ArrayList<GPSData> resultado = new ArrayList<>();

        for (GPSData dato : datos) {
            // Si el identificador del autobús coincide con el que buscamos (ignorando mayúsculas), lo añadimos
            if (dato.getBusId().equalsIgnoreCase(busId)) {
                resultado.add(dato);
            }
        }

        return resultado;
    }
}
