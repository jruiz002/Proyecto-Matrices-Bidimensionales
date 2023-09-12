import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Salon {
    // Atributo que almacena cada una de las asignaciones realizadas en un horario en específico.
    private Asignacion[][] matrizHorario;

    // Atributo que almacena todos los cursos que se imparten en la universidad.
    private ArrayList<Curso> cursos;

    // Atributo que almacena todos los profesores que dan clases en la universidad.
    private ArrayList<Profesor> profesores;

    // Lista de control del horario
    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
    String[] horarios = new String[14];

    /**
     * Método que permite crear un objeto de tipo salón.
     */
    public Salon() {
        this.matrizHorario = new Asignacion[5][14];
        this.cursos = new ArrayList<Curso>();
        this.profesores = new ArrayList<Profesor>();
        llenadoHorario();
    }

    // Metodo que genera el intervalo de hora del horario
    public void llenadoHorario(){
        for (int i = 0; i < 14; i++) {
            int hora = 7 + i; // Comienza en 7 AM y aumenta una hora en cada iteración
            String horario = hora + ":00" + " - " + (hora + 1) + ":00"; // Formato "HH:00"
            horarios[i] = horario;
        }
    }

    /**
     * @return Método que devuelve la matriz que contiene el horario.
     */
    public Asignacion[][] getMatrizHorario() {
        return this.matrizHorario;
    }

    /**
     * Método que recibe la matriz que contiene el horario y lo almacena en el atributo correspondiente.
     * 
     * @param matrizHorario parámetro que almacena la matriz
     */
    public void setMatrizHorario(Asignacion[][] matrizHorario) {
        this.matrizHorario = matrizHorario;
    }

    /**
     * 
     * @return Método que devuelve los cursos de la universidad.
     */
    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    /**
     * Método que recibe un arreglo dinámico de cursos y lo almacena en el atributo correspondiente.
     * 
     * @param cursos parámetro que establece los cursos de la lista
     */
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    /**
     * 
     * @return Método que devuelve los profesores de la universidad.
     */
    public ArrayList<Profesor> getProfesores() {
        return this.profesores;
    }

    /**
     * Método que recibe un arreglo dinámico de profesores y lo almacena en el atributo correspondiente.
     * 
     * @param profesores parámetro que almacena los profesores de la lista
     */
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    /**
     * Método que agrega un curso y un profesor al ejecutar el programa por primera vez.
     */
    public void agregarDataInicial(){
        Profesor profesor = new Profesor("Jose Ruiz", "23719", "jose@gmail.com", "12345678");
        profesores.add(profesor);

        Curso curso = new Curso("CAL1", "CALCULO", 2, profesor);
        agregarCurso(curso);

    }

    // MÉTODOS CONTROLADOR

    /**
     * Método que agrega un profesor a la lista de profesores de la universidad.
     * 
     * @param profesor profesor a agregar a lista
     */
    public void agregarProfesor(Profesor profesor){
        boolean bandera = false;
        for (Profesor profesorElemento : profesores) {
            if (profesorElemento.getCarne().equals(profesor.getCarne()) || profesorElemento.getEmail().equals(profesor.getEmail())) {
                bandera = true;
            }
        }

        if (bandera){
            System.out.println("No puedes agregar profesores con el mismo carné o correo electrónico");
        }else{
            profesores.add(profesor);
            System.out.println("¡Profesor creado exitosamente!");
            System.out.println();
        }        
    }

    /**
     * Método que muestra los profesores de la universidad.
     */
    public void mostrarProfesores(){
        for(int i = 0; i < profesores.size(); i++){
            System.out.println(i + ". " + profesores.get(i).getNombre());
        }
    }

    /**
     * Método que agrega un curso a la lista de cursos de la universidad.
     * 
     * @param curso curso a agregar
     */
    public void agregarCurso(Curso curso){
        boolean bandera = false;

        for (Curso cursoElemento : cursos) {
            if (cursoElemento.getNombre().equals(curso.getNombre()) || cursoElemento.getCodigo().equals(curso.getCodigo())){
                bandera = true;
            }
        }
        if (bandera){
            System.out.println("No puedes agregar cursos con el mismo nombre o código");
        }else{
            cursos.add(curso);
            System.out.println("Curso creado exitosamente!");
            System.out.println();
        } 
    }

    // Método que muestra los cursos de la universidad.
    public void mostrarCursos(){
        for(int i = 0; i < cursos.size(); i++){
            System.out.println(i + ". " + cursos.get(i).getNombre());
        }
    }

    /**
     * Método que controla cada una de las acciones para la gestión de las opciones para manipular el horario.
     */
    public void controladorSalon(){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        int opcion = 0;

        while(bandera){
            try {
                subMenu();
                opcion = sc.nextInt();
                if (opcion == 1){ // 1. Realizar asignación
                    asignarCurso();

                }else if (opcion == 2){ // 2. Visualizar la información de un curso en un horario en específico
                    verInfoCurso();

                }else if (opcion == 3){ // 3. Eliminar un curso en un horario específico
                    eliminarCursoHorario();

                }else if (opcion == 4) { // 4. Inscribir un estudiante a un horario
                    inscribirEstudiante();

                }else if (opcion == 5) { // 5. Actualizar horario de un curso
                    actualizarHorarioCurso();

                }else if (opcion == 6) { // 6. Poner disponible el laboratorio en todos los horarios
                    limpiarHorario();

                }else if (opcion == 7) {// 7. Visualizar el profesor en un día y horario disponible
                    verProfesorDiaHora();

                }else if (opcion == 8) {// 8. Visualizar el día y la hora que un profesor imparte clases
                    verProfesorHorario();

                }else if (opcion == 9) {// 9. Visualizar el porcentaje de responsabilidad de los profesores
                    verPorcentajeResponsabilidad();

                }else if (opcion == 10) {// 10. Salir
                    bandera = false;
                    
                }else{
                    System.out.println("Ingrese una opción válida.");
                }                
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
        }
    }

    //--------------------------------------------- MÉTODOS PARA REALIZAR LA ASIGNACIÓN DE UN CURSO A UN HORARIO EN ESPECÍFICO ---------------------------------------------//

    // Método que muestra los días de la semana (Lunes - Viernes)
    public void mostrasDias(){
        for(int i = 0; i < diasSemana.length; i++){
            System.out.println(i + ". " + diasSemana[i]);
        }
    }

    /**
     * Método que muestra las horas disponibles para asignar según el día seleccionado.
     * 
     * @param indiceDia indice del día seleccionado
     */
    public ArrayList<Integer> horasDisponibles(int indiceDia){
        // [0] indice de horas ocupadas
        ArrayList<Integer> listaHorarios = new ArrayList<Integer>();

        // Se agrega a la lista de enteros el indice del horario que esta ocupado de ese curso
        for (Curso cursoElemento : cursos){
            for (Horario horario : cursoElemento.getListaHorarios()) {// Lista de horarios de un curso 
                if (horario.getDia() == indiceDia){
                    listaHorarios.add(horario.getHora());
                }
            }
        }

        // Se agregan las horas disponibles
        ArrayList<Integer> horariosDisponibles = new ArrayList<Integer>();
        for (int i = 0; i < 14; i++){
            if (!listaHorarios.contains(i)){
                horariosDisponibles.add(i);
            }
        }

        return horariosDisponibles;

    }

    /**
     * Método encargado de realizar la asignación de un curso al horario.
     */
    public void asignarCurso(){
        // Variables del metodo
        Scanner sc = new Scanner(System.in);
        try {
            //Se solicita la informacion al usuario para asignar un curso al horario
            System.out.println("Ingrese el curso que desea asignar a un horario en específico: ");
            mostrarCursos();
            int indiceCurso = sc.nextInt();
            
            // Se valida que se ingrese un indice valido de un curso.
            ArrayList<Integer> indicesCursos = new ArrayList<Integer>();
            int sizeCursos = getCursos().size();
            for (int i = 0; i < sizeCursos; i++){
                indicesCursos.add(i);
            }
            
            if (indicesCursos.contains(indiceCurso)){
                Curso curso = cursos.get(indiceCurso);
                System.out.println("Ingrese día en el que desea asignar el curso: ");
                mostrasDias();
                int indiceDia = sc.nextInt();
    
                if (indiceDia >= 0 && indiceDia <= 4) {
                    System.out.println("Seleccione una hora para asignarle al curso: ");
                    int indiceHora = 0;
                    
                    for (Integer elementoLista : horasDisponibles(indiceDia)) {
                        System.out.println(elementoLista + ". " + horarios[elementoLista]);
                    }
        
                    indiceHora = sc.nextInt();
        
                    // Se valida que se ingresen unicamente los indices indicados en consola
                    if (horasDisponibles(indiceDia).contains(indiceHora)) {
                        Asignacion asignacion = new Asignacion(0, curso);
                        
                        Horario horario = new Horario(indiceDia, indiceHora);
                        
                        curso.agregarHorario(horario);
            
                        matrizHorario[indiceDia][indiceHora] = asignacion;
            
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 14; j++) {
                                if (matrizHorario[i][j] == null){
                                    System.out.print("Vacío" + "\t"); // Utiliza tabulaciones como separadores
                                }else{
                                    System.out.print(matrizHorario[i][j].getCurso().getNombre() + "\t"); // Utiliza tabulaciones como separadores
                                }
                            }
                            System.out.println(); // Cambia de línea después de cada fila
                        }
            
                        System.out.println("¡Asignación realizada exitosamente!");           
        
                    }else{
                        System.out.println("Indice inválido.");
                    }
    
                }else{
                    System.out.println("Indice inválido.");
                }

            }else{
                System.out.println("Indice inválido.");
            }
            
        
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
    }

    //--------------------------------------------- MÉTODOS PARA VISUALIZAR LA INFORMACIÓN DE UN CURSO EN ESPECÍFICO ---------------------------------------------//
    /**
     * Método para ver el curso que se imparte a una hora y día en específico.
     */
    public void verInfoCurso(){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println();
            System.out.println("Para visualizar la información de un curso en un horario en específico, ingrese lo siguiente por favor:  ");
    
            System.out.println();
            System.out.println("Ingrese el día: ");
            mostrasDias();
            int indiceDia = sc.nextInt();

            if (indiceDia >= 0 && indiceDia <= 4) {
                System.out.println("Ingrese el horario: ");
                for (int i = 0; i < horarios.length; i++){
                    System.out.println(i + ". " + horarios[i]);
                }
                int indiceHorario = sc.nextInt();

                if (indiceHorario >= 0 && indiceHorario <= 13){
                    if (matrizHorario[indiceDia][indiceHorario] == null){
                        System.out.println("¡Actualmente, este horario se encuentra disponible, por lo que no hay información de algún curso!");
                    }else{
                        System.out.println();
                        System.out.println("---------------- INFORMACIÓN CURSO ----------------");
                        System.out.println("Curso impartido: " + matrizHorario[indiceDia][indiceHorario].getCurso().getNombre());
                        System.out.println("Profesor encargado: " + matrizHorario[indiceDia][indiceHorario].getCurso().getProfesor().getNombre());
                        System.out.println("Contacto profesor: " + matrizHorario[indiceDia][indiceHorario].getCurso().getProfesor().getTelefono());
                        System.out.println("Horario en el que se imparte el curso: ");
                        System.out.println("Día: " + diasSemana[indiceDia]);
                        System.out.println("Horario: " + horarios[indiceHorario]);
                    }

                }else{
                    System.out.println("Indice inválido.");
                }
        

            }else{
                System.out.println("Indice inválido.");
            }
    
        }catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
    }

    //--------------------------------------------- MÉTODOS PARA ELIMINAR UN CURSO EN HORARIO EN ESPECÍFICO ---------------------------------------------//
    /**
     * Método para eliminar un curso de un horario en específico.
     */
    public void eliminarCursoHorario(){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        try {
            // Se solicita información para eliminar un curso
            System.out.println();
            System.out.println("Para eliminar un curso en un horario en específico, ingrese lo siguiente por favor:  ");
    
            System.out.println();
            System.out.println("Ingrese el curso: ");
            mostrarCursos();
            int indiceCurso = sc.nextInt();

            // Se valida que se ingrese un indice valido de un curso.
            ArrayList<Integer> indicesCursos = new ArrayList<Integer>();
            int sizeCursos = getCursos().size();
            for (int i = 0; i < sizeCursos; i++){
                indicesCursos.add(i);
            }   
            
            if (indicesCursos.contains(indiceCurso)){
                System.out.println("Ingrese el horario a eliminar: ");
                ArrayList<Horario> listaHorarios = cursos.get(indiceCurso).getListaHorarios();
                ArrayList<Integer> indicesHorarios = new ArrayList<Integer>();
                for (int i = 0; i <  listaHorarios.size(); i++) {
                    indicesHorarios.add(i);
                    System.out.println(i + ". " + "Día: " + diasSemana[listaHorarios.get(i).getDia()] + "; " + "Hora: " + horarios[listaHorarios.get(i).getHora()]);
                }
                int indiceHorario = sc.nextInt();
    
                if (indicesHorarios.contains(indiceHorario)){
                    // Se utilizan los indices del dia y la hora para obtener la asignación a eliminar
                    Curso curso = cursos.get(indiceCurso);
                    Horario horarioSeleccionado = curso.getListaHorarios().get(indiceHorario);
            
                    // Se elimina el curso de la matriz de horarios
                    matrizHorario[horarioSeleccionado.getDia()][horarioSeleccionado.getHora()] = null;
                    
                    // Se elimina el horario de la lista de horarios
                    curso.getListaHorarios().remove(indiceHorario);
            
                    System.out.println("¡Se eliminó correctamente el horario del curso seleccionado!");
    
                }else{
                    System.out.println("Indice inválido.");
                }

            }else{
                System.out.println("Indice inválido.");
            }
    
    

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
    }

    //--------------------------------------------- MÉTODOS PARA REALIZAR LA ASIGNACIÓN DE UN ESTUDIANTE EN UN HORARIO EN ESPECÍFICO ---------------------------------------------//
    /**
     * Método para inscribir un estudiante al curso en un horario en específico
     */
    public void inscribirEstudiante(){
        // Variables del método
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println();
            System.out.println("Para inscribir a un estudiante en un horario en específico necesita hacer lo siguiente: ");
    
            System.out.println();
            System.out.println("Ingrese el curso: ");
            mostrarCursos();
            int indiceCurso = sc.nextInt();

            // Se valida que se ingrese un indice valido de un curso.
            ArrayList<Integer> indicesCursos = new ArrayList<Integer>();
            int sizeCursos = getCursos().size();
            for (int i = 0; i < sizeCursos; i++){
                indicesCursos.add(i);
            } 

            if (indicesCursos.contains(indiceCurso)){
                System.out.println("Ingrese el horario a asignar: ");
                ArrayList<Horario> listaHorarios = cursos.get(indiceCurso).getListaHorarios();
                ArrayList<Integer> listaIndicesHorarios = new ArrayList<Integer>();
                for (int i = 0; i <  listaHorarios.size(); i++) {
                    listaIndicesHorarios.add(i);
                    System.out.println(i + ". " + "Día: " + diasSemana[listaHorarios.get(i).getDia()] + "; " + "Hora: " + horarios[listaHorarios.get(i).getHora()]);
                }
                int indiceHorario = sc.nextInt();
    
                if (listaIndicesHorarios.contains(indiceHorario)){
                    Curso curso = cursos.get(indiceCurso);
                    Horario horarioSeleccionado = curso.getListaHorarios().get(indiceHorario);
            
                    // Aqui se almacena la asignación seleccionada
                    Asignacion asignacion = matrizHorario[horarioSeleccionado.getDia()][horarioSeleccionado.getHora()];
            
                    if (asignacion.getCuposDisponibles() >= (curso.getEstudiantesAsignados() * 2)){
                        System.out.println("- Por cuestiones de acreditación no se permiten más de 2 estudiantes por computadora por lo que no se puede asignar el curso en ningún horario del lab. ");
                    }else{
                        if (asignacion.getCuposDisponibles() >= curso.getEstudiantesAsignados()) {
                            asignacion.setCuposDisponibles(asignacion.getCuposDisponibles() + 1);
                            System.out.println("¡La cantidad de estudiantes inscritos es mayor que la del laboratorio, por lo que algún estudiante compartira computadora!");
                            System.out.println("- Número de personas asignadas en el horario seleccionado: " + asignacion.getCuposDisponibles());
            
                        }else{
                            asignacion.setCuposDisponibles(asignacion.getCuposDisponibles() + 1);
                            System.out.println("- Número de personas asignadas en el horario seleccionado: " + asignacion.getCuposDisponibles());
            
                        }
                    }
    
                }else{
                    System.out.println("Indice inválido.");
                }

            }else{
                System.out.println("Indice inválido.");
            }
    
    
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }

    }

    //--------------------------------------------- MÉTODOS ACTUALIZAR UN CURSO EN UN HORARIO EN ESPECÍFICO ---------------------------------------------//
    /**
     * Método para actualizar el día y la hora de un curso.
     */
    public void actualizarHorarioCurso(){
        // Variables del método
        Scanner sc = new Scanner(System.in);

        try {
            /// se solicita la informacion al usuario para actualizar
            System.out.println();
            System.out.println("Para actualizar un curso en un horario en específico ingrese lo siguiente: ");
    
            System.out.println();
            System.out.println("Ingrese el curso: ");
            mostrarCursos();
            int indiceCurso = sc.nextInt();

            // Se valida que se ingrese un indice valido de un curso.
            ArrayList<Integer> indicesCursos = new ArrayList<Integer>();
            int sizeCursos = getCursos().size();
            for (int i = 0; i < sizeCursos; i++){
                indicesCursos.add(i);
            } 

            if (indicesCursos.contains(indiceCurso)){
                System.out.println("Ingrese el horario a actualizar: ");
                ArrayList<Integer> indicesHorarios = new ArrayList<Integer>();
                ArrayList<Horario> listaHorarios = cursos.get(indiceCurso).getListaHorarios();
                for (int i = 0; i <  listaHorarios.size(); i++) {
                    indicesHorarios.add(i);
                    System.out.println(i + ". " + "Día: " + diasSemana[listaHorarios.get(i).getDia()] + "; " + "Hora: " + horarios[listaHorarios.get(i).getHora()]);
                }
                int indiceHorario = sc.nextInt();
    
                if (indicesHorarios.contains(indiceHorario)){
                    Curso curso = cursos.get(indiceCurso);
                    Horario horarioSeleccionado = curso.getListaHorarios().get(indiceHorario);
            
                    // Seleccionar el nuevo horario
                    System.out.println("Ingrese día en el que desea asignar el curso: ");
                    mostrasDias();
                    int indiceDia = sc.nextInt();
                    
                    if (indiceDia >= 0 && indiceDia <= 4){
                        System.out.println("Seleccione una hora para asignarle al curso: ");
                        int indiceHora = 0;
                        
                        for (Integer elementoLista : horasDisponibles(indiceDia)) {
                            System.out.println(elementoLista + ". " + horarios[elementoLista]);
                        }
            
                        indiceHora = sc.nextInt();
            
                        // Se valida que se ingresen unicamente los indices indicados en consola
                        if (horasDisponibles(indiceDia).contains(indiceHora)) {
                            // Se elimina el curso de la matriz de horarios
                            matrizHorario[horarioSeleccionado.getDia()][horarioSeleccionado.getHora()] = null;
                            
                            // Se elimina el horario de la lista de horarios
                            curso.getListaHorarios().remove(indiceHorario);
                    
                            //Creación de instancias de tipo Asignación y Horario
                            Asignacion asignacion = new Asignacion(0, curso);
                            
                            Horario horario = new Horario(indiceDia, indiceHora);
                            
                            curso.agregarHorario(horario);
                    
                            matrizHorario[indiceDia][indiceHora] = asignacion;
                    
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 14; j++) {
                                    if (matrizHorario[i][j] == null){
                                        System.out.print("Vacío" + "\t"); // Utiliza tabulaciones como separadores
                                    }else{
                                        System.out.print(matrizHorario[i][j].getCurso().getNombre() + "\t"); // Utiliza tabulaciones como separadores
                                    }
                                }
                                System.out.println(); // Cambia de línea después de cada fila
                            }
                    
                            System.out.println("¡Actualización realizada exitosamente!");     
            
                        }else{
                            System.out.println("Indice inválido.");
                        }
    
                    }else{
                        System.out.println("Índice inválido.");
                    }
    
                }else{
                    System.out.println("Índice inválido.");
                }
                
            }else{
                System.out.println("Índice inválido.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }

    }

    //--------------------------------------------- MÉTODOS LIMPIAR EL HORARIO ---------------------------------------------//
    /**
     * Método que pone disponibles todos los espacios de un horario
     */
    public void limpiarHorario(){
        // Se limpia la matriz de horario
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                matrizHorario[i][j] = null;
            }
        }

        // Se limpia la lista de horarios de cada curso
        for (Curso curso : cursos) {
            curso.getListaHorarios().clear();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                if (matrizHorario[i][j] == null){
                    System.out.print("Vacío" + "\t"); // Utiliza tabulaciones como separadores
                }else{
                    System.out.print(matrizHorario[i][j].getCurso().getNombre() + "\t"); // Utiliza tabulaciones como separadores
                }
            }
            System.out.println(); // Cambia de línea después de cada fila
        }

        System.out.println("¡Horario vacío, Puede asignar sus cursos!");

    }

    //--------------------------------------------- MÉTODOS VER PROFESOR DIA HORA ---------------------------------------------//
    /**
     * Método para visualizar el profesor en un día y horario disponible.
     */
    public void verProfesorDiaHora(){
        // Variables del método
        Scanner sc = new Scanner(System.in);

        try {
            // Seleccionar el nuevo horario
            System.out.println("Ingrese día en el que desea ver al profesor del curso: ");
            mostrasDias();
            int indiceDia = sc.nextInt();

            if (indiceDia >= 0 && indiceDia <= 4){
                System.out.println("Ingrese el horario que desea saber: ");
                for (int i = 0; i < horarios.length; i++){
                    System.out.println(i + ". " + horarios[i]);
                }
                int indiceHora = sc.nextInt();

                if (indiceHora >= 0 && indiceHora <= 13){
                    // Validación para mostrar el profesor seleccionado
                    if (matrizHorario[indiceDia][indiceHora] != null){
                        System.out.println("- Profesor asignado a este horario: " + matrizHorario[indiceDia][indiceHora].getCurso().getProfesor().getNombre());
                        System.out.println("- Carné profesor: " + matrizHorario[indiceDia][indiceHora].getCurso().getProfesor().getCarne());
                        System.out.println("- Email profesor: " + matrizHorario[indiceDia][indiceHora].getCurso().getProfesor().getEmail());
                    }else{
                        System.out.println("No hay ningún profesor asignado al horario seleccionado.");
                    }
                }else{
                    System.out.println("Índice inválido.");    
                }
        

            }else{
                System.out.println("Índice inválido.");
            }
            
        
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }

    }

    //--------------------------------------------- MÉTODOS VER PROFESOR HORARIO ---------------------------------------------//
    /**
     * Método para visualizar el día y la hora que un profesor imparte clases
     */
    public void verProfesorHorario(){
        // Variables del método
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println();
            System.out.println("Para mostrar los horarios en los que un profesor imparte clases ingrese lo siguiente: ");    
            
            System.out.println();
            System.out.println("Ingrese el profesor que desea saber sus horarios: ");
            mostrarProfesores();

            int sizeProfesores = getProfesores().size();
            // Se almacena la cantidad de profesores actuales para validar indice
            ArrayList<Integer> indicesProfesores = new ArrayList<Integer>();
            for (int i = 0; i < sizeProfesores; i++){
                indicesProfesores.add(i);
            }

            int indiceProfesor = sc.nextInt();
            
            if (indicesProfesores.contains(indiceProfesor)){
                // Se almacenan las clases que da un profesor
                ArrayList<Curso> clasesProfesor = new ArrayList<Curso>();
                for (Curso curso : cursos) {
                    if (curso.getProfesor().getCarne().equals(profesores.get(indiceProfesor).getCarne()) )  {
                        clasesProfesor.add(curso);
                    }  
                }
        
                // Se muestran los horarios que da un profesor
                System.out.println("Los horarios en los que imparte clases el profesor son: ");
                for (Curso curso : clasesProfesor) {
                    System.out.println("--------- " + curso.getNombre() + " ---------");
                    for (Horario horario : curso.getListaHorarios()) {
                        System.out.println(diasSemana[horario.getDia()] + ": " + horarios[horario.getHora()]);
                    }
                }

            }else{
                System.out.println("Índice inválido.");
            }
    
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }

    }

    //--------------------------------------------- MÉTODOS VER PORCENTAJE RESPONSABILIDAD ---------------------------------------------//
    /**
     * Método para ver el porcentaje de responsabilidad de cada profesor según el número de clases que imparte semanalmente.
     */
    public void verPorcentajeResponsabilidad(){
        System.out.println();
        System.out.println("A continuación, se le muestra el porcentaje de responsabilidad de cada uno de los profesores: ");    
        
        // Se almacenan las clases que da un profesor
        double numeroVeces = 0;
        for (Profesor profesor : profesores) {
            System.out.println("-------- " + profesor.getNombre() + " --------");
            for (Curso curso : cursos) {
                if (curso.getProfesor().getCarne().equals(profesor.getCarne()) )  {
                    numeroVeces += curso.getListaHorarios().size();
                } 
            }
            System.out.println("Número de veces: " + numeroVeces);
            System.out.println("Porcenaje responsabilidad: " + (numeroVeces / 70.00)*(100) + " %");
            numeroVeces = 0;
        }
        
    }

    /**
     * Método que muestra el menú de opciones para la manipulación de un horario.
     */
    public void subMenu(){
        System.out.println();
        System.out.println("----------------OPCIONES HORARIO----------------");
        System.out.println("1. Realizar asignación ");
        System.out.println("2. Visualizar la información de un curso en un horario en específico ");
        System.out.println("3. Eliminar un curso en un horario específico ");
        System.out.println("4. Inscribir un estudiante a un horario ");
        System.out.println("5. Actualizar horario de un curso ");
        System.out.println("6. Poner disponible el laboratorio en todos los horarios ");
        System.out.println("7. Visualizar el profesor en un día y horario disponible ");
        System.out.println("8. Visualizar el día y la hora que un profesor imparte clases ");
        System.out.println("9. Visualizar el porcentaje de responsabilidad de los profesores");
        System.out.println("10. Salir ");
        System.out.println("Ingrese la opción que desea: ");
        
    }
    
}