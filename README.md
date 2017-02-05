# Lab4 - Almacenamiento con SharedPreferences #

## Descripción del problema ##
Crea un pequeño juego similar al propuesto en el tutorial de [AndroidYA](http://www.tutorialesprogramacionya.com/javaya/androidya/androidstudioya/detalleconcepto.php?codigo=13&inicio=0).


- En nuestro caso el usuario tiene que adivinar un número entre 1 y 10.
- Habrá un botón para generar un número nuevo cuando el usuario lo pulse.
- Cuando el usuario acierta el número la app tiene que mostrar mediante un TextView el número de intentos que ha necesitado.
- La puntuación se irá actualizando y almacenando mediante SharedPreferences.
- Localiza el fichero en el que se están guardando las preferencias y visualízalo.

## Capturas de la aplicación ##

Pantalla de inicio de nuestra aplicación. Introduciremos el nombre de jugador con el que queremos participar para posteriormente iniciar el juego. Tenemos también información sobre la última puntuación obtenida en el juego.

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_001.png" width="300">

Pantalla de juego. En el campo de texto introduciremos el número que creemos que se ha generado aleatoriamente. Con el botón "Nuevo número" generaremos un número aleatorio nuevo y con el botón "¿He acertado?" comprobamos si hemos acertado.

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_002.png" width="300">

Mensaje que se produce al acertar el número en el que nos da la enhorabuena y nos dice la puntuación que hemos obtenido.

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_003.png" width="300">

Toast que nos avisa al punsar el botón de "Nuevo número".

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_004.png" width="300">

Toast que nos avisa de que no hemos introducido ningún número en el campo de texto.

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_005.png" width="300">

Explorador en el que vemos el archivo SharedPreferences llamado "Puntuaciones.xml". Podemos descargarlo a nuestro equipo para así visualizarlo.

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_006.png" width="700">

Código XML del anteriormente mencionado archivo "Puntuaciones.xml".

<img src="https://dl.dropboxusercontent.com/u/52992573/PGL/Lab4/Lab4_1_SharedPreferences_007.png" width="300">
