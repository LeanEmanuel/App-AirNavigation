public class StruniLeandroCoordenadas {

    private double latitud;
    private double longitud;

    /**
     * Constructor para asignar valores
     *
     * @param latitud  valor de latitud
     * @param longitud valor de longitud
     */
    public StruniLeandroCoordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;

    }

    /**
     * Método para calcular la distancia mediante la fórmnula de Haversine, que calcula la distancia entre dos coordenadas
     *
     * @param aeropuertoDestino coordenadas del aeropuerto de destino
     * @return Devuelve la distancia en km despues de realizar los cálculos con las coordenadas de los aeropuertos.
     */
    public double calcularDistanciaHaversine(StruniLeandroCoordenadas aeropuertoDestino) {
        double distancia;
        final double RADIO_TIERRA = 6371.0;

        //Obtener coordenadas de los aeropuertos
        double lat1 = gradosRadianes(this.latitud);
        double lon1 = gradosRadianes(this.longitud);
        double lat2 = gradosRadianes(aeropuertoDestino.latitud);
        double lon2 = gradosRadianes(aeropuertoDestino.longitud);

        //Fórmula de Haversine
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distancia = RADIO_TIERRA * c;
        return distancia;
    }

    /**
     * Método para convertir coordenadas en radianes, para calcular con la fórmula de Haversine
     *
     * @param grados valor en decimal
     * @return devuelve valor en radianes
     */
    public double gradosRadianes(double grados) {
        return grados * (Math.PI / 180);
    }

    @Override
    public String toString() {
        return " " +
                "Latitud=" + latitud +
                ", Longitud=" + longitud;
    }
}




