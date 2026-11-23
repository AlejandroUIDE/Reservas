package reservas.ui;

import java.util.Locale;

public class ConsoleView {
    public void showMenu() {
        System.out.println(" ====================");
        System.out.println(" CONTROL DE RESERVAS ");
        System.out.println(" ====================");
        System.out.println("1. Registrar reserva");
        System.out.println("2. Consultar resumen");
        System.out.println("3. Salir");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showSpaceTypes() {
        System.out.println("Tipo de espacio: 1. Aula  2. Laboratorio");
    }

    public void showApproved(int hours) {
        System.out.println("Reserva aprobada: " + hours + " hora(s).");
    }

    public void showSummary(int reservations, int totalHours, double average) {
        System.out.println("--- Resumen ---");
        System.out.println("Reservas válidas: " + reservations);
        System.out.println("Total de horas aprobadas: " + totalHours);
        System.out.println(String.format(Locale.forLanguageTag("es-CO"),
                "Promedio de horas por reserva: %.1f", average));
    }
}
