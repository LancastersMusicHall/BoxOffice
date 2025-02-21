import java.util.List;

//Provides methods to access "Friends of Lancaster" data.
//Managed by the Marketing team; provides priority access information to the Box Office team.

public interface FriendsDataInterface {
    
    //Retrieves list of priority holders (friends) who have priority access to tickets and seats.
    List<Friend> getPriorityHolders();
    
    //Holds seats for a friend for an event.
    void holdSeatsForFriend(int friendID, int eventID);
}
