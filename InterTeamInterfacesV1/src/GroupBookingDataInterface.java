import java.util.List;

//Defines methods to manage group booking data.
//Managed by Marketing team; prevents seats held for group bookings from being sold.

public interface GroupBookingDataInterface {
    
    //Retrieves information for specific group booking.
    GroupBooking getGroupBookingInfo(int groupBookingID);
    
    //Retrieves list of group bookings (held seats) for an event.
    List<GroupBooking> getHeldSeats(int eventID);
    
    //Cancels group booking.
    void cancelGroupBooking(int groupBookingID, int customerID);
    
    //Releases any group bookings that are expired.
    void releaseExpiredHoldings();
}
