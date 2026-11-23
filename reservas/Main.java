package reservas;

import reservas.model.Classroom;
import reservas.model.Lab;
import reservas.model.Reservable;
import reservas.service.ReservationService;
import reservas.ui.ConsoleInput;
import reservas.ui.ConsoleView;

public class Main {
    private static final ConsoleInput input = new ConsoleInput();
    private static final ConsoleView view = new ConsoleView();
    private static final ReservationService service = new ReservationService();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            view.showMenu();
            Integer option = input.readInt("Seleccione una opción: ");
            if (option == null) {
                view.showMessage("Entrada no válida: ingrese un número.");
            } else if (option == 1) {
                registerReservation();
            } else if (option == 2) {
                showSummary();
            } else if (option == 3) {
                view.showMessage("Hasta luego.");
                running = false;
            } else {
                view.showMessage("Opción inválida. Elija 1, 2 o 3.");
            }
        }
    }

    private static void registerReservation() {
        view.showSpaceTypes();
        Integer type = input.readInt("Tipo: ");
        if (type == null || (type != 1 && type != 2)) {
            view.showMessage("Tipo de espacio inválido. Reserva no registrada.");
            return;
        }
        Reservable space = (type == 1) ? new Classroom() : new Lab();

        Integer hours = input.readInt("Horas solicitadas: ");
        if (hours == null) {
            view.showMessage("Entrada no válida: ingrese un número entero. Reserva no registrada.");
            return;
        }

        int approved = service.register(space, hours);
        if (approved == 0) {
            view.showMessage("Reserva rechazada: las horas deben ser mayores que cero.");
        } else {
            view.showApproved(approved);
        }
    }

    private static void showSummary() {
        if (service.getValidReservations() == 0) {
            view.showMessage("Aún no hay registros.");
            return;
        }
        view.showSummary(service.getValidReservations(),
                service.getTotalApprovedHours(), service.averageHours());
    }
}
