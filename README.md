<div align="center">

# App Air Navigation

Hola! Este repo guarda uno de mis primeros ejercicios en Java.
Es una aplicacion de consola orientada a practicar modelado de objetos, validacion de datos y calculos basicos de navegacion aerea.

</div>

---

## Descripcion

Segun el codigo actual del repositorio, `App Air Navigation` permite:

- registrar aeropuertos con nombre, codigo ICAO y coordenadas;
- registrar aeronaves con matricula, modelo, combustible maximo, consumo por hora y velocidad crucero;
- calcular distancia entre dos aeropuertos usando la formula de Haversine;
- estimar tiempo de vuelo y consumo de combustible para una aeronave elegida;
- acumular horas de vuelo sobre una aeronave ya cargada;
- listar por consola los aeropuertos y aviones registrados.

El programa ya arranca con algunos datos de prueba cargados para poder usar el menu sin empezar desde cero.

---

## Objetivo del ejercicio

La idea del proyecto es practicar fundamentos, no vender humo:

<p align="center">

• modelado con clases simples (`Aeropuerto`, `Aeronave`, `Coordenadas`)  
• composicion entre objetos  
• validacion de entradas por consola  
• uso de colecciones con `ArrayList`  
• calculos numericos aplicados a un caso concreto

</p>

---

## Flujo actual de la app

<p align="center">

• ***[Inicio]*** Se crean aeropuertos y aeronaves de ejemplo al entrar en `inicio()`.  
• ***[Menu]*** El usuario elige entre alta de datos, consulta de calculos o listados.  
• ***[Calculo]*** Se seleccionan origen, destino y aeronave para estimar tiempo y combustible.  
• ***[Seguimiento]*** Tambien se pueden sumar horas de vuelo a una aeronave existente.

</p>

---

## Caracteristicas verificadas

- `ICAO` validado con regex de 4 letras mayusculas.
- `Matricula` validada con formato `EC-XXX`.
- `Latitud` acotada entre `-90` y `90`.
- `Longitud` acotada entre `-180` y `180`.
- Distancia calculada con Haversine en `StruniLeandroCoordenadas`.
- Tiempo mostrado en formato `HH:MM`.

---

## Estructura resumida

- `src/StruniLeandroMainEjercicio2.java` -> punto de entrada, menu, lectura de datos y coordinacion general.
- `src/StruniLeandroAeropuerto.java` -> entidad de aeropuerto con nombre, ICAO y coordenadas.
- `src/StruniLeandroAeronave.java` -> entidad de aeronave con consumo, velocidad y horas de vuelo.
- `src/StruniLeandroCoordenadas.java` -> calculo de distancia entre coordenadas geograficas.
- `.idea/` y `App-AirNavigation.iml` -> configuracion del proyecto para IntelliJ IDEA.

---

## Tecnologias y herramientas

<div align="center">
  <img alt="Java" src="https://skillicons.dev/icons?i=java" height="56" />
  <img alt="IntelliJ IDEA" src="https://skillicons.dev/icons?i=idea" height="56" />
  <img alt="Git" src="https://skillicons.dev/icons?i=git" height="56" />
  <img alt="GitHub" src="https://skillicons.dev/icons?i=github" height="56" />
</div>

---

<table align="center">
  <tr>
    <td align="center">
      <a href="https://github.com/LeanEmanuel">
        <img src="https://github.com/LeanEmanuel/Images/blob/main/Leandro.png" alt="LeanEmanuel" width="80">
      </a>
      <br />
      <a href="https://github.com/LeanEmanuel">
        <img src="https://img.shields.io/badge/LeanEmanuel-GitHub?style=flat&logo=github&logoColor=white&labelColor=111111&color=50e520" alt="GitHub LeanEmanuel">
      </a>
    </td>
  </tr>
</table>
