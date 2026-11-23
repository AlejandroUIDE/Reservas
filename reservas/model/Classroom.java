package reservas.model;

public class Classroom implements Reservable {
    @Override
    public int maxHours() {
        return 4;
    }
}
