import java.util.*;

public class ContatoPlus extends Contato {
    private boolean starred;

    public ContatoPlus(String id) {
        super(id);
        this.starred = false;
    }

    public ContatoPlus(String id, ArrayList<Fone> fones) {
        super(id, fones);
        this.starred = false;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    @Override
    public ArrayList<Fone> getFones() {
        return super.getFones();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public boolean isStarred() {
        return starred;
    }
}
