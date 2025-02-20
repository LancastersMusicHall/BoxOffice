import java.util.List;

public interface SeatingDataInterface {

    List<Seat> getSeatingArrangement(int hallID);

    void markSeatAsRestricted(int seatID);

    void updateSeatAccessibility(int seatID, boolean isAccessible);
}
