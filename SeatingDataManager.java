public class SeatingDataManager implements SeatingDataInterface {
    @Override
    public void retrieveSeatingArrangement() {
        System.out.println("Retrieving seating arrangement...");
    }

    @Override
    public void updateSeatStatus(int seatID, boolean isReserved) {
        //String status = isReserved ? "reserved" : "available";
        //System.out.println("Seat " + seatID + " is now " + status);
    }
}
