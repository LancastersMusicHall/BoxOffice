// Kept same as yours except the last method
public interface SeatingData {
    int getSeatNumber();
    int updateSeatStatus(int seatID, boolean isReserved);
    int handleSpecialisedSet(int seatID);
}
