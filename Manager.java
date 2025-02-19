public class Manager extends VenueStaff implements ManagerInterface {
    public Manager(String name, int staffID) {
        super(name, staffID, "Manager");
    }

    @Override
    public void processRefund() {
        System.out.println("Processing refund...");
    }

    @Override
    public void updateTicketSales() {
        System.out.println("Updating ticket sales...");
    }

    @Override
    public void modifySeatingConfig() {
        System.out.println("Modifying seating configuration...");
    }

    @Override
    public void addShow() {
        System.out.println("Adding a new show...");
    }

    @Override
    public void addSeats() {
        System.out.println("Adding seats...");
    }

    @Override
    public void removeShows() {
        System.out.println("Removing a show...");
    }

    @Override
    public void removeSeats() {
        System.out.println("Removing seats...");
    }

    @Override
    public void holdSeats() {
        System.out.println("Holding seats...");
    }

    @Override
    public void markSeatAsRestricted() {
        System.out.println("Marking a seat as restricted...");
    }

    @Override
    public void changeSeatPrice() {
        System.out.println("Changing seat price...");
    }
}