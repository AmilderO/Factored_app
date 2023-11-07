# Dockerización

- Hasta el momento no ha sido posible ofrecer una solución dockerizada. Se está trabajando en ello. Se espera poder entregarla a final del día.

# Configuración de la base de datos

- Para el funcionamiento correcto de este proyecto se requiere crear un esquema de bases de datos MySQL de forma manual y en el puerto 3306

- Los scripts necesarios están en el backend "lyssmork-lair-api-main". Estos deben ser introducidos manualmente.

- una vez configurado el esquema. Note que la base de datos se llame "factored_demo2". En caso contrario, por favor haga el cambio en el application.properties de Spring boot para que haga "match" con la nueva base de datos.


# Configuración FrontEnd

- npm inatall

- npm start

- El "login" sólo acepta las siguientes credenciales {
    username: "factored",
    password: "factored"
  }
  Por favor ingresar sólo con ese usuario y contraseña.
  

 
