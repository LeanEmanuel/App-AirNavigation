<div align="center">

## ✈ App Air Navigation ✈

¡Hola! Este repo guarda uno de mis primeros ejercicios en Java.  
Es una aplicación de consola orientada a practicar modelado de objetos, validación de datos y cálculos básicos de navegación aérea.

</div>

---

## Descripción

`App Air Navigation` permite:

- registrar aeropuertos con nombre, código ICAO y coordenadas;
- registrar aeronaves con matrícula, modelo, combustible máximo, consumo por hora y velocidad de crucero;
- calcular la distancia entre dos aeropuertos usando la fórmula de Haversine;
- estimar el tiempo de vuelo y el consumo de combustible para una aeronave elegida;
- acumular horas de vuelo sobre una aeronave ya cargada;
- listar por consola los aeropuertos y aviones registrados.

El programa ya arranca con algunos datos de prueba cargados para poder usar el menú sin empezar desde cero.

---

## Objetivo del ejercicio

La idea del proyecto es practicar fundamentos:

<p align="center">

• modelado con clases simples (`Aeropuerto`, `Aeronave`, `Coordenadas`)  
• composición entre objetos  
• validación de entradas por consola  
• uso de colecciones con `ArrayList`  
• cálculos numéricos aplicados a un caso concreto

</p>

---

## Flujo actual de la app

<p align="center">

• ***[Inicio]*** Se crean aeropuertos y aeronaves de ejemplo al entrar en `inicio()`.  
• ***[Menú]*** El usuario elige entre alta de datos, consulta de cálculos o listados.  
• ***[Cálculo]*** Se seleccionan origen, destino y aeronave para estimar tiempo y combustible.  
• ***[Seguimiento]*** También se pueden sumar horas de vuelo a una aeronave existente.

</p>

---

## Características verificadas

- `ICAO` validado con regex de 4 letras mayúsculas.
- `Matrícula` validada con formato `EC-XXX`.
- `Latitud` acotada entre `-90` y `90`.
- `Longitud` acotada entre `-180` y `180`.
- Distancia calculada con Haversine.
- Tiempo mostrado en formato `HH:MM`.

---

## Estructura resumida

- `src/StruniLeandroMainEjercicio2.java` -> punto de entrada, menú, lectura de datos y coordinación general.
- `src/StruniLeandroAeropuerto.java` -> entidad de aeropuerto con nombre, ICAO y coordenadas.
- `src/StruniLeandroAeronave.java` -> entidad de aeronave con consumo, velocidad y horas de vuelo.
- `src/StruniLeandroCoordenadas.java` -> cálculo de distancia entre coordenadas geográficas.
- `.idea/` y `App-AirNavigation.iml` -> configuración del proyecto para IntelliJ IDEA.

---

## Tecnologías y herramientas

<div align="center">
  <img alt="Java" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/java.png" height="80" />
  <img alt="IntelliJ IDEA" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/intellij.png" height="80" />
  <img alt="GitHub" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/github.png" height="80" />
</div>

---

<table align="center">
  <tr>
    <td>
      <table align="center">
        <tr>
          <td align="center">
            <a href="https://github.com/LeanEmanuel">
              <img src="https://github.com/LeanEmanuel/Images/blob/main/Leandro.png" alt="Mini Leandro" width="80">
            </a>
          </td>
        </tr>
        <tr>
          <td>
            <a href="https://github.com/LeanEmanuel">
              <img src="https://img.shields.io/badge/LeanEmanuel-Git?style=flat&logo=github&logoColor=white&labelColor=black&color=50e520&label=GitHub" alt="Badge">
            </a>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
