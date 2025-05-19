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
}
