import java.util.List;

//Defines the methods for accessing and updating calendar data. 
//Data managed by the Operations team and used by the Box Office team for ticket sales.

public interface CalendarDataInterface {

    //Retrieves list of upcoming events.
    List<Event> getUpcomingEvents();

    //Retrieves an event details.
    Event getEventDetails(int eventID);
    
    //Updates remaining ticket count for an event.
    void updateRemainingTickets(int eventID, int newCount);
}
