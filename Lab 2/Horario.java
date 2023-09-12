public class Horario {
    // Atributos de clase

    // Atributo que almacena el día que se imparte en un curso
    private int dia;

    // Atributo que almacena la hora que se imparte en un curso
    private int hora;

    /**
     * 
     * @param dia párametro que almacena el día que se imparte en un curso
     * @param hora parámetro que almacena la hora en la que se imparte un curso
     */
    public Horario(int dia, int hora) {
        this.dia = dia;
        this.hora = hora;
    }

    /**
     * 
     * @return Este método permite obtener el día en el cual el curso se impartirá.
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Este método recibe el día en el que se impartirá el curso y lo almacena en el atributo correspondiente.
     * 
     * @param dia parámetro del día a establecer
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Este método permite obtener la hora en la cual el curso se imparte.
     * @return
     */
    public int getHora() {
        return this.hora;
    }

    /**
     * Este método recibe la hora en el que se impartirá el curso y lo almacena en el atributo correspondiente.
     * 
     * @param hora parámetro que recibe la hora en la que se impartirá un curso.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }
    
    // Método que permite obtener la información de un objeto de tipo Horario.
    @Override
    public String toString() {
        return "{" +
            " dia='" + getDia() + "'" +
            ", hora='" + getHora() + "'" +
            "}";
    }

}
