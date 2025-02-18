public class VenueStaffImplement extends AbstractVenueStaff {

    public VenueStaffImplement(String name, int staffIDNumber, String role) {
        super(name, staffIDNumber, role);
    }
    
    //Methods from abstract class have been overriden - method body is to be done over the course of the project
    @Override
    public void login() {
        // Simple output message as a method placeholder
        System.out.println("VenueStaff logged in (VenueStaffImplement class).");
    }

    @Override
    public void logout() {
        // Simple output message as a method placeholder
        System.out.println("VenueStaff logged out (VenueStaffImplement class).");
    }
}
