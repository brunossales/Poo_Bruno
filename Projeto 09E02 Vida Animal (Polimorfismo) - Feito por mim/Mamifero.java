import javax.swing.JOptionPane;

public class Mamifero extends Animal implements Cor {

    @Override
    public void emitirSom() {
        JOptionPane.showMessageDialog(null, "Som de mamíferooo");
    }

    @Override
    public void comer(int i) {
        if (i > 10) {
            JOptionPane.showMessageDialog(null, "Muitos litros de leite para um mamifero cara");
        } else {
            JOptionPane.showMessageDialog(null, "Mamifero lindo mamando a vista...");
        }
    }

    public String corPelo() {
        return "Pode ser diversas Cores";
    }

}
