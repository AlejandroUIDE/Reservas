package reservas.model;

public class Lab implements Reservable {
    @Override
    public int maxHours() {
        return 2;
    }
}
