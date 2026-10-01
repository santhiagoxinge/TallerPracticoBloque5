/**
 * Representa una copia fisica de un Libro con codigo unico (R06).
 * Controla su propio estado de disponibilidad.
 */
public class Ejemplar {

    private String codigo;
    private boolean disponible;

    public Ejemplar(String codigo) {
        this.codigo = codigo;
        this.disponible = true;
    }

    public String getCodigo()        { return codigo; }
    public boolean estaDisponible()  { return disponible; }

    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException(
                "El ejemplar " + codigo + " no esta disponible para prestamo"
            );
        }
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }
}
