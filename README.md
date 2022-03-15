# Disney API :sparkles:
## English Guide
Java BackEnd Code Challenge by [Alkemy](https://www.alkemy.org/) 

#### -Info prior to database deployment :page_with_curl: 
> - The connection has no password, only user 'root' and runs on 'localhost' with port 8081.
> - If you use MySqlWorkBench you will have to add a password in `spring.datasource.password`.
> - The Database name is `disney`. If you want to change it you must do it in `spring.datasource.url= jdbc:mysql://localhost/[NEW NAME]` > - The database name is `disney`.
>
```yml
server.port=8081
spring.datasource.url= jdbc:mysql://localhost/disney
spring.datasource.username= root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
```

### -Steps to deploy the Database :clipboard: 
 1. Create a New Schema if using MySqlWorkBench or Database if using XAMPP (or similar), with the name assigned in `spring.datasource.url`.
 2. After downloading and unzipping the code, you must run the `ChallengeApplication.java` file from your IDE.
 3. Wait for the execution of the database (It may take some time because it performs INSERT VALUE so that the database is not empty).
 4. Final Step: Visit the [Documentation](https://documenter.getpostman.com/view/18219574/UVsLRm6s#cc93e3df-1cb5-4a07-adcf-128be41a66db) to be able to Register, Login and call the EndPoints (Using POSTMAN)

#### -Things to note
- The app can send emails to any domain, but only from Google accounts. It has one entered by default (account created for this code), but in case the credentials are wrong the program will not send a welcome email. 
**How to avoid it? (Adding an account of your own)** **.
	- Go to `application.properties` and change.
		- `spring.mail.username` 
		- `spring.mail.password` 
				
	- Then go to `srcc\main\java\alkemy\challenge\models\EMail.java` and modify the field `mailFrom = "ENTER NEW EMAIL"`.
		- Within this same entity you can modify:
			- `mailSubject` <- Email Title
			- `mailContent` <- Email Content
   
> You can add any Gmail account, but always do it at your own risk, I am not responsible in case of damages.


## Guia en Español
Java BackEnd Code Challenge de [Alkemy](https://www.alkemy.org/) 

#### -Info previa al desplegue de la base de datos :page_with_curl: 
>  - La conexión no cuenta con contraseña, solo usuario 'root' y corre en el 'localhost' con puerto 8081
> - Si usa MySqlWorkBench tendrá que agregar una contraseña en `spring.datasource.password`
> - El nombre de la Base de datos es `disney`. Si quiere cambiarlo debe hacerlo en `spring.datasource.url= jdbc:mysql://localhost/[NUEVO NOMBRE]`
> 
```yml
server.port=8081
spring.datasource.url= jdbc:mysql://localhost/disney
spring.datasource.username= root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
```

### -Pasos para desplegar la Base de Datos :clipboard: 
 1. Crear un Nuevo Schema si usa MySqlWorkBench o Base de Datos si usa XAMPP (o similar), con el nombre asignado en `spring.datasource.url`
 2. Luego de descargado y descomprimido el código, debe correr el archivo `ChallengeApplication.java`desde tu IDE
 3. Esperar a la ejecución de la base (Puede demorar ya que realiza INSERT VALUE para que la BD no este vacía)
 4. Paso Final: Visitar la  [Documentacion](https://documenter.getpostman.com/view/18219574/UVsLRm6s#cc93e3df-1cb5-4a07-adcf-128be41a66db) para poder Registrarse, Ingresar y llamar a los EndPoints (Utilizando POSTMAN)

#### -Cosas a tener en cuenta
- La app puede enviar emails a cualquier dominio, pero solo desde cuentas de Google. Tiene una ingresado por default (cuenta creada para este código), pero en caso de que las credenciales sean erróneas el programa no enviara Email de bienvenida. 
**Como Evitarlo? (Agregando una cuenta suya)**
	- Dirigirse a `application.properties` y cambiar.
		- `spring.mail.username`
		- `spring.mail.password` 
				
	- Luego dirigirse a `src\main\java\com\alkemy\challenge\models\EMail.java` y modificar el campo `mailFrom = "INGRESE NUEVO EMAIL"`
		- Dentro de esta misma entidad se puede modificar:
			- `mailSubject` <- Titulo del Email
			- `mailContent`<- Contenido del email
>Puede agregar cualquier cuenta de Gmail, pero siempre hágalo a su propio riesgo, no me hago responsable en caso de daños y perjuicios.
