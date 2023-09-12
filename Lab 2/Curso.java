import java.util.ArrayList;

public class Curso {
    // Atributo permite almacenar el código del curso.
    private String codigo;

    // Atributo permite almacenar el nombre del curso.
    private String nombre;

    // Atributo almacena la cantidad de periodos que se imparte el curso por semana.
    private int cantidadPeriodos;

    // Esta será una lista de tipo horario que almacenará el día y la hora en la que se imparte un horario.
    private ArrayList<Horario> listaHorarios;

    // Atributo que almacena la cantidad de estudiantes asignado.
    private int estudiantesAsignados;

    // Atributo que almacena un objeto de tipo profesor que indica el profesor asignado a ese curso.
    private Profesor profesor;

    /**
     * 
     * @param codigo parámetro que almacena el código del curso.
     * @param nombre parámetro que almacena el nombre del curso.
     * @param estudiantesAsignados parámetro que almacena la cantidad de estudiantes asignado.
     * @param profesor parámetro que almacena un objeto de tipo profesor que indica el profesor asignado a ese curso.
     */
    public Curso(String codigo, String nombre, int estudiantesAsignados, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadPeriodos = 0;
        this.listaHorarios = new ArrayList<Horario>();
        this.estudiantesAsignados = estudiantesAsignados;
        this.profesor = profesor;
    }

    /**
     * 
     * @return Permite obtener el código del curso.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Método que recibe el código del curso y lo almacena en el atributo correspondiente.
     * 
     * @param codigo parámetro que almacena el código del curso.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * 
     * @return Método que devuelve el nombre del curso.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que recibe el nombre del curso y lo almacena en el atributo correspondiente.
     * 
     * @param nombre parámetro que almacena el nombre del curso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return Método que permite obtener la cantidad de periodos que se imparte el curso a la semana.
     */
    public int getCantidadPeriodos() {
        return this.cantidadPeriodos;
    }

    /**
     * Método que recibe la cantidad de periodos que se imparte el curso y lo almacena en el atributo correspondiente.
     * 
     * @param cantidadPeriodos parámetro que almacena la cantidad de periodos impartidos semanalmente
     */
    public void setCantidadPeriodos(int cantidadPeriodos) {
        this.cantidadPeriodos = cantidadPeriodos;
    }

    /**
     * 
     * @return Permite obtener la lista de los horarios en la que se imparte el curso.
     */
    public ArrayList<Horario> getListaHorarios() {
        return this.listaHorarios;
    }

    /**
     * Método que recibe la lista de horarios del curso y lo almacena en el atributo correspondiente. 
     * 
     * @param listaHorarios parámetro que almacena la lista de horarios
     */
    public void setListaHorarios(ArrayList<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    /**
     * 
     * @return Permite obtener la cantidad de estudiantes asignados al curso.
     */
    public int getEstudiantesAsignados() {
        return this.estudiantesAsignados;
    }

    /**
     * Método que recibe el número de estudiantes del curso y lo almacena en el atributo correspondiente.
     * 
     * @param estudiantesAsignados parámetro que almacena la cantidad de estudiantes asignado.
     */
    public void setEstudiantesAsignados(int estudiantesAsignados) {
        this.estudiantesAsignados = estudiantesAsignados;
    }

    /**
     * 
     * @return Método que devuelve un profesor
     */
    public Profesor getProfesor() {
        return this.profesor;
    }

    /**
     * 
     * @param profesor parámetro que almacena un objeto de tipo profesor que indica el profesor asignado a ese curso.
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Método que recibe un horario a agregar a lista de horarios
     * 
     * @param horario parámetro que almacena el horario a asignar
     */
    public void agregarHorario(Horario horario){
        listaHorarios.add(horario);
    }

    // Método que permite obtener la información de un objeto de tipo Curso.
    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", cantidadPeriodos='" + getCantidadPeriodos() + "'" +
            ", listaHorarios='" + getListaHorarios() + "'" +
            ", estudiantesAsignados='" + getEstudiantesAsignados() + "'" +
            ", profesor='" + getProfesor() + "'" +
            "}";
    }


}
