import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Bilheteria bilheteria = new Bilheteria();
        while (true) {
            String[] op = JOptionPane.showInputDialog(null,
                    "Digite os seguintes comandos: \n"
                            + "'Vender', junto com o nome dos seguintes: Cliente - evento - setor\n"
                            + "'Caixa', para mostrar o dinheiro que está no caixa\n"
                            + "'showVendas', para mostrar todas as vendas até o momento\n"
                            + "'showPessoas', para mostrar as pessoas aqui neste evento\n"
                            + "'showEventos', para mostrar os eventos\n"
                            + "'addPessoa', junto com: nome - meia(inteira ou meia)\n"
                            + "'addEvento', junto com: nome do evento\n"
                            + "'addSetor', junto com: idEvento - idSetor - preco - capacidade\n"
                            + "'Sair', para encerrar a execução\n")
                    .split(" ");

            try {
                if (op[0].equalsIgnoreCase("Sair"))
                    break;

                else if (op[0].equalsIgnoreCase("Vender"))
                    bilheteria.vender(op[1], op[2], op[3]);

                else if (op[0].equalsIgnoreCase("Caixa"))
                    JOptionPane.showMessageDialog(null, bilheteria.showCaixa());

                else if (op[0].equalsIgnoreCase("showVendas"))
                    JOptionPane.showMessageDialog(null, bilheteria.showVendas());

                else if (op[0].equalsIgnoreCase("showPessoas"))
                    JOptionPane.showMessageDialog(null, bilheteria.showPessoas());

                else if (op[0].equalsIgnoreCase("showEventos"))
                    JOptionPane.showMessageDialog(null, bilheteria.showEventos());

                else if (op[0].equalsIgnoreCase("addEvento"))
                    bilheteria.addEvento(op[1]);

                else if (op[0].equalsIgnoreCase("addSetor"))
                    bilheteria.addSetor(op[1], op[2], Double.parseDouble(op[3]), Integer.parseInt(op[4]));

                else if (op[0].equalsIgnoreCase("addPessoa")) {
                    if (op[2].equalsIgnoreCase("Meia"))
                        bilheteria.addPessoa(op[1], true);
                    else
                        bilheteria.addPessoa(op[1], false);
                }

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "⛔" + e.toString());
            } catch (IndexOutOfBoundsException z) {
                JOptionPane.showMessageDialog(null, "⛔" + z.toString());
            }
        }
    }
}
