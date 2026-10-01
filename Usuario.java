/**
 * Superclase abstracta que representa cualquier usuario del sistema SmartLibrary.
 * Es abstracta porque un "Usuario generico" no tiene sentido en el dominio:
 * siempre sera un Estudiante o un Bibliotecario especifico.
 *
 * Justificacion de la herencia:
 * - Estudiante ES-UN Usuario: tiene identificacion, nombre y correo,
 *   mas atributos propios (codigoEstudiantil, programaAcademico).
 * - Bibliotecario ES-UN Usuario: misma base, mas atributos propios
 *   (codigoEmpleado, turno).
 * - La generalizacion NO es solo para evitar repetir atributos:
 *   refleja una abstraccion real del sistema (R12).
 */
public abstract class Usuario {

    private String identificacion;
    private String nombre;
    private String correo;

    public Usuario(String identificacion, String nombre, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getIdentificacion() { return identificacion; }
    public String getNombre()         { return nombre; }
    public String getCorreo()         { return correo; }
}
