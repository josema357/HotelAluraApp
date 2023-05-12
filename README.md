# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---

## ⚒ Tecnologías Utilizadas:

- Java SE
- Java Swing
- Eclipse
- Biblioteca JCalendar
- Maven
- MySql
- JPA
- Hibernate
- Plugin WindowBuilder 
- Spring-Security-Core (org.springframework.security)
</br>

---
## ⚠️ Importante! ⚠️

☕ Use Java versión 11 o superior para compatibilidad. </br></br>
📝 Use el editor de Eclipse para compatibilidad con la Interfaz Gráfica. </br></br>
🎨 La interfaz contiene dos métodos importantes:<br/>
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro false, la pantalla no se puede maximizar;
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro null la mantiene centrada en la pantalla.<br/>

---

## 📂 Directorios 
🔹 src/main/java: Carpeta donde se guarda el codigo del proyecto.<br/>
🔹 src/main/resources: Carpeta donde se encuentra el archivo de configuracion persistence.xml.<br/>
🔹 imagenes: contiene las imagenes para este Readme.
---

## 📦 Paquetes /src/main/java:
🔹 com.josema.imagenes: contiene las imagenes para este proyecto.<br/>
🔹 com.josema.views: contiene las interfaces graficas de Java Swing.<br/>
🔹 com.josema.utils: contiene la clase JPAUtils que obtiene una instancia de EntityManager para interactuar con la BD.<br/>
🔹 com.josema.modelo: contiene las entidades JPA que representan una tabla en la BD.<br/>
🔹 com.josema.dao: contiene las consultas para obtener informacion de la BD.<br/>
🔹 com.josema.controlador: contiene los controladores que encapsulan la logica de negocio y coordinan las operaciones de persistencia.

--- 
## 🖥️ Funcionamiento de la aplicacion
Login:
- Se pide el nombre de usuario y las contraseña.
- Se verifica si el usuario se encuentra registrado en la BD.
- Si no esta registrado, se mostrará un ventana indicando que no ha ingresado datos validos.
<br/>

Menu Principal:
- Se muestra al usuario dos opciones (Registro de reservas & Busqueda)
<br/>

Registro de Reserva:
- Se pide que ingrese la fecha de entrada, la fecha de salida, y la forma de pago.
- El valor de la reserva se calcular automaticamente
- Debe completar todos los campos, de lo contrario mostrará un mensaje y no se podra seguir con el registro.
- Al dar click en el boton siguiente mostrará la interfaz grafica para registrar al huesped.
<br/>

Registro de Huesped:
- Se pide que ingrese el nombre, el apellido, la fecha de nacimiento, el dni, el telefono del huesped.
- El numero de la reserva del usuario se extrae de la reserva previamente registrada.
- Debe completar todos los campos, de lo contrario mostrara un mensaje y no resgistrará al huesped.
- Si el dni del huesped ya esta registrado anteriormente no lo agregara nuevamente, y seguira con el registro con normalidad.
- Al dar click al boton guardar mostrara una ventana mostrando que se guardo con exito y luego mostrará el menu principal.
<br/>

Busqueda:

La interfaz grafica de busqueda, tiene dos ventanas (Reservas & Huespedes). Ambas tienen las mismas funciones:
- Boton de Busqueda: para ambos casos la busqueda se realiza por medio del DNI del huesped.
- Boton de Actualizar: actualizará los datos de la ventana en que se encuentre.
- Boton de Editar: abrira un nueva interfaz grafica dependiendo de la ventana en la que se encuentre y le permitirá editar el registro.
- Boton de Eliminar: elimina el registro que desee.
<br/>

Nota: para editar o eliminar antes debes seleccionar el resgitro, de lo contrario mostrara un mensaje para que lo haga.

---

## 💾 Diagrama de la BD
<p align="center" >
     <img width="400" heigth="400" src="imagenes/DiagramaEER.png">
</p>

---

# Menu Principal
<p align="center" >
     <img width="400" heigth="400" src="imagenes/MenuPrincipal.png">
</p>

---

# Login 
<p align="center" >
     <img width="400" heigth="400" src="imagenes/Login.png">
</p>

---

# Menu Usuario
<p align="center" >
     <img width="400" heigth="400" src="imagenes/MenuUsuario.png">
</p>

---

# Registrar Reserva
<p align="center" >
     <img width="400" heigth="400" src="imagenes/RegistroReserva.png">
</p>

---

# Registrar Huésped
<p align="center" >
     <img width="400" heigth="400" src="imagenes/RegistroHuesped.png">
</p>

# Búsqueda
<p align="center" >
     <img width="400" heigth="400" src="imagenes/Busqueda.png">
</p>

---

## Contacto
<a href="https://www.linkedin.com/in/josema317"><img width="30" src="https://www.vectorlogo.zone/logos/linkedin/linkedin-icon.svg"/></a>
<a href="https://twitter.com/7Jmanuel"><img width="30" src="https://www.vectorlogo.zone/logos/twitter/twitter-tile.svg"/></a>

## Licencia
MIT