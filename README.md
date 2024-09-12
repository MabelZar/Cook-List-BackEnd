# Cook-List-BackEnd  

# Descripción del Proyecto 📖   
Este proyecto es una aplicación web que permite a los usuarios organizar las comidas de la semana con sus preferencias personales y tener una lista de compras de acuerdo a ella. El proyecto esta desarrollado con Java para el back-end haciendo uso de la estructura MVC de 3 capas y la creación de una API con SpringBoot y por el front-end se conectara a una base de datos PostgreSQL con React.js  

# Funcionalidades 📋   
Autenticación: Formulario de registro que solicita nombre, e-mail, integrantes de la familia y contraseña. Formulario de acceso que solicita e-mail y contraseña.  

Menu Semanal: 
- Los usuarios autenticados podran acceder a la applicacion y crear su propia programacion semanal de comidas segun la semana seleccionada, podran seleccionar una comida por dia y tendran la opcion de editar y eliminar el plato seleccionado.
- Tendra un boton para guardar la programacion semanal y confirmacion de exito.
- Visualizar la lista de ingredientes correspondientes a los platos programados por semana. Podra marcar cada ingrediente. 
- Podra compartir la lista generada por WhatsApp.

Buscador de Platos y paginación: Permite mostrar una lista de platos a tiempo real mientras el usuario escriba en el.

# Tecnologías Utilizadas 🛠️  

Back-end: Java  

SpringBoot  

PostgreSQL  

JUnit  


Front-end: HTML  

Tailwind  

JavaScript  

React.js  

# Otras Herramientas:  
Maven  
# Cómo usar la aplicación 🔧  

Clonar el repositorio  

git clone https://github.com/tuusuario/happy-travel.git  

Back-end Configuración del Back-end  

Crea una base de datos en PostgreSQL  

Modifica las propiedades de conexión en el archivo application.properties  

spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos spring.datasource.username=tu_usuario spring.datasource.password=tu_contraseña Construir y ejecutar el back-end:  

cd happy-travel-backend mvn clean install mvn spring-boot:run Front-end Configuración del Front-End  

# Instalar dependencias del Front-end  

cd happy-travel-frontend npm install npm start o npm run dev   

# Contribución 🤝   

Haz un fork al repositorio.  

Crea una nueva rama: git checkout -b feature/name.  

Haz tus cambios.  

Haz push de tu rama: git push origin feature/name.  

Crea un pull request.  

# Autora ✒️   
Mabel Zárate Espíritu https://github.com.CrisZDE  

