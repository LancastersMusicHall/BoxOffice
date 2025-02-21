import java.util.List;

//Defines methods for accessing and updating seating data.
//Seating configurations are managed by the Operations team and reviewed by the Box Office team.

public interface SeatingDataInterface {
    
    //Retrieves information for a seat.
    Seat getSeatInfo(int seatID);
    
    //Retrieves seating arrangement for a hall.
    List<Seat> getSeatingArrangement(int hallID);
    
    //Marks seat as having a restricted view.
    void markSeatAsRestricted(int seatID);
    
    //Updates the accessibility status of a seat.
    void updateSeatAccessibility(int seatID, boolean isAccessible);
}
