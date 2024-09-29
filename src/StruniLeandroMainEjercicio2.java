import java.util.ArrayList;
import java.util.Scanner;


public class StruniLeandroMainEjercicio2 {
    Scanner input = new Scanner(System.in);
    ArrayList<StruniLeandroAeropuerto> aeropuertos = new ArrayList<>();
    ArrayList<StruniLeandroAeronave> aeronaves = new ArrayList<>();


    public static void main(String[] args) {
        StruniLeandroMainEjercicio2 main = new StruniLeandroMainEjercicio2();
        main.inicio();

    }

    public void inicio() {
        //Datos de prueba
        aeropuertos.add(new StruniLeandroAeropuerto("Sabadell", "LELL", new StruniLeandroCoordenadas(41.521, 2.105)));
        aeropuertos.add(new StruniLeandroAeropuerto("La Cerdanya", "LECD", new StruniLeandroCoordenadas(42.387, 1.863)));
        aeropuertos.add(new StruniLeandroAeropuerto("San Luis", "LESL", new StruniLeandroCoordenadas(39.862, 4.252)));
        aeronaves.add(new StruniLeandroAeronave("EC-LKA", "Cessna Skylane", 329, 48, 250));
        aeronaves.add(new StruniLeandroAeronave("EC-ESR", "Grand Caravan", 1269, 200, 340));


        //Menú
        int opcion;
        do {
            System.out.println("-----MENU-----");
            System.out.println("[1] Añadir Aeropuerto");
            System.out.println("[2] Añadir Aeronave");
            System.out.println("[3] Tiempo de vuelo y consumo de combustible");
            System.out.println("[4] Sumar horas de vuelo");
            System.out.println("[5] Mostrar Aeropuertos");
            System.out.println("[6] Mostrar Aviones");
            System.out.println("[0] Salir");

            opcion = leerEntero("Selecciona una opción", 0, 6);

            switch (opcion) {
                case 1:
                    agregarAeropuerto();
                    break;
                case 2:
                    agregarAeronave();
                    break;
                case 3:
                    calcularCombustible();
                    break;
                case 4:
                    sumarHorasVuelo();
                    break;
                case 5:
                    mostrarDatosAeropuertos();
                    break;
                case 6:
                    mostrarDatosAviones();
                    break;
                case 0:
                    System.out.println("Terminado programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Método para agregar nuevo aeropuerto
     */
    public void agregarAeropuerto() {
        String name;
        String icao;
        double latitud;
        double longitud;

        //Solicitar nombre del aeropuerto
        //Dato de prueba
        //Alicante Elche, LEAL, 38.282 N, 0.558 O
        System.out.println("---Añadir Aeropuerto---");
        name = leerTexto("Ingrese el nombre del Aeropuerto: ");
        icao = leerTexto("Ingreso el codigo ICAO del Aeropuerto: ");
        if (!aeropuertoRegistrado(icao)) {
            if (formatoEsValido(icao, "^[A-Z]{4}")) {
                latitud = leerLatitud();
                longitud = leerLongitud();
                aeropuertos.add(new StruniLeandroAeropuerto(name, icao, new StruniLeandroCoordenadas(latitud, longitud)));
                System.out.println("Aeropuerto agregado: " + aeropuertos.get(aeropuertos.size() - 1));
            } else {
                System.out.println("El formato ICAO no es correcto, deben ser 4 letras mayúsculas.");
            }
        } else {
            System.out.println("El aeropuerto ya esta registrado");
        }
    }

    /**
     * Método para leer coordenadas
     *
     * @return Devuelve latitud
     */
    public double leerLatitud() {
        double latitud;
        latitud = leerDouble("Ingrese la latitud del Aeropuerto: ", -90, 90);
        return latitud;
    }

    /**
     * Método para leer coordenadas
     *
     * @return Devuelve longitud
     */
    public double leerLongitud() {
        double longitud;
        longitud = leerDouble("Ingrese la longitud del Aeropuerto: ", -180, 180);
        return longitud;
    }


    /**
     * Método para agregar nuevo avión
     */
    public void agregarAeronave() {
        String matricula;
        String model;
        int combustibleMax;
        int consumoHora;
        int velocidadCrucero;
        //Dato de prueba
        //EC-NNN, Cessna Skyhawk, 144, 35, 30, 215

        System.out.println("---Añadir Avión---");
        matricula = leerTexto("Ingrese la matrícula del avión:");
        //Validar si existe y formato
        if (!aeronaveRegistrada(matricula)) {
            if (formatoEsValido(matricula, "^EC-[A-Z]{3}$")) {
                model = leerTexto("Ingrese el modelo del avión: ");
                combustibleMax = leerEntero("Ingrese el volumen de combustible máximo de carga en litros: ", 0, 10000);
                consumoHora = leerEntero("Ingrese el consumo en litros/hora: ", 0, 3000);
                velocidadCrucero = leerEntero("Ingrese la velocidad crucero en km/h", 0, 700);
                aeronaves.add(new StruniLeandroAeronave(matricula, model, combustibleMax, consumoHora, velocidadCrucero));
                System.out.println("Aeronave agregada: " + aeronaves.get(aeronaves.size() - 1));
            } else {
                System.out.println("La matrícula no tiene el formato correcto, debe ser letras mayúsculas EC-XXX");
            }
        } else {
            System.out.println("El avión ya esta registrado");
        }
    }

    /**
     * Método para calcular el combustible necesario para realizar el vuelo
     */
    public void calcularCombustible() {
        int aeropuertoOrigen;
        int aeropuertoDestino;
        int aeronave;
        double distancia;
        double tiempoVuelo;
        String tiempoVueloHoras;
        double consumoTotal;
        //Mostrar aeropuertos disponibles
        System.out.println("---Aeropuertos disponibles---");
        mostrarAeropuertos();

        //Seleccionar aeropuerto de origen y guardar indice
        System.out.println("Seleccionar aeropuerto de origen");
        aeropuertoOrigen = seleccionarAeropuerto();

        //Seleccionar aeropuerto de destino y guardar indice
        System.out.println("Selecciona aeropuerto de destino");
        aeropuertoDestino = seleccionarAeropuerto();

        //Calcular distancia entre aeropuertos
        if (aeropuertoOrigen == aeropuertoDestino) {
            System.out.println("No puede escoger el mismo aeropuerto como origen y destino");
            return;
        } else {
            distancia = aeropuertos.get(aeropuertoOrigen).getCoordenadas().calcularDistanciaHaversine(aeropuertos.get(aeropuertoDestino).getCoordenadas());
        }
        System.out.println("Aeropuerto de origen: " + aeropuertos.get(aeropuertoOrigen).getName());
        System.out.println("Aeropuerto de destino: " + aeropuertos.get(aeropuertoDestino).getName());


        //Mostrar aviones disponibles
        System.out.println("---Aviones Disponibles---");
        mostrarAeronaves();
        System.out.println("Seleccionar avión");
        aeronave = seleccionarAeronave();
        System.out.println("Avión seleccionado: " + aeronaves.get(aeronave).getModel());

        //Tiempo de vuelo entre los dos aeropuertos y mostrar por pantalla
        tiempoVuelo = aeronaves.get(aeronave).calcularTiempoVuelo(distancia);
        tiempoVueloHoras = convertirTiempo(tiempoVuelo);
        System.out.println("Tiempo estimado de vuelo: ");
        System.out.println(tiempoVueloHoras + " horas");

        //Calcular consumo de combustible y mostrar por pantalla
        consumoTotal = aeronaves.get(aeronave).consumoCombustible(tiempoVuelo);
        if (consumoTotal < aeronaves.get(aeronave).getCombustibleMax()) {
            System.out.println("Consumo de combustible litros/hora: ");
            System.out.printf("%.2f%n", consumoTotal);
        } else {
            System.out.println("No hay suficiente combustible para realizar el vuelo.Debe planificar escalas.");
        }
    }

    /**
     * Método para sumar horas de vuelo a un avión mostrando lo aviones disponibles
     */
    public void sumarHorasVuelo() {
        if (aeronaves.isEmpty()) {
            System.out.println("No hay aviones registrados");
            return;
        }
        mostrarAeronaves();
        //Leer opcion indicada y llamar a métodos para añadir horas
        int indiceAvion = leerEntero("Indique el avión para añadir horas de vuelo", 0, aeronaves.size() - 1);
        System.out.println("Matrícula: " + aeronaves.get(indiceAvion).getMatricula() + " Modelo: " + aeronaves.get(indiceAvion).getModel());
        int horas;
        int minutos;
        horas = leerEntero("Ingrese las horas de vuelo: ", 0, 24);
        minutos = leerEntero("Ingrese los minutos: ", 0, 59);
        //Sumar horas de vuelo
        aeronaves.get(indiceAvion).sumarHorasVuelo(horas, minutos);
        System.out.println("Horas de vuelo actualizadas: " + aeronaves.get(indiceAvion).getHorasDeVuelo() + " en el avión " + aeronaves.get(indiceAvion).getMatricula() + "-" + aeronaves.get(indiceAvion).getModel());
    }

    /**
     * Método para mostrar los datos de los aeropuertos registrados
     */
    public void mostrarDatosAeropuertos() {
        //Mostrar datos de aeropuertos
        System.out.println("Aeropuertos");
        for (StruniLeandroAeropuerto aeropuerto : aeropuertos) {
            System.out.println(aeropuerto);
        }

    }

    /**
     * Método para mostrar datos de los aviones registrados
     */
    public void mostrarDatosAviones() {
        //Mostrar datos de aviones
        System.out.println("Aviones");
        for (StruniLeandroAeronave aeronave : aeronaves) {
            System.out.println(aeronave);
        }
    }

    /**
     * Método para mostrar aeropuertos con indice
     */
    public void mostrarAeropuertos() {
        if (aeropuertos.isEmpty()) {
            System.out.println("No hay Aeropuertos registrados");
            agregarAeropuerto();
        } else {
            for (int i = 0; i < aeropuertos.size(); i++) {
                System.out.println("[" + i + "] " + aeropuertos.get(i).getName());
            }
        }
    }

    /**
     * Método para verificar si existe el aeropuerto
     *
     * @param icao Código para realizar la búsqueda
     * @return Devuelve true si lo encuentra
     */
    public boolean aeropuertoRegistrado(String icao) {
        for (StruniLeandroAeropuerto aeropuerto : aeropuertos) {
            if (aeropuerto.getIcao().equalsIgnoreCase(icao)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para mostrar aeronaves con indice
     */
    public void mostrarAeronaves() {
        if (aeronaves.isEmpty()) {
            System.out.println("No hay aviones registrados");
            agregarAeropuerto();
        } else {
            for (int i = 0; i < aeronaves.size(); i++) {
                System.out.println("[" + i + "] " + aeronaves.get(i).getMatricula() + " - " + aeronaves.get(i).getModel());
            }
        }
    }

    /**
     * Método para verificar si el avión ya esta registrado
     *
     * @param matricula Matrícula para realizar la búsqueda
     * @return Devuelve true si lo encuentra
     */
    public boolean aeronaveRegistrada(String matricula) {
        for (StruniLeandroAeronave aeronave : aeronaves) {
            if (aeronave.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Seleccionar aeropuerto
     *
     * @return Devuelve número de opción
     */
    public int seleccionarAeropuerto() {
        return leerEntero(0, aeropuertos.size() - 1);
    }

    /**
     * Seleccionar avión
     *
     * @return Devuelve número de opción
     */
    public int seleccionarAeronave() {
        return leerEntero(0, aeronaves.size() - 1);
    }

    /**
     * Método para convertir el tiempo a formato HH:MM
     *
     * @param tiempo Valor de tiempo a convertir
     * @return Devuelve el valor de tiempo como HH:MM
     */
    public String convertirTiempo(double tiempo) {
        int horas;
        int minutos;
        horas = (int) tiempo;
        minutos = (int) ((tiempo - horas) * 60);
        return String.format("%02d:%02d", horas, minutos);
    }

    /**
     * Método para leer entero
     *
     * @param mensaje  Mensaje para el usuario
     * @param valueMin Valor mínimo
     * @param valueMax Valor máximo
     * @return Devuelve valor despúes de validar
     */
    public int leerEntero(String mensaje, int valueMin, int valueMax) {
        boolean exit = false;
        int user = 0;
        do {

            System.out.println(mensaje);
            if (input.hasNextInt()) {
                user = input.nextInt();
                input.nextLine();
                if (user >= valueMin && user <= valueMax) {
                    exit = true;
                } else {
                    System.out.println("Debes introducir valor entre " + valueMin + " y " + valueMax);
                }
            } else {
                System.out.println("Debes introducir un entero entre " + valueMin + " y " + valueMax);
                input.nextLine();
            }
        } while (!exit);
        return user;
    }

    //Método leerEntero sin mensaje
    public int leerEntero(int valueMin, int valueMax) {
        boolean exit = false;
        int user = 0;
        do {
            if (input.hasNextInt()) {
                user = input.nextInt();
                input.nextLine();
                if (user >= valueMin && user <= valueMax) {
                    exit = true;
                } else {
                    System.out.println("Debes introducir valor entre " + valueMin + " y " + valueMax);
                }
            } else {
                System.out.println("Debes introducir un entero entre " + valueMin + " y " + valueMax);
                input.nextLine();
            }
        } while (!exit);
        return user;
    }

    /**
     * Método para leer texto
     *
     * @param mensaje Mensaje para el usuario
     * @return Devuelve String
     */
    public String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.println(mensaje);
            texto = input.nextLine().trim();
        } while (texto.isBlank());
        return texto;
    }

    /**
     * Método para validar formatos
     *
     * @param datoValidarFormato Dato a validar
     * @param pattern            Expresión regular
     * @return Devuelte true si formato correcto
     */
    public boolean formatoEsValido(String datoValidarFormato, String pattern) {
        return datoValidarFormato.matches(pattern);
    }

    /**
     * Método para leer double
     *
     * @param mensaje  Mesaje para el ususario
     * @param valueMin Valor mínimo
     * @param valueMax Valor máximo
     * @return Devuelve dato double
     */
    public double leerDouble(String mensaje, double valueMin, double valueMax) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        double value = 0;
        do {
            System.out.println(mensaje);
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                input.nextLine();
                if (value >= valueMin && value <= valueMax) {
                    exit = true;
                } else {
                    System.out.println("Debes introducir valor entre " + valueMin + " y " + valueMax);
                }
            } else {
                System.out.println("Debes introducir un entero entre " + valueMin + " y " + valueMax);
                input.nextLine();
            }
        } while (!exit);
        return value;
    }
}

