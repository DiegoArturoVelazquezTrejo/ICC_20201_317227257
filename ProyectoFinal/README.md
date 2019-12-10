Introducción a Ciencias de la Computación

Diego Arturo Velazquez Trejo

Proyecto Final Juego de la Vida

1. Para compilar: sobre la carpeta de proyecto  escribir el comando:  gradle build
2. Para ejecutar el programa : gradle run
3. Se presentará unas indicaciones:
	a. Colocar la imagen que quiere usar dentro de la carpeta de src/main/resources.
	b. Habiendo ejecutado el comando 'gradle run', teclear el nombre, únicamente, de la imagen sin darle click a la consola. (sin extensión)
	c. Presionar la tecla '1' para agregar al nombre de la imagen la terminación '.jpg'
	d. Presionar la tecla '2' para agregar al nombre de la imagen la terminación '.png'
	e. Presionar enter, si aparece un error, vuelva a ejecutar el proceso.

Gradle es un compilador, mismo que usaremos para poder incluir la biblioteca de processing
En caso de no tener gradle instalado puede ejecutar los comandos:

	a) bash ./instalacion.bat

El proyecto inlcuye el gradle wrapper, mismo que te permite ejecutar el proyecto sin necesidad de tener gradle instalado.
Para eso, posiciónese en la carpeta del proyecto y ejecute el comando:

	a) ./gradlew run    (para ejecutar el programa)
	(Problemas de versión de java, más recomendable el punto de arriba de bash)
