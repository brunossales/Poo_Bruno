import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.*;

import java.awt.*;

//Classe com o intuito de treino e estudo
//Classe com o intuito de treino e estudo
//Classe com o intuito de treino e estudo
//Classe com o intuito de treino e estudo
public class Teste extends JFrame {
    public Teste() {
        setSize(new Dimension(600, 600));
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        setCursor(new Cursor(HAND_CURSOR));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Vini bicha");
            }
        });
        t.start();
        new Teste();
    }
}
