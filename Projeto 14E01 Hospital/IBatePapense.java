import java.util.List;

interface IBatePapense {
	String getId();

	void sendMessage(Mensagem msg, IBatePapense batePapense);

	void addMessage(Mensagem msg);

	List<Mensagem> getInbox();
}