# Dockerización

- Hasta el momento no ha sido posible ofrecer una solución con docker compose. Se está trabajando en ello. Se espera poder entregarla a final del día.

- Se dockerizó tanto el back end como el front end: ambas soluciones pueden ser vistas: https://hub.docker.com/r/amilder/repos

# Configuración de la base de datos

- Para el funcionamiento correcto de este proyecto se requiere crear un esquema de bases de datos MySQL de forma manual y en el puerto 3306

- Los scripts necesarios están en el backend "lyssmork-lair-api-main". Estos deben ser introducidos manualmente.

- una vez configurado el esquema. Note que la base de datos se llame "factored_demo2". En caso contrario, por favor haga el cambio en el application.properties de Spring boot para que haga "match" con la nueva base de datos.

- Finalmente, dele Run a la aplicación Spring Boot.

# Configuración del BackEnd

- El backend se encuentra en este repositorio, pero si desea acceder a él mediante la imágen dockerizada puede descargar.a

- descargar la imagen del backend ---->>> docker pull amilder/repos:1.2


# Configuración FrontEnd

- descargar la imágen del frontEnd ---->>>  docker pull amilder/repos:1.0

- npm inatall

- npm start

- El "login" sólo acepta las siguientes credenciales {
    username: "factored",
    password: "factored"
  }
  Usted puede cambiar el usuario y contraseña al momento de hacer el query MySQL cuando esté creando el user principal. Sólo este user puede entrar a la aplicación por lo que su correcto ingreso a la base de datos es imperativo para que pueda probar la app. 
  

 
