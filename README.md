# PrimerParcial

Examen parcial #1

Utilizando el programa Netbeans, y Java como lenguaje de programación, resuelva los siguientes ejercicios según corresponda. Por favor leer cuidadosamente las indicaciones y realizar preguntas de forma en la primera hora de aplicación.
El examen es individual y tiene un valor de 25% de la nota, por lo que requiere de una concentración y esfuerzo máximo por parte de cada uno de los estudiantes.
Tome en cuenta que, en caso de sospecha de plagio, o al haber evidencia del mismo, la nota es cero.
Para resolver el examen, deberá iniciar con un proyecto nuevo, vacío, y empezar a diseñar las estructuras de datos que usted considere necesarias, así como los métodos dentro de las clases que le parezcan importantes para desarrollar el examen.
Es importante recalcar que se evalúa nombre de métodos, convenciones y funcionalidad, así como los test cases de los métodos especificados en este examen y Javadoc donde corresponda.
Éxitos y buena suerte.
Problema #1
Suponga que usted es Marcelo Bielsa y se le da una lista con los 23 jugadores que usted convocó para la copa mundial de Sudáfrica 2010, siendo seleccionador de Chile. En caso de no conocer las alineaciones de estos equipos, puede utilizar la internet para guiarse. Cabe resaltar, que usted va a manejar solamente la alineación inicial de ambos equipos, once contra once.
Para cada ejercicio resuelva lo que se le solicita:
1. Desarrolle el modelo de un jugador, con todo lo que conlleva.
2. Desarrolle un método que ordene la lista según la edad de los jugadores.
3. Suponga que se le lesionó el Chupete Suazo y debe convocar un nuevo jugador de apellido Pinilla, que tiene 27 años de edad. Agréguelo en la lista según el orden de la instrucción #1.
4. Para el partido contra España, se le da lista con el 11 titular de esa selección. Desarrolle un método que ordene la lista según el puesto de cada jugador, empezando por el portero y terminando con el delantero. A cada nodo agregue un jugador de su selección como marcaje, excepto al portero (en este caso Casillas).
5. Por último, desarrolle un método que se encargue de imprimir la lista de Chile de acuerdo a la formación introducida por el cuerpo técnico. Por ejemplo:
printLineUp(“1-4-3-3”)
Output:
Claudio Bravo Mauricio Isla – Gary Medel – Waldo Ponce – Gonzalo Jara
Arturo Vidal – Marco Estrada – Mark González
Jean Beausejour – Mauricio Pinilla – Alexis Sánchez
6. Para comprobar todo este funcionamiento, va a utilizar el método main, donde se van a agregar los jugadores en desorden en ambos equipos para ser ordenados por la edad de cada jugador en la selección de Chile, y por posición en la selección de España. Seguidamente, se imprimirá la alineación que usted desee, siempre tomando en cuenta las posiciones de cada jugador, y la suma de los números recibidos por parámetro, que no pueden ser más que once.
Por último, va a imprimir la lista de España, donde a la par de cada jugador, se va a poder ver su marcador debidamente identificado.
