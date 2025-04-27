public class GroupBookingData implements GroupBookingInterface {
    @Override
    public void reserveGroupSeats(int groupID, int[] seatIDs) {
        System.out.println("Reserving seats for Group ID: " + groupID);
    }

    @Override
    public void validateGroupBooking(int groupID) {
        System.out.println("Validating group booking for Group ID: " + groupID);
    }
}