import java.util.List;

public interface GroupBookingDataInterface {

    GroupBooking getGroupBookingInfo(int groupBookingID);

    List<GroupBooking> getHeldSeats(int eventID);

    void cancelGroupBooking(int groupBookingID, int customerID);

    void releaseExpiredHoldings();
}
