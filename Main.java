import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SmartLibrary - Bloque 5 ===\n");

        // ── Crear objetos base ───────────────────────────────────────────────
        Estudiante estudiante = new Estudiante(
            "926222",
            "Santiago Parra",
            "santiago@universidad.edu",
            "EST-2024-001",
            "Ingenieria de Software"
        );

        Bibliotecario bibliotecario = new Bibliotecario(
            "BIB-001",
            "Carlos Ruiz",
            "carlos@biblioteca.edu",
            "EMP-045",
            "Manana"
        );

        Ejemplar ejemplar = new Ejemplar("EJ-001");

        // ── Crear prestamo ───────────────────────────────────────────────────
        Prestamo prestamo = new Prestamo(
            estudiante,
            ejemplar,
            LocalDate.of(2026, 9, 1),
            LocalDate.of(2026, 9, 15)
        );

        System.out.println("Prestamo creado para: " + estudiante.getNombre());
        System.out.println("Ejemplar disponible despues del prestamo: "
            + ejemplar.estaDisponible());  // false
        System.out.println("Fecha prevista de devolucion inicial: "
            + prestamo.getFechaPrevistaDevolucion());

        // ── PRUEBA 1: Renovacion valida ──────────────────────────────────────
        System.out.println("\n--- PRUEBA 1: Renovacion valida ---");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 15));

            System.out.println("Prestamo renovado exitosamente.");
            System.out.println("Nueva fecha de devolucion: "
                + prestamo.getFechaPrevistaDevolucion());
            System.out.println("Cantidad de renovaciones: "
                + prestamo.getRenovaciones().size());
            System.out.println("Detalle: "
                + prestamo.getRenovaciones().get(0));

            // Notificar al estudiante via contrato Notificable
            estudiante.notificar("Su prestamo del ejemplar "
                + ejemplar.getCodigo()
                + " fue renovado hasta "
                + prestamo.getFechaPrevistaDevolucion());

        } catch (IllegalArgumentException e) {
            System.out.println("Error en renovacion: " + e.getMessage());
        }

        // ── PRUEBA 2: Renovacion invalida ────────────────────────────────────
        System.out.println("\n--- PRUEBA 2: Renovacion invalida ---");
        System.out.println("Intento: renovar con fecha 2026-09-20");
        System.out.println("(fecha prevista vigente: "
            + prestamo.getFechaPrevistaDevolucion() + ")");
        try {
            // Fecha anterior a la vigente: debe lanzar excepcion
            prestamo.renovar(LocalDate.of(2026, 9, 20));
            System.out.println("Renovacion aceptada (no deberia llegar aqui).");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
            System.out.println("El objeto Prestamo queda intacto. Renovaciones: "
                + prestamo.getRenovaciones().size());
        }

        // ── PRUEBA 3: Bibliotecario no es Notificable ────────────────────────
        System.out.println("\n--- PRUEBA 3: Verificacion de herencia y roles ---");
        System.out.println("Estudiante es Usuario: " + (estudiante instanceof Usuario));
        System.out.println("Estudiante es Notificable: " + (estudiante instanceof Notificable));
        System.out.println("Bibliotecario es Usuario: " + (bibliotecario instanceof Usuario));
        System.out.println("Bibliotecario es Notificable: " + (bibliotecario instanceof Notificable));

        // ── PRUEBA 4: Devolucion y ejemplar disponible ───────────────────────
        System.out.println("\n--- PRUEBA 4: Devolucion del ejemplar ---");
        prestamo.registrarDevolucion(LocalDate.of(2026, 10, 10));
        System.out.println("Ejemplar disponible despues de devolver: "
            + ejemplar.estaDisponible());  // true
        estudiante.notificar("Devolucion del ejemplar "
            + ejemplar.getCodigo() + " registrada correctamente.");
    }
}
