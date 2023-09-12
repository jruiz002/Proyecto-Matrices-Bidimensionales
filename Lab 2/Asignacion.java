public class Asignacion {
    // Atributo que almacena la cantidad de cupos disponibles en el laboratorio en un horario en específico.
    private int cuposDisponibles;
    // Atributo que almacena el curso a asignar.
    private Curso curso;

    /**
     * Método constructor que permite la creación de un objeto de tipo Asignación.
     * 
     * @param cuposDisponibles parámetro que almacena la cantidad de cupos disponibles en el laboratorio en un horario en específico.
     * @param curso parámetro que almacena el curso a asignar.
     */
    public Asignacion(int cuposDisponibles, Curso curso) {
        this.cuposDisponibles = cuposDisponibles;
        this.curso = curso;
    }

    /**
     * 
     * @return Método que devuelve el número de cupos de disponibles para un laboratorio en un horario es específico.
     */
    public int getCuposDisponibles() {
        return this.cuposDisponibles;
    }

    /**
     * Método que recibe el número de cupos disponibles para el laboratorio en un horario y lo almacena en el atributo correspondiente.
     * 
     * @param cuposDisponibles parámetro que almacena la cantidad de cupos disponibles en el laboratorio en un horario en específico.
     */
    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    /**
     * 
     * @return Método que devuelve el curso el cual se asignará al horario.
     */
    public Curso getCurso() {
        return this.curso;
    }

    /**
     * Método que recibe el curso para el laboratorio en un horario y lo almacena en el atributo correspondiente.
     * 
     * @param curso parámetro que almacena el curso a asignar.
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Método para mostrar información de un objeto de tipo Asignación
    @Override
    public String toString() {
        return "{" +
            " cuposDisponibles='" + getCuposDisponibles() + "'" +
            ", curso='" + getCurso() + "'" +
            "}";
    }

}