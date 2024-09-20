public class StruniLeandroAeropuerto {

    private String name;
    private String icao;
    private StruniLeandroCoordenadas coordenadas;

    /**
     * Contructor para asignar valores
     *
     * @param name        Nombre del aeropuerto
     * @param icao        Código ICAO del aeropuerto
     * @param coordenadas Coordenadas ubicación
     */
    public StruniLeandroAeropuerto(String name, String icao, StruniLeandroCoordenadas coordenadas) {
        this.name = name;
        this.icao = icao;
        this.coordenadas = coordenadas;
    }

    public String getName() {
        return name;
    }

    public String getIcao() {
        return icao;
    }

    public StruniLeandroCoordenadas getCoordenadas() {
        return coordenadas;
    }

    @Override
    public String toString() {
        return "Aeropuerto:" +
                "Nombre='" + name + '\'' +
                ", Código ICAO='" + icao + '\'' +
                ", Coordenadas=" + coordenadas;
    }
}

