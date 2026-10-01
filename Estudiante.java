/**
 * Estudiante ES-UN Usuario que ademas implementa Notificable.
 *
 * Justificacion de Notificable en Estudiante:
 * R13 dice que "algunos usuarios pueden recibir notificaciones".
 * En este modelo el Estudiante es quien recibe avisos de renovaciones,
 * vencimientos y disponibilidad de reservas. El Bibliotecario
 * gestiona el sistema pero no recibe notificaciones automaticas
 * (su flujo es operativo, no de aviso).
 */
public class Estudiante extends Usuario implements Notificable {

    private String codigoEstudiantil;
    private String programaAcademico;

    public Estudiante(
            String identificacion,
            String nombre,
            String correo,
            String codigoEstudiantil,
            String programaAcademico) {

        // Llama al constructor de Usuario con los atributos compartidos
        super(identificacion, nombre, correo);
        this.codigoEstudiantil = codigoEstudiantil;
        this.programaAcademico = programaAcademico;
    }

    public String getCodigoEstudiantil() { return codigoEstudiantil; }
    public String getProgramaAcademico() { return programaAcademico; }

    @Override
    public void notificar(String mensaje) {
        System.out.println("[NOTIFICACION para " + getNombre() + "] " + mensaje);
    }
}
