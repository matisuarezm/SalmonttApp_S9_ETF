# 📘 Proyecto: ETF SalmonttApp - Semana 9

## 📝 Descripción general del sistema

SalmonttApp es un sistema de gestión para una empresa salmonera que permite registrar y administrar distintas entidades del negocio, como centros de cultivo, plantas de proceso, proveedores y empleados, de forma unificada mediante una interfaz común `Registrable.java`. 
El sistema organiza todas estas entidades en una colección polimórfica, aplica herencia y `instanceof` para personalizar la lógica según el tipo de objeto y ofrece una interfaz gráfica simple en Swing para ingresar nuevos registros y visualizar un resumen de los existentes, pensada para uso por personal administrativo no técnico.

---
## 🧱 Estructura general del proyecto

```
📦 SalmonttApp_S8/
┣ 📂 .idea/
┣ 📂 src/main
┃ ┣ 📂 java/cl/salmontt
┃ ┃ ┣ 📂 data/		        #Clases que se encargan de cargar y gestionar datos.
┃ ┃ ┣ 📂 model/			#Entidades del dominio (Empleado, Persona, Dirección, Proveedor).
┃ ┃ ┣ 📂 services/		#Responsables de aplicar reglas de negocio y operaciones sobre las listas cargadas. 
┃ ┃ ┣ 📂 ui/			#Punto de entrada, interfaz y Ejecución principal (Main.java).
┃ ┃ ┣ 📂 util/			#Utilitarios de consola, validaciones y excepciones personalizadas
┃ ┣ 📂 resources/
┃ ┃ ┣ 📊 Empleados.xlsx		#Datos de empleados
┃ ┃ ┣ 📊 PlantasYCentrosCultivos.txt	#Datos de plantas y centros de cultivo.
┣ 📂 target/
┃ ┃ ┣ 📦 SalmontApp-S8-1.0-SNAPSHOT.jar	    # Archivo ejecutable generado por Maven
┃ 📜 README.md
┗ 📜 pom.xml			#Configuración Maven y dependencias

```
### Nuevas clases incorporadas en la actividad

Semana 8

- `Registrable.java` #Interfaz que implementan las clases (Empleado, Proveedor, CentroCultivo y PlantaProceso).
- `SalmonttAppFrame.java` #Clase que genera una interfaz gráfica de ingreso de objetos.
- `GestorEntidades.java` #Clase que gestiona una coleccion ArrayList<Registrable> y aplica logica diferenciada con instanceof.
- `Proveedor.java` #Clase que simula una nueva entidad el sistema.

Todas estas clases representan la acumulación del proyecto, aplicando conceptos herencia, interfaces, sobre-escritura de métodos y composición entre clases.

---
## 🧩 Requisitos

Para trabajar correctamente con los recursos de este repositorio, asegúrate de tener instalado lo siguiente:

- ☕ **Java JDK 18 o superior**  
  - [Descargar Java](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)

- 💻 **IDE recomendado: IntelliJ IDEA Community Edition**  
  - [Descargar IntelliJ IDEA (Community Edition)](https://www.jetbrains.com/idea/download/)  

- 🧰 **Git instalado para clonar y versionar el repositorio**  
  - [Descargar Git](https://git-scm.com/downloads)

- 🌐 **Cuenta de GitHub activa** (obligatoria)  
  - [Crear cuenta en GitHub](https://github.com/signup)  
   > Tu cuenta te servirá para clonar repositorios, subir avances, y entregar evaluaciones a través de GitHub. 

---
## ⚙️ Instrucción de Ejecución

### Instrucciones para clonar y ejecutar el proyecto en IDE

- clonar el repositorio de github
```bash
git clone https://github.com/matisuarezm/SalmonttApp_S8.git
```
- Abre el proyecto en IntelliJ IDEA.
- Abre la clase `Main.java` del paquete `ui`
- Puedes ejecutar el proyecto.

	> Nota: Al ejecutar la clase Main.java se inicializa una ventana para el ingreso de las Entidades.

---

## 👤 Autor del proyecto
- **Nombre completo:** Matias Suarez M.
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Carrera 100% Online


