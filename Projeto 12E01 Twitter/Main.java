import java.util.*;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Controller us = new Controller();
        while (true) {
            String[] op = JOptionPane.showInputDialog(null,
                    "Digite as seguintes Opções para: \n" + "\t'addUser' junto com o 'nome'\n"
                            + "\t'follow' junto com o nome de quem vai seguir e quem vai ser seguido\n'"
                            + "\t'unfollow' junto com o nome de quem vai deixar de seguir\n"
                            + "\t'getTweet' junto com o número da mensagem do tweet para ver\n"
                            + "\t'sendTweet' junto com o nome e a mensagem do tweet\n"
                            + "\t'unread' para ver os twitters novos\n"
                            + "\t'Like' junto com o index do Tw e o nome de quem está dando like\n"
                            + "\t'ShowTimeline' junto com o nome \n" + "\t'Show' para mostrar a situação atual\n"
                            + "\t'Exit' para encerrar a execução\n")
                    .split(" ");
            try {

                if (op[0].equalsIgnoreCase("Exit"))
                    break;

                else if (op[0].equalsIgnoreCase("follow")) {
                    us.follow(new User(op[1]), new User(op[2]));
                }

                else if (op[0].equalsIgnoreCase("adduser")) {
                    us.addUser(op[1]);
                }

                else if (op[0].equalsIgnoreCase("getTweet")) {
                    us.getTweet(Integer.parseInt(op[1]));
                }

                else if (op[0].equalsIgnoreCase("sendTweet")) {
                    StringBuilder saida = new StringBuilder();
                    for (int i = 2; i < op.length; i++)
                        saida.append(op[i]);

                    us.sendTweet(op[1], saida.toString());
                }

                else if (op[0].equalsIgnoreCase("showTimeline")) {
                    us.showTimeLine(op[1]);
                }

                else if (op[0].equalsIgnoreCase("unread")) {
                    us.unread();
                }

                else if (op[0].equalsIgnoreCase("like")) {
                    us.like(Integer.parseInt(op[1]), op[2]);
                }

                else if (op[0].equalsIgnoreCase("show")) {
                    JOptionPane.showMessageDialog(null, us);
                }

            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
