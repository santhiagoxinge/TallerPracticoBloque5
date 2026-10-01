/**
 * Contrato de comportamiento para objetos que pueden recibir notificaciones.
 * Una interfaz NO especifica COMO se notifica, solo GARANTIZA que
 * cualquier clase que la implemente tendra el metodo notificar().
 * Esto permite tratar a Estudiante (y cualquier futuro Notificable)
 * de forma uniforme sin importar su tipo concreto.
 */
public interface Notificable {
    void notificar(String mensaje);
}
