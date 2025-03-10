public interface GroupBooking {
    boolean checkGroupSize(int groupID);
    boolean isSeatGroupReserved(int seatID);
    void reserveGroupSeats(int groupID, int[] seatID);
}
