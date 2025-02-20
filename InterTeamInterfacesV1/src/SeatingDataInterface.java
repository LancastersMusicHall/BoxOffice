import java.util.List;

public interface SeatingDataInterface {

    Seat getSeatInfo(int seatID);

    List<Seat> getSeatingArrangement(int hallID);

    void markSeatAsRestricted(int seatID);

    void updateSeatAccessibility(int seatID, boolean isAccessible);
}
