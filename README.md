# 📘 Proyecto: ETF SalmonttApp - Semana 9

## 📝 Descripción general del sistema

SalmonttApp es un prototipo de sistema modular orientado a objetos para una empresa salmonera Salmontt, ubicada al sur de Chile. El objetivo del proyecto es modelar y organizar información clave del negocio (personas, unidades operativas, productos y órdenes) como base técnica escalable para futuros sistemas mas complejos.
El sistema representa entidades como empleados, clientes, proveedores, centros de cultivo, plantas de proceso y productos, utilizando herencia, composicion e interfaces. Los datos iniciales se cargan desde archivos de texto (`.txt`) y se gestionan mediante colecciones de objetos (List y Map), permitiendo listar, buscar y visualizar resumenes polimorficos a través de la interfaz común `Registrable`. De esta forma se reducen duplicaciones, se calrifica la jerarquia de tipos y se mejora la reutilizacion del código para versiones futuras del software.

---
## 🧱 Estructura general del proyecto

```
📦 SalmonttApp_S9_ETF/
┣ 📂 .idea/
┣ 📂 src/main
┃ ┣ 📂 java/cl/salmontt
┃ ┃ ┣ 📂 Interfaces/    #Interfaz Registrable (contrato común de entidades)
┃ ┃ ┣ 📂 data/		        #Clases que se encargan de cargar y gestionar datos.
┃ ┃ ┣ 📂 model/			#Entidades del dominio (Empleado, Persona, Dirección, Proveedor, etc).
┃ ┃ ┣ 📂 services/		#Responsables de aplicar reglas de negocio y operaciones sobre las listas cargadas. 
┃ ┃ ┣ 📂 ui/			#Punto de entrada, interfaz y Ejecución principal (Main.java).
┃ ┃ ┣ 📂 util/			#Utilitarios de consola, validaciones y excepciones personalizadas
┃ ┣ 📂 resources/
┃ ┃ ┣ 📊 Clientes.txt		            #Datos de clientes.
┃ ┃ ┣ 📊 Empleados.txt	                #Datos de empleados.
┃ ┃ ┣ 📊 PlantasYCentrosCultivo.txt	#Datos de plantas y centros de cultivo.
┃ ┃ ┣ 📊 Productos.txt	                #Datos de productos.
┃ ┃ ┣ 📊 Proveedores.txt	            #Datos de proveedores.
┣ 📂 target/
┃ ┃ ┣ 📦 SalmonttApp-S9-ETF-1.0-SNAPSHOT.jar	    # Archivo ejecutable generado por Maven
┃ 📜 README.md
┗ 📜 pom.xml			#Configuración Maven y dependencias

```
### Clases Principales

- `Persona.java` -> Clase abstracta para cualquier entidad del sistema (cliente, proveedor, empleado), está compuesta por RUT y Dirección. Es la raíz de la jerarquia de personas e implementa la interfaz `Registrable`.
- `UnidadOperativa.java` -> Clase abstracta para cualquier sucursal del sistema (Centro de Cultivos, Plantas de Proceso), es la raíz de la jerarquia de los sitios de Salmontt e implementa la interfaz `Registrable`.
- `Producto.java` -> Item del catálogo completo sobre los productos con lo que trabaja la empresa, administra también los precios.
- `Registrable.java` -> Interfaz que define el contrato común para las entidades que se listan en el sistema, su metodo principal es mostrarResumen(). Está implementada por (Clientes, Proveedores, Empleados, CentroCultivo, PlantaProceso). Permite usar `List<Registrable>` y polimorfismo.
- `EntidadesServices.java` -> Servicio central que administra `List<Registrable>`. Es el repositorio polimorfico donde conviven personas y unidades.
- `Gestores*` -> Clases que permiten leer los registros desde archivos externos (`.txt`).

Todas estas clases representan el corazón del proyecto, aplicando conceptos herencia, interfaces, sobrescritura y composición entre clases.

---
## 🧩 Requisitos

Para trabajar correctamente con los recursos de este repositorio, asegúrate de tener instalado lo siguiente:

- ☕ **Java JDK 21 o superior**  
  - [Descargar Java](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

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
git clone https://github.com/matisuarezm/SalmonttApp_S9_ETF.git
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


