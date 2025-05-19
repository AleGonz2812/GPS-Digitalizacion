# Proyecto Final - Sistema de Seguimiento de Autobuses

**Nombre:** Alejandro González Vela  
**Curso:** 1º DAM  
**Asignatura:** Desarrollo de Aplicaciones Multiplataforma  
**Fecha:** 19 Mayo 2025

---

## 📌 Descripción general

Este proyecto simula un sistema de seguimiento de autobuses urbanos utilizando datos GPS.  
Se generan registros simulados que incluyen la ubicación, velocidad y hora de cada punto recorrido por varios autobuses.  
A partir de estos datos, se procesan, validan, filtran y visualizan diferentes estadísticas, todo desarrollado en Java.

---

## 🧱 Estructura del proyecto

El proyecto está dividido en varias clases, organizadas por funcionalidad:

| Clase                | Función principal                                          |
|----------------------|------------------------------------------------------------|
| `GPSData`            | Clase modelo con la información de cada punto GPS         |
| `GPSDataGenerator`   | Genera datos GPS simulados para varios autobuses          |
| `GPSDataLoader`      | Carga los datos desde un archivo CSV                      |
| `GPSDataProcessor`   | Valida y filtra los datos cargados                        |
| `GPSDataReport`      | Muestra estadísticas, detecta paradas y exporta informes  |
| `Main`               | Orquesta todo el flujo de ejecución del proyecto          |

---

## 🖥️ Funcionalidades implementadas

- ✅ Generación de datos para 3 autobuses (`BUS01`, `BUS02`, `BUS03`)
- ✅ Validación de datos GPS (latitud, longitud, velocidad, timestamp)
- ✅ Filtro por identificador de autobús
- ✅ Visualización de recorrido, velocidad media y paradas detectadas
- ✅ Exportación de informes `.txt` y datos `.json` por autobús
- ✅ Modo completamente automático desde `Main`

---

## 📂 Estructura de archivos generados

Tras ejecutar el programa, se generan:

- `gps_data.csv` → Archivo con todos los registros GPS
- `bus01_informe.txt` → Informe con resumen, velocidad y recorrido de BUS01
- `bus01.json` → Datos de BUS01 en formato JSON
- (y lo mismo para `BUS02` y `BUS03`)

---

## 🔧 Estructura de clases (diagrama en texto)
GPSData
└── atributos: busId, timestamp, latitude, longitude, speed

GPSDataGenerator
└── generarDatos(String archivo)

GPSDataLoader
└── cargarDesdeCSV(String archivo)

GPSDataProcessor
├── validarDatos(List<GPSData>)
└── filtrarPorBus(List<GPSData>, String busId)

GPSDataReport
├── mostrarResumen(...)
├── mostrarRecorrido(...)
├── calcularVelocidadMedia(...)
├── detectarParadas(...)
├── guardarInforme(...)
└── exportarAJSON(...)

Main
└── main(String[] args)


---

## 🔮 Posibles mejoras futuras

- Implementar una interfaz gráfica (JavaFX) con visualización del recorrido
- Añadir exportación a CSV y XML
- Guardar los datos directamente en una base de datos (MySQL, PostgreSQL)
- Filtrar por rango horario
- Interacción por consola (elegir el autobús o mostrar resumen por fecha)

---

## 🛡️ Mantenimiento y archivado

Los archivos generados (`csv`, `txt`, `json`) pueden conservarse para análisis o archivarse en la nube.  
Como medida de mantenimiento, se podría añadir una política de eliminación automática o limpieza periódica.  
Los datos sensibles podrían eliminarse automáticamente al cerrar la aplicación.

---

## ✅ Cómo ejecutar

1. Clonar el repositorio:

Abrir git bash, y dentro hacer git clone de este enlace https://github.com/AleGonz2812/GPS-Digitalizacion.git
   
2. Abrir el proyecto en IntelliJ IDEA

3. Ejecutar la clase Main.java