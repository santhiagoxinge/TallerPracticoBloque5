import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Prestamo {

    private Estudiante estudiante;
    private Ejemplar   ejemplar;

    private LocalDate fechaPrestamo;
    private LocalDate fechaPrevistaDevolucion;
    private LocalDate fechaRealDevolucion;    // null mientras no se devuelva

    // Composicion: Prestamo es dueno del ciclo de vida de sus Renovaciones
    private List<Renovacion> renovaciones = new ArrayList<>();

    
    public Prestamo(
            Estudiante estudiante,
            Ejemplar   ejemplar,
            LocalDate  fechaPrestamo,
            LocalDate  fechaPrevistaDevolucion) {

        this.estudiante              = estudiante;
        this.ejemplar                = ejemplar;
        this.fechaPrestamo           = fechaPrestamo;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
        this.fechaRealDevolucion     = null;

        // El ejemplar pasa a no disponible al momento del prestamo
        this.ejemplar.prestar();
    }

    
    public void renovar(LocalDate nuevaFecha) {
        // Paso 1: validar que la nueva fecha sea posterior a la vigente
        if (!nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "La nueva fecha de devolucion (" + nuevaFecha
                + ") debe ser posterior a la fecha prevista vigente ("
                + fechaPrevistaDevolucion + ")"
            );
        }

        // Paso 2: crear la Renovacion con los datos actuales
        Renovacion r = new Renovacion(
            LocalDate.now(),          // fecha en que se realiza la renovacion
            fechaPrevistaDevolucion,  // fecha anterior
            nuevaFecha                // nueva fecha
        );

        // Paso 3: almacenar en el historial
        renovaciones.add(r);

        // Paso 4: actualizar la fecha prevista
        fechaPrevistaDevolucion = nuevaFecha;
    }

    /**
     * Devuelve true si el ejemplar no ha sido devuelto
     * y la fecha actual supera la fecha prevista (R08).
     */
    public boolean estaVencido(LocalDate hoy) {
        return fechaRealDevolucion == null
            && hoy.isAfter(fechaPrevistaDevolucion);
    }

    /**
     * Registra la devolucion real del ejemplar (R09).
     * Valida que la fecha no sea anterior al prestamo.
     */
    public void registrarDevolucion(LocalDate fecha) {
        if (fecha.isBefore(fechaPrestamo)) {
            throw new IllegalArgumentException(
                "La fecha de devolucion no puede ser anterior a la fecha del prestamo"
            );
        }
        this.fechaRealDevolucion = fecha;
        this.ejemplar.devolver();
    }

    // Getters
    public Estudiante       getEstudiante()             { return estudiante; }
    public Ejemplar         getEjemplar()               { return ejemplar; }
    public LocalDate        getFechaPrestamo()           { return fechaPrestamo; }
    public LocalDate        getFechaPrevistaDevolucion() { return fechaPrevistaDevolucion; }
    public LocalDate        getFechaRealDevolucion()     { return fechaRealDevolucion; }
    public List<Renovacion> getRenovaciones()            { return renovaciones; }
}
