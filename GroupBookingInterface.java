public interface GroupBookingInterface {
    void reserveGroupSeats(int groupID, int[] seatIDs);
    void validateGroupBooking(int groupID);
}
