public class VenueStaff extends AbstractVenueStaff implements VenueStaffInterface {
    public VenueStaff(String name, int staffID, String role) {
        this.name = name;
        this.staffID = staffID;
        this.role = role;
    }

    @Override
    public void login() {
        System.out.println(name + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println(name + " logged out.");
    }
}