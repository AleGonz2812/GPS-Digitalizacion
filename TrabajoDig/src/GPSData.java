public class GPSData {
        private String busId;
        private String timestamp;
        private double latitude;
        private double longitude;
        private double speed;

        /**
         * Constructor de la clase GPSData.
         * @param busId Identificador del autobús (ej: BUS01)
         * @param timestamp Fecha y hora del registro en formato ISO (ej: 2025-03-25T08:00:00)
         * @param latitude Latitud del autobús
         * @param longitude Longitud del autobús
         * @param speed Velocidad en km/h
         */
        public GPSData(String busId, String timestamp, double latitude, double longitude, double speed) {
            this.busId = busId;
            this.timestamp = timestamp;
            this.latitude = latitude;
            this.longitude = longitude;
            this.speed = speed;
        }

        // Getters (puedes agregar setters si después necesitas modificarlos)

        public String getBusId() {
            return busId;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public double getSpeed() {
            return speed;
        }

        /**
         * Metodo útil para imprimir o exportar los datos en formato CSV
         * @return Línea de texto con los campos separados por comas
         */
        @Override
        public String toString() {
            return busId + "," + timestamp + "," + latitude + "," + longitude + "," + speed;
        }
    }
