public class SeatingData implements SeatingDataInterface {
    @Override
    public void retrieveSeatingArrangement() {
        System.out.println("Retrieving seating arrangement...");
    }

    @Override
    public void updateSeatStatus(int seatID, boolean isReserved) {
        System.out.println("Updating seat " + seatID + " to reserved: " + isReserved);
    }
}