public class Exce extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Exce(String id) {
        super(id + " Não existe");
    }
}
