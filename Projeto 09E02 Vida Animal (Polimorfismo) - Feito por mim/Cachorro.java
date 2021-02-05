import javax.swing.JOptionPane;

public class Cachorro extends Lobo implements Cor {
    @Override
    public void emitirSom() {
        JOptionPane.showMessageDialog(null, "Som de cachorro ne man");
    }

    @Override
    public void comer(int i) {
        if (i > 4) {
            JOptionPane.showMessageDialog(null,
                    "Com cachorro, as coisas e diferente, tente dar 2 litros de leite ou menos");
        } else {
            JOptionPane.showMessageDialog(null, "cachorro lindo mamando a vista...");
        }
    }

    public void reagir(String frase) {
        if (frase.equalsIgnoreCase("Ola") || frase.equalsIgnoreCase("Vem") || frase.equalsIgnoreCase("Comida?")) {
            JOptionPane.showMessageDialog(null, "O cachorro está indo na sua direção e abanando o raboo");
        } else {
            JOptionPane.showMessageDialog(null, "Cachorro rosnando porque nao sabe o que voce esta falando");
        }
    }

    public void reagir(boolean dono) {
        if (dono) {
            JOptionPane.showMessageDialog(null, "Abanando o rabo e indo na sua direção");
        } else
            JOptionPane.showMessageDialog(null, "Latindo para voce, voce nao e o dono dele");
    }

    public void reagir(int idade, float peso) {
        if (idade < 5) {
            if (peso > 10) {
                JOptionPane.showMessageDialog(null, "Cachorro ta meio gordo pra idade dele, kkk");
            } else {
                JOptionPane.showMessageDialog(null, "Vem com o rabinho abando o magrinho lindo");
            }
        } else {
            if (peso < 10) {
                JOptionPane.showMessageDialog(null, "Ta lindo, no peso bom e vem com o rabinho abanando");
            } else {
                JOptionPane.showMessageDialog(null, "Ta meio gordo, mas vem com o rabinho abanando");
            }
        }
    }

    public void ver() {
        JOptionPane.showMessageDialog(null,
                "Você pode: \n" + "falar 'Ola', 'vem ca' ou 'quer comida? isso em frases\n"
                        + "Dizer se você é o dono ou não com true ou false\n"
                        + "Digitar a idade em inteiro e o peso em float\n");

        JOptionPane.showMessageDialog(null, "Lembrando que para entrar nas interações você tem que digitar:\n"
                + "Interação por fras: Digite 'frase'\n" + "Interação por dono: Digite 'dono' \n"
                + "Interação por caracteristica: Digite 'Caracteristica'\n"
                + "\t LEMBRANDO QUE DEPOIS DA PALAVRA CHAVE VOCE DIGITA O OS COMANDOS DITOS NA JANELA ANTERIOR");
    }

    public String corPelo() {
        return "Branco, preto, amarelo";
    }
}
