import java.util.*;

public class User {
    private String username;
    private Map<Integer, Tweet> timeline = new TreeMap<>();

    public String getUsername() {
        return username;
    }

    public Map<Integer, Tweet> getTimeline() {
        return timeline;
    }

    public void timelinee(int id, Tweet tw) {
        this.timeline.put(id, tw);
    }

    public void likeDoTimeline(int id, String username) {
        this.timeline.get(id).likes(username);
    }

    public String showTimeline() {
        StringBuilder saida = new StringBuilder();

        for (Map.Entry<Integer, Tweet> aux : timeline.entrySet()) {
            saida.append(aux.getKey()).append(":").append(aux.getValue().getUserName()).append(" (")
                    .append(aux.getValue().getMsg()).append(" )").append(aux.getValue().getLikes()).append("\n");
        }
        return saida.toString();
    }

    public String toString() {
        return username;
    }

    User(String id) {
        this.username = id;
    }

}
