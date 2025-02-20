import java.util.List;

public interface CalendarDataInterface {

    List<Event> getUpcomingEvents();

    Event getEventDetails(int eventID);

    void updateRemainingTickets(int eventID, int newCount);
}
