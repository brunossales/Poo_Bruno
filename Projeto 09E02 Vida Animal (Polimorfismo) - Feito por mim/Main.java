import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Mamifero m = new Mamifero();
        Lobo l = new Lobo();
        Cachorro c = new Cachorro();
        while (true) {
            try {
                String[] op = JOptionPane.showInputDialog(null,
                        "Digite o seguintes comandos: \n"
                                + "'Mamifero', depois com 'EmitirSom' para ver o som que os mamiferos fazem\n"
                                + "'Mamifero', junto com o o numero de litros de leite que você quer alimentalo\n"
                                + "'Lobo', depois com 'EmitirSom' para ver o som que os lobos fazem\n"
                                + "'Lobo', depois o número de litros de leite que quer alimenta-lo\n"
                                + "'Cachorro', depois com 'EmitirSom' para ver o som que os cachorrom fazem\n"
                                + "'Cachorro', depois o número de litros de leite que voce quer amamentar o cachorro\n"
                                + "Para aprender as interações com o cachorro digite 'verInter'\n"
                                + "Interagir, junto com o tipo de interação que você quer com o cachorro\n"
                                + "Cor, junto com a cor do pelo de cada tipo de animal que você quer conhecer\n"
                                + "'sair', para encerrar a execução")
                        .split(" ");

                if (op[0].equalsIgnoreCase("sair")) {
                    break;
                }

                else if (op[0].equalsIgnoreCase("mamifero")) {
                    if (op[1].equalsIgnoreCase("EmitirSom")) {
                        m.emitirSom();
                    } else
                        m.comer(Integer.parseInt(op[1]));
                }

                else if (op[0].equalsIgnoreCase("lobo")) {
                    if (op[1].equalsIgnoreCase("emitirsom")) {
                        l.emitirSom();
                    } else
                        l.comer(Integer.parseInt(op[1]));
                }

                else if (op[0].equalsIgnoreCase("cachorro")) {
                    if (op[1].equalsIgnoreCase("emitirsom")) {
                        c.emitirSom();
                    } else
                        c.comer(Integer.parseInt(op[1]));
                } else if (op[0].equalsIgnoreCase("Interagir")) {
                    if (op[1].equalsIgnoreCase("frase"))
                        c.reagir(op[2]);

                    if (op[1].equalsIgnoreCase("dono"))
                        c.reagir(Boolean.parseBoolean(op[2]));

                    if (op[1].equalsIgnoreCase("caracteristica"))
                        c.reagir(Integer.parseInt(op[2]), Float.parseFloat(op[3]));

                } else if (op[0].equalsIgnoreCase("verInter")) {
                    c.ver();
                } else if (op[0].equalsIgnoreCase("cor")) {
                    if (op[1].equalsIgnoreCase("Mamifero"))
                        JOptionPane.showMessageDialog(null, m.corPelo());

                    else if (op[1].equalsIgnoreCase("lobo"))
                        JOptionPane.showMessageDialog(null, l.corPelo());

                    else if (op[1].equalsIgnoreCase("cachorro"))
                        JOptionPane.showMessageDialog(null, c.corPelo());

                }
            } catch (ArrayIndexOutOfBoundsException z) {
                JOptionPane.showMessageDialog(null, "Problema nos arrays");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error de index");
            } catch (RuntimeErrorException y) {
                JOptionPane.showMessageDialog(null, "Escolheu alguma coisa errada ai man");
            }
        }
    }
}
