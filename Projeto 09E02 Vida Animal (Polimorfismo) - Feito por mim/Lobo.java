import javax.swing.JOptionPane;

public class Lobo extends Mamifero implements Cor {

    @Override
    public void emitirSom() {
        JOptionPane.showMessageDialog(null, "Auuuuu!");
    }

    @Override
    public void comer(int i) {
        if (i > 4) {
            JOptionPane.showMessageDialog(null,
                    "Com lobo, as coisas e diferente, tente dar 4 litros de leite ou menos");
        } else {
            JOptionPane.showMessageDialog(null, "Lobo lindo mamando a vista...");
        }
    }

    public String corPelo() {
        return "Branco ou marrom";
    }
}
