import java.util.List;

//Defines methods to access "Friends of Lancaster" data.
//Managed by Marketing team; provides priority access information to Box Office team.

public interface FriendsDataInterface {
    
    //Retrieves list of priority holders (friends) who have priority access to tickets and seats.
    List<Friend> getPriorityHolders();
    
    //Holds seats for a friend for an event.
    void holdSeatsForFriend(int friendID, int eventID);
}
