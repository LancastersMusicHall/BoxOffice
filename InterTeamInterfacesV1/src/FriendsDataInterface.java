import java.util.List;

public interface FriendsDataInterface {

    List<Friend> getPriorityHolders();

    void holdSeatsForFriend(int friendID, int eventID);
}
