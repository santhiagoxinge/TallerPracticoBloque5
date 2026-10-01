import java.time.LocalDate;

/**
 * Registra una renovacion de prestamo (R11).
 *
 * Justificacion de COMPOSICION con Prestamo:
 * Una Renovacion no tiene significado fuera de su Prestamo.
 * No puede existir una renovacion sin el prestamo al que pertenece,
 * ni tiene sentido consultarla de forma independiente.
 * Si el Prestamo deja de existir, sus Renovaciones tambien.
 * Por eso la relacion es composicion, no agregacion ni asociacion.
 */
public class Renovacion {

    private LocalDate fechaRenovacion;   // cuando se realizo la renovacion
    private LocalDate fechaAnterior;     // fecha prevista que habia antes
    private LocalDate nuevaFecha;        // nueva fecha prevista de devolucion

    public Renovacion(
            LocalDate fechaRenovacion,
            LocalDate fechaAnterior,
            LocalDate nuevaFecha) {

        this.fechaRenovacion = fechaRenovacion;
        this.fechaAnterior   = fechaAnterior;
        this.nuevaFecha      = nuevaFecha;
    }

    public LocalDate getFechaRenovacion() { return fechaRenovacion; }
    public LocalDate getFechaAnterior()   { return fechaAnterior; }
    public LocalDate getNuevaFecha()      { return nuevaFecha; }

    @Override
    public String toString() {
        return "Renovacion["
            + "realizada=" + fechaRenovacion
            + ", fechaAnterior=" + fechaAnterior
            + ", nuevaFecha=" + nuevaFecha
            + "]";
    }
}
