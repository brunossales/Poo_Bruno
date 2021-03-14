public class Mensagem {
    String sender;
    String text;

    public Mensagem(String sender, String text) {
        this.sender = sender;
        this.text = text;

    }

    @Override
    public String toString() {
        return sender + " : " + text;
    }
}
