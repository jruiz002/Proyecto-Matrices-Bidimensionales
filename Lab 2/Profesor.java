public class Profesor {
    // Atributo que almacena el nombre del profesor
    private String nombre;
    
    // Atributo que almacena el carné del profesor.
    private String carne;

    // Atributo que almacena el email de un profesor.
    private String email;

    // Atributo que almacena el teléfono de un profesor.
    private String telefono;

    /**
     * 
     * @param nombre parámetro que almacena el nombre del profesor
     * @param carne parámetro que almacena el carné del profesor.
     * @param email parámetro que almacena el email de un profesor.
     * @param telefono parámetro que almacena el teléfono de un profesor.
     */
    public Profesor(String nombre, String carne, String email, String telefono) {
        this.nombre = nombre;
        this.carne = carne;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * 
     * @return Método que devuelve el nombre del profesor.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que recibe el nombre del profesor y lo almacena en el atributo correspondiente.
     * 
     * @param nombre parámetro que almacena el nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return Método que devuelve el carné del profesor.
     */
    public String getCarne() {
        return this.carne;
    }

    /**
     * Método que recibe el carné del profesor y lo almacena en el atributo correspondiente.
     * 
     * @param carne parámetro que almacena el carné del profesor.
     */
    public void setCarne(String carne) {
        this.carne = carne;
    }

    /**
     * 
     * @return Método que devuelve el email del profesor.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Método que recibe el correo del profesor y lo almacena en el atributo correspondiente.
     * 
     * @param email parámetro que almacena el email de un profesor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return Método que devuelve el teléfono del curso.
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     *  Método que recibe el teléfono del profesor y lo almacena en el atributo correspondiente.
     * 
     * @param telefono parámetro que almacena el teléfono de un profesor.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método que permite obtener la información de un objeto de tipo Profesor.
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", carne='" + getCarne() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }

}
