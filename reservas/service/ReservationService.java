package reservas.service;

import reservas.model.Reservable;

public class ReservationService {
    private int validReservations = 0;
    private int totalApprovedHours = 0;

    // Devuelve las horas aprobadas; 0 si la reserva se rechaza.
    public int approvedHours(Reservable space, int requested) {
        if (requested <= 0) {
            return 0;
        }
        return Math.min(requested, space.maxHours());
    }

    // Registra la reserva solo si es válida y devuelve las horas aprobadas.
    public int register(Reservable space, int requested) {
        int approved = approvedHours(space, requested);
        if (approved > 0) {
            validReservations++;
            totalApprovedHours += approved;
        }
        return approved;
    }

    public int getValidReservations() {
        return validReservations;
    }

    public int getTotalApprovedHours() {
        return totalApprovedHours;
    }

    // Solo debe llamarse si hay al menos una reserva válida.
    public double averageHours() {
        return (double) totalApprovedHours / validReservations;
    }
}
