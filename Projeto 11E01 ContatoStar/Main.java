import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        AgendaPlus agendaPlus = new AgendaPlus();
        while (true) {
            String[] op = JOptionPane.showInputDialog(null, "Digite os seguintes comandos:\n"
                    + "Sair, para encerrar a execução\n"
                    + "AddContato, junto com o nome e a lista de Contatos. ex: oi:4002  tim:5503\n"
                    + "Favoritar, junto com o nome, para favoritar o contato\n"
                    + "Unstar ou desfavoritar, junto com o nome para desfavoritar o contato, deixa-lo como normal\n"
                    + "RmContato, junto com o nome, para remover o contato do celular\n"
                    + "MostrarCon, junto o nome, para mostrar o contato de acordo com o nome\n"
                    + "Pattern, junto com a substring para procurar o contato ou fone \n"
                    + "ProcurarBookMark ou ProcurarFavorito, junto com o nome para procurar na lista de favoritos\n"
                    + "RmFone, junto com o nome e o index do fone, para removelo do contato\n"
                    + "Mostrar ou Show, para mostrar todos os contatos").split(" ");
            try {
                if (op[0].equalsIgnoreCase("sair"))
                    break;

                else if (op[0].equalsIgnoreCase("addcontato")) {
                    ArrayList<Fone> fones = new ArrayList<>();
                    for (int i = 2; i < op.length; i++) {
                        System.out.println(op);
                        String operadora = op[i].split(":")[0];
                        String numero = op[i].split(":")[1];
                        fones.add(new Fone(operadora, numero));
                    }
                    agendaPlus.addContato(op[1], fones);
                }

                else if (op[0].equalsIgnoreCase("Favoritar"))
                    agendaPlus.bookmark(op[1]);

                else if (op[0].equalsIgnoreCase("Pattern"))
                    agendaPlus.search(op[1]);

                else if (op[0].equalsIgnoreCase("Unstar") || op[0].equalsIgnoreCase("desfavoritar"))
                    agendaPlus.unbookmark(op[1]);

                else if (op[0].equalsIgnoreCase("RmContato"))
                    agendaPlus.rmContato(op[1]);

                else if (op[0].equalsIgnoreCase("MostrarCon"))
                    JOptionPane.showMessageDialog(null, agenda.getContatos(op[1]));

                else if (op[0].equalsIgnoreCase("procurarbookmark") || op[0].equalsIgnoreCase("procurarfavorito"))
                    JOptionPane.showMessageDialog(null, agendaPlus.searchBookmark(op[1]));

                else if (op[0].equalsIgnoreCase("RmFone"))
                    agendaPlus.rmFoneC(op[1], Integer.parseInt(op[2]));

                else if (op[0].equalsIgnoreCase("mostrar") || op[0].equalsIgnoreCase("show"))
                    JOptionPane.showMessageDialog(null, agendaPlus);

                try {
                    JOptionPane.showMessageDialog(null, "Essa executação foi concluida, aperte OK e continue");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (ArrayIndexOutOfBoundsException w) {
                w.printStackTrace();
                JOptionPane.showMessageDialog(null, "Problema noss Arrays");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            } catch (IndexOutOfBoundsException z) {
                JOptionPane.showMessageDialog(null, z.toString());
            }
        }
    }
}
