public class StruniLeandroAeronave {
    private String matricula;
    private String model;
    private int combustibleMax;
    private int consumoHora;
    private int velocidadCrucero;
    private String horasDeVuelo = "00:00";

    /**
     * Contructor para asignar valores
     *
     * @param matricula        Matrícula
     * @param model            Modelo de avión
     * @param combustibleMax   Conmbustible máximo que puede cargar en litros
     * @param consumoHora      Consumo de combustible por hora
     * @param velocidadCrucero Velocidad crucero en km/h
     */
    public StruniLeandroAeronave(String matricula, String model, int combustibleMax, int consumoHora, int velocidadCrucero) {
        this.matricula = matricula;
        this.model = model;
        this.combustibleMax = combustibleMax;
        this.consumoHora = consumoHora;
        this.velocidadCrucero = velocidadCrucero;
    }

    /**
     * Método para sumar horas de vuelo
     *
     * @param horas   horas para sumar
     * @param minutos minutos para sumar
     */
    public void sumarHorasVuelo(int horas, int minutos) {
        //Convertir el tiempo actual a horas y minutos
        String[] partes = horasDeVuelo.split(":");
        int horasActuales = Integer.parseInt(partes[0]);
        int minutosActuales = Integer.parseInt(partes[1]);

        //Sumar horas y minutos
        int horaActualizada = horasActuales + horas;
        int minutosActualizados = minutosActuales + minutos;

        //Ajustar minutos si mas de 60
        if (minutosActuales >= 60) {
            horaActualizada += minutosActuales / 60;
            minutosActualizados %= 60;
        }
        //Actualizar la variable horasDeVuelo
        this.horasDeVuelo = String.format("%02d:%02d", horaActualizada, minutosActualizados);
    }

    /**
     * Método para calcular el tiempo de vuelo
     *
     * @param distancia Dato de distancia
     * @return Devuelve tiempo de vuelo como double
     */
    public double calcularTiempoVuelo(double distancia) {
        return distancia / velocidadCrucero;
    }

    /**
     * Método para calcular el consumo
     *
     * @param tiempoVuelo Tiempo de vuelo
     * @return Devuelve el consumo como double
     */
    public double consumoCombustible(double tiempoVuelo) {
        return tiempoVuelo * consumoHora;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModel() {
        return model;
    }

    public String getHorasDeVuelo() {
        return horasDeVuelo;
    }

    public int getCombustibleMax() {
        return combustibleMax;
    }


    @Override
    public String toString() {
        return " " +
                "Matrícula='" + matricula + '\'' +
                ", Modelo='" + model + '\'' +
                ", Combustible Max litro=" + combustibleMax +
                ", Consumo litro/Hora=" + consumoHora +
                ", Velocidad Crucero km/h=" + velocidadCrucero +
                ", Horas De Vuelo='" + horasDeVuelo + '\'';
    }
}

