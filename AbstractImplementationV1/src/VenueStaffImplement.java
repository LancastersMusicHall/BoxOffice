public class VenueStaffImplement extends AbstractVenueStaff {

    public VenueStaffImplement(String name, int staffIDNumber, String role) {
        super(name, staffIDNumber, role);
    }

    @Override
    public void login() {
        // Simple output message as a method placeholder
        System.out.println("VenueStaff " + "logged in (VenueStaffImplement).");
    }

    @Override
    public void logout() {
        // Simple output message as a method placeholder
        System.out.println("VenueStaff " + "logged out (VenueStaffImplement).");
    }
}
