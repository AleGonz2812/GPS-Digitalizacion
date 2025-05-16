import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GPSDataLoader {
    public static ArrayList<GPSData>cargar (String archivo){
        ArrayList<GPSData> lista = new ArrayList<>();

        //Abrimos el archivo y lo leemos linea a linea
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;

            br.readLine(); //Para saltar la cabecera

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String busId = partes[0];
                    String timestamp = partes[1];
                    double latitude = Double.parseDouble(partes[2]);
                    double longitude = Double.parseDouble(partes[3]);
                    double speed = Double.parseDouble(partes[4]);

                    GPSData dato = new GPSData(busId, timestamp, latitude, longitude, speed);
                    lista.add(dato);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }


        /*  COMENTARIO EXPLICATIVO PARA EL PROYECTO (ALMACENAMIENTO EN MYSQL)

         En este proyecto los datos se almacenan temporalmente en memoria usando ArrayList<GPSData>,
         pero en un entorno real se podrían almacenar en una base de datos relacional como MySQL o PostgreSQL.

         Por ejemplo, podríamos crear una tabla llamada 'gps_data' con esta estructura en MySQL:

         CREATE TABLE gps_data (
            id INT AUTO_INCREMENT PRIMARY KEY,
            bus_id VARCHAR(10),
            timestamp DATETIME,
            latitude DOUBLE,
            longitude DOUBLE,
            speed DOUBLE
         );

         Para insertar un registro desde Java, usaríamos JDBC con una sentencia como:

         INSERT INTO gps_data (bus_id, timestamp, latitude, longitude, speed)
         VALUES (?, ?, ?, ?, ?);

         Y recorreríamos los objetos GPSData con un PreparedStatement, usando un bucle
         para insertar cada dato en la base de datos.
         */


        return lista;
    }
}
