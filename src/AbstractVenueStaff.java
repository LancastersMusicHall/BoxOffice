
public abstract class AbstractVenueStaff {
    private final String name;
    private final int staffIDNumber;
    private final String role;

    public AbstractVenueStaff(String name, int staffIDNumber, String role) {
        this.name = name;
        this.staffIDNumber = staffIDNumber;
        this.role = role;
    }

    public abstract void login();
    public abstract void logout();
}

