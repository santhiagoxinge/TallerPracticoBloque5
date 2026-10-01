/**
 * Bibliotecario ES-UN Usuario con atributos propios de su rol operativo.
 *
 * Justificacion de NO implementar Notificable:
 * R13 dice "algunos usuarios pueden recibir notificaciones", no todos.
 * El Bibliotecario opera activamente el sistema: aprueba prestamos,
 * registra devoluciones y consulta disponibilidad. No necesita recibir
 * notificaciones automaticas porque su flujo es de consulta activa,
 * no de aviso pasivo. Forzarlo a implementar Notificable seria
 * agregar un contrato sin requisito que lo justifique.
 */
public class Bibliotecario extends Usuario {

    private String codigoEmpleado;
    private String turno;

    public Bibliotecario(
            String identificacion,
            String nombre,
            String correo,
            String codigoEmpleado,
            String turno) {

        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public String getTurno()          { return turno; }
}
