import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque del programa.
 * - El sistema trabaja con arreglos dinámicos y arreglos de una dimensión y de dos dimensiones.
 * 
 * - Se realizó la creación de un sistema que permite crear cursos, crear profesor y asimismo poder gestionar cada una de las acciones 
 *  necesarias para poder manejar el horario donde estarán las asignaciones, las acciones que realiza el programa son las siguientes:
 *  
 *  MENU PRINCIPAL:
 *  ----------------BIENVENIDO----------------
 *   1. Crear profesor
 *   2. Crear curso
 *   3. Opciones de manipulación horario
 *   4. Salir
 * 
 *  SUB MENU DE OPCIONES HORARIO:
 * 
 *  ----------------OPCIONES HORARIO----------------
 *   1. Realizar asignación
 *   2. Visualizar la información de un curso en un horario en específico
 *   3. Eliminar un curso en un horario específico
 *   4. Inscribir un estudiante a un horario
 *   5. Actualizar horario de un curso
 *   6. Poner disponible el laboratorio en todos los horarios
 *   7. Visualizar el profesor en un día y horario disponible
 *   8. Visualizar el día y la hora que un profesor imparte clases
 *   9. Visualizar el porcentaje de responsabilidad de los profesores
 *   10. Salir
 * 
 *  - Validaciones del programa:
 * 
 *    1. Como método defensivo el sistema cuenta con un sistema de validación de entrada de datos lo cuál verifica que no se puedan ingresar caracteres en los campos
 *   donde se solicita valores enteros.
 * 
 *    2. Cuando se crea un profesor se valida que no se creen profesores con el mismo carné o email
 * 
 *    3. Cuando se crea un curso se valida que no se creen cursos con el mismo nombre
 * 
 *    4. Si se ingresa una opción que no es válida en el menú se le muestra un mensaje de "Opción invalida"
 * 
 *    5. Se válida que al ingresar el indice de la hora, no se ingrese horas que ya estan ocupadas por otras asignaturas.
 * 
 *    6. Se válida que en todo momento se ingresen indices de opciones válidas, de lo contrario se le mostrará al usuario un mensaje de "Indice inválido"
 * 
 *  - Es importante mencionar que todo el sistema se pensó para que el usuario solo tenga que ingresar opciones y no las escriba el mismo para evitar posibles errores de ejecución.
 * 
 *  **NOTAS**
 * 
 *  - Cuando se inicia por primera vez el sistema se crea un profesor y un curso por defecto.
 * 
 *  - En la opción para asignar y actualizar la matriz del horario al final de realizar la acción se muestra la matriz donde se aprecia visualmente
 *  el espacio ocupado por la asignación en el renglon y columna indicado, esto se dejará en el código unicamente para que el calificador pueda
 *  ver en donde es que se inserta cada asignatura.
 * 
 * - La estructura de la matriz bidimensional es de 5 renglones (Que representan los días de la semana (Lunes - Viernes) ) por 14 columnas
 *  donde cada una de ellas representa la hora desde 7am a 9pm.
 * 
 * - En todo momento deberá de seleccionar el indice que le corresponde según la opción que desee elegir, este mismo
 *   siempre estará al inicio de cada opción brindada.
 * 
 * - @author Jose Gerardo Ruiz García
 * - @version 1.0
 * 
 * - Fecha creación: 8/09/2023
 * - Ultima modificación: 12/09/2023
 */

public class Main{
    public static void main(String[] args) {
        // Variables de clase
        Scanner sc = new Scanner(System.in);
        boolean continuePrograma = true;
        int opcion = 0;

        //Instancias de clase
        Salon salon = new Salon();

        //DATA INICIAL
        salon.agregarDataInicial();

        // Loop que controla el flujo del programa
        while(continuePrograma){
            try {
                Menu();
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 1){   // 1. Crear profesor
                    // Se solicita la informacion para crear un profesor.
                    System.out.println("Ingrese el nombre completo del profesor: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el carné del profesor: ");
                    String carne = sc.nextLine();
                    System.out.println("Ingrese el email del profesor: ");
                    String email = sc.nextLine();
                    System.out.println("Ingrese el número de teléfono del profesor: ");
                    String telefono = sc.nextLine();
                    Profesor profesor = new Profesor(nombre, carne, email, telefono);
                    // Se agrega el profesor
                    salon.agregarProfesor(profesor);
                    
                }else if (opcion == 2){ // 2. Crear curso
                    // Se solicita la informacion para crear un curso.
                    System.out.println("Ingrese el código del curso: ");
                    String codigo = sc.nextLine();
                    System.out.println("Ingrese el nombre del curso: ");
                    String nombre = sc.nextLine();
                    System.out.println("Seleccione el profesor asignado a este curso: ");
                    // Se muestran los profesores
                    salon.mostrarProfesores();
                    // Se ingresa el profesor para ese curso
                    int indiceProfesor = sc.nextInt();

                    int sizeProfesores = salon.getProfesores().size();
                    // Se almacena la cantidad de profesores actuales para validar indice
                    ArrayList<Integer> indicesProfesores = new ArrayList<Integer>();
                    for (int i = 0; i < sizeProfesores; i++){
                        indicesProfesores.add(i);
                    }

                    if (indicesProfesores.contains(indiceProfesor)){
                        Profesor profesor = salon.getProfesores().get(indiceProfesor);
    
                        System.out.println("Ingrese el número de estudiantes asignados al curso: ");
                        int estudiantesAsignados = sc.nextInt();
    
                        // Se crea el curso
                        Curso curso = new Curso(codigo, nombre, estudiantesAsignados, profesor);
                        salon.agregarCurso(curso);

                    }else{
                        System.out.println("Indice inválido");
                    }


                }else if (opcion == 3){ // 3. Opciones de manipulación horario
                    salon.controladorSalon();

                }else if (opcion == 4){ // 4. Salir
                    continuePrograma = false;
                    System.out.println("¡Gracias por utilizar el sistema!");
                    
                }else{ // Opción no valida
                    System.out.println("Ingrese una opción válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
        }
    }

    /**
     * Metodo para ver opciones
     */
    public static void Menu(){
        System.out.println("----------------BIENVENIDO----------------");
        System.out.println("1. Crear profesor");
        System.out.println("2. Crear curso");
        System.out.println("3. Opciones de manipulación horario");
        System.out.println("4. Salir");
        System.out.println("Eliga un opcion por favor. ");
    }
}