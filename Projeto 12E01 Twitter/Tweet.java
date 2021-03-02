import java.util.TreeSet;

class Tweet {
    private int idTw;
    private String userName;
    private String msg;
    private TreeSet<String> likes = new TreeSet<>();

    public void likes(String username) {
        likes.add(username);
    }

    Tweet(String userName, String msg) {
        this.userName = userName;
        this.msg = msg;
        this.idTw++;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(idTw).append(":").append(userName).append("(").append(msg).append(")").append("[ ").append(likes)
                .append("]");
        return saida.toString();
    }

    public String getMsg() {
        return msg;
    }

    public int getIdTw() {
        return idTw;
    }

    public TreeSet<String> getLikes() {
        return likes;
    }

    public String getUserName() {
        return userName;
    }
}