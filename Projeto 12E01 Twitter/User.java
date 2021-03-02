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

    public String showTimeline() {
        StringBuilder saida = new StringBuilder();

        for (Map.Entry<Integer, Tweet> aux : timeline.entrySet()) {
            saida.append(aux.getKey()).append(":").append(aux.getValue().getUserName()).append(aux.getValue().getMsg());
        }
        return saida.toString();
    }

    User(String id) {
        this.username = id;
    }

}
