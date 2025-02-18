public class VenueStaffManager implements ManagerInterface {
    @Override
    public void login() {
        System.out.println("Manager logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Manager logged out.");
    }

    @Override
    public void processRefund() {
        System.out.println("Processing refund...");
    }

    @Override
    public void updateTicketSales() {
        System.out.println("Updating ticket sales records...");
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
        System.out.println("Adding new seats...");
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
        System.out.println("Holding seats for special guests...");
    }

    @Override
    public void markSeatAsRestricted() {
        System.out.println("Marking seat as restricted...");
    }

    @Override
    public void changeSeatPrice() {
        System.out.println("Changing seat price...");
    }
}
