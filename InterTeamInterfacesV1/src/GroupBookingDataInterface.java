import java.util.List;

public interface GroupBookingDataInterface {

    List<GroupBooking> getHeldSeats(int eventID);

    void cancelGroupBooking(int groupBookingID, int customerID);

    void releaseExpiredHoldings();
}
