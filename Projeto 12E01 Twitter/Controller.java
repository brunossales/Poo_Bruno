import java.util.*;
import javax.swing.JOptionPane;

public class Controller {
    private Map<String, User> users;
    private Map<Integer, Tweet> tweets;
    private int nextTwId;

    private Map<String, User> followers;
    private Map<String, User> following;

    private ArrayList<Tweet> timelineNot = new ArrayList<>();
    private int unreadCount;

    Controller() {
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();

        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
        this.nextTwId = 0;
    }

    public void sendTweet(String username, String msg) {
        if (!this.users.containsKey(username))
            throw new Exce(username);

        tweets.put(nextTwId, new Tweet(username, msg));
        users.get(username).timelinee(nextTwId, new Tweet(username, msg));
        timelineNot.add(new Tweet(username, msg));
        unreadCount++;
        nextTwId++;
    }

    public void addUser(String username) {
        if (this.users.containsKey(username))
            throw new Exce1(username);

        users.put(username, new User(username));
    }

    public void like(int index, String username) {
        if (!users.containsKey(username))
            throw new Exce(username);
        tweets.get(index).likes(username);
        users.get(tweets.get(index).getUserName()).likeDoTimeline(index, username);
    }

    public void follow(User us, User us1) {
        if (!users.containsKey(us1.getUsername())) {
            throw new Exce(us1.getUsername());
        }
        if (!users.containsKey(us.getUsername())) {
            throw new Exce(us.getUsername());
        }
        following.put(us.getUsername(), us1);
        followers.put(us1.getUsername(), us);
    }

    public void showTimeLine(String username) {
        if (!users.containsKey(username))
            throw new Exce(username);

        JOptionPane.showMessageDialog(null, users.get(username).showTimeline());
    }

    public void unfollow(User us1) {
        if (!this.followers.containsKey(us1.getUsername()))
            throw new Exce1(us1.getUsername());

        if (!this.following.containsKey(us1.getUsername()))
            throw new Exce1(us1.getUsername());

        following.remove(us1.getUsername());
        followers.remove(us1.getUsername());

    }

    public Tweet getTweet(int idTw) {
        if (idTw > tweets.size())
            throw new Exce("Tweeter");
        return tweets.get(idTw);
    }

    public void unread() {
        JOptionPane.showMessageDialog(null, timelineNot);
        timelineNot.clear();
        unreadCount = 0;
    }

    public void showTweets() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, User> auxUs : users.entrySet()) {
            saida.append(auxUs.getKey()).append("\n\t").append(auxUs.getValue().showTimeline()).append("\n");
        }
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, User> aux : users.entrySet()) {
            saida.append(aux.getKey()).append("\n \t").append("  SEGUINDO  [").append(following.get(aux.getKey()))
                    .append(" ]").append("\n \t").append("  SEGUIDORES [ ").append(followers.get(aux.getKey()))
                    .append(" ]").append("\n");
        }
        return saida.toString();
    }

    public Map<String, User> getFollowers() {
        return followers;
    }

    public Map<String, User> getFollowing() {
        return following;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public ArrayList<Tweet> getTimelineNot() {
        return timelineNot;
    }

    public int getNextTwId() {
        return nextTwId;
    }

    public Map<Integer, Tweet> getTweets() {
        return tweets;
    }

    public Map<String, User> getUsers() {
        return users;
    }

}
