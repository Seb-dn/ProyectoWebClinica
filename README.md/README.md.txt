# 🏥 Proyecto Web Medicina — *Cuidado Vital CR*

## 📘 Descripción general:
**Proyecto Web Medicina** es un sistema web educativo e informativo desarrollado en **Java (NetBeans)**, **HTML**, **CSS** y **JavaScript**, que representa el sitio web de una página médica llamada **Cuidado Vital CR**.  
El proyecto está diseñado para ser una aplicación **interactiva y formativa**, dirigida a estudiantes de medicina y público general interesado en el área de la salud.  

El sitio web está dividido en **cinco niveles o secciones HTML**:
- **index.html:** Introducción general de la página médica.  
- **informacion.html:** Contiene información médica básica sobre enfermedades, tratamientos y cuidados.  
- **servicios.html:** Expone los servicios médicos disponibles (hospitalización, cuidados profesionales, exámenes clínicos, entre otros).  
- **consejos.html:** Se enfoca en la parte humana de la medicina y ofrece consejos profesionales y personales.  
- **contacto.html:** Formulario de contacto conectado a una base de datos mediante XAMPP para almacenar la información de los usuarios.

---

## 🎯 Objetivo del proyecto
El objetivo principal es desarrollar una **página web médica interactiva**, con diseño moderno y funcional, que:
- Permita la **interacción del usuario mediante formularios dinámicos**.  
- Integre conocimientos de **HTML, CSS, JavaScript y Java (Servlets)**.  
- Conecte con una **base de datos MySQL** para almacenar, eliminar y exportar información.  
- Sirva como práctica de diseño web, conexión a base de datos y uso de tecnologías del lado del servidor.

---

## 🧰 Tecnologías utilizadas
- **Frontend:** HTML5, CSS3, Bootstrap 4.6, FontAwesome  
- **Backend:** Java (Servlets, DAO, JDBC)  
- **Servidor:** XAMPP (Apache + MySQL)  
- **Base de datos:** MySQL (puerto `33065`, usuario `root`, sin contraseña)  
- **Entorno de desarrollo:** NetBeans  
- **Lenguajes:** Java, JavaScript, HTML, CSS  
- **Exportaciones:** PDF y Excel  

---

## 🗂️ Estructura del proyecto

---

## ⚙️ Funcionalidades principales
- Página web médica de cinco secciones totalmente navegable.  
- Formulario de contacto conectado a **base de datos MySQL**.  
- Operaciones CRUD sobre los datos:
  - Guardar información de contacto de usuarios.  
  - Eliminar registros existentes.  
  - Exportar datos a **PDF** y **Excel**.  
- Conexión mediante **Servlets** y **DAO (Data Access Object)**.  
- Diseño visual profesional con **Bootstrap y CSS personalizados**.  
- Contenido educativo sobre conceptos médicos y consejos profesionales.

---

## 🧠 Cómo agregar nuevos contenidos

1. **Nuevas secciones web:**  
   Crear un nuevo archivo ´.html` dentro de la raíz del proyecto y enlazarlo desde la barra de navegación.  

2. **Nuevas clases o funcionalidades Java:**  
   - Para controladores: agregar nuevas clases en el paquete `controlador`.  
   - Para conexión o modelos: crear clases en `modelo` o `dao` según la función.  

3. **Estilos y scripts:**  
   - Editar `css/estilos.css` para modificar el diseño.  
   - Añadir nuevos comportamientos con JavaScript si es necesario.

---

## 💻 Cómo ejecutar el proyecto

1. Abrir el proyecto en **NetBeans**.  
2. Iniciar el servidor local con **XAMPP** (Apache y MySQL activados).  
3. Crear la base de datos en **phpMyAdmin** (puerto `33065`, usuario `root`, sin contraseña).  
4. Ejecutar la clase principal o desplegar el proyecto en el servidor.  
5. Abrir en el navegador la dirección local:
6. Navegar entre las secciones del sitio y probar el formulario de contacto.

---

## 👨‍💻 Autor
- **Nombre:** Sebastián Nuñez Delgado
- **Año:** 2025  
- **Proyecto académico:** Desarrollo Web Médico — “Cuidado Vital CR”  
- **Versión:** 1.0  

---

## 🏁 Licencia
Proyecto desarrollado con fines educativos.  
Todos los derechos reservados © 2025 *Cuidado Vital CR*.


