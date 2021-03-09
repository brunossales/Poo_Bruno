import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Agencia ag = new Agencia();

        while (true) {

            String[] op = JOptionPane.showInputDialog(null, "Digite as Seguintes Opções\n"
                    + "\t'Sair' Para fechar a Agência\n" + "\t'AddCliente' Junto com o nome do cliente\n"
                    + "\t'Sacar', junto com o index da conta e o valor (Float)\n"
                    + "\t'Depositar', junto com o index da conta e o valor (Float)\n"
                    + "\t'Transferir', junto com o index do que vai transferir e o que vai receber e o valor (Float)\n"
                    + "\t'VerCliente', junto com o index(O index é contato por CC ex: '0' - '2' - '4')\n"
                    + "\t'show', para ver tudo na agencia\n"
                    + "\t'Mensal' ou 'update', para fazer os reajustes de cada mes\n").split(" ");
            try {
                if (op[0].equalsIgnoreCase("sair"))
                    break;

                else if (op[0].equalsIgnoreCase("sacar")) {
                    ag.contas.get(Integer.parseInt(op[1])).sacar(Float.parseFloat(op[2]));
                    if (ag.contas.get(Integer.parseInt(op[1])).type.equals("CC")) {
                        ag.clientes.get(Integer.parseInt(op[1])).contas.get(Integer.parseInt(op[1]))
                                .sacar(Float.parseFloat(op[2]));
                        continue;
                    }
                    ag.clientes.get(Integer.parseInt(op[1]) - 1).contas.get(Integer.parseInt(op[1]))
                            .sacar(Float.parseFloat(op[2]));
                }

                else if (op[0].equalsIgnoreCase("addCliente")) {
                    ag.adicionarCliente(op[1]);
                }

                else if (op[0].equalsIgnoreCase("Depositar")) {
                    ag.contas.get(Integer.parseInt(op[1])).depositar(Float.parseFloat(op[2]));

                    if (ag.contas.get(Integer.parseInt(op[1])).type.equals("CC")) {
                        ag.clientes.get(Integer.parseInt(op[1])).contas.get(Integer.parseInt(op[1]))
                                .depositar(Float.parseFloat(op[2]));
                        continue;
                    }
                    ag.clientes.get(Integer.parseInt(op[1]) - 1).contas.get(Integer.parseInt(op[1]))
                            .depositar(Float.parseFloat(op[2]));
                }

                else if (op[0].equalsIgnoreCase("Transferir")) {
                    Conta envia = ag.contas.get(Integer.parseInt(op[1]));
                    Conta recebe = ag.contas.get(Integer.parseInt(op[2]));
                    envia.transferir(recebe, Float.parseFloat(op[3]));
                    if (envia.type.equals("CC")) {
                        ag.clientes.get(Integer.parseInt(op[1])).contas.get(Integer.parseInt(op[1])).transferir(recebe,
                                Float.parseFloat(op[3]));
                        ag.clientes.get(Integer.parseInt(op[2])).contas.get(Integer.parseInt(op[2]))
                                .depositar(Float.parseFloat(op[3]));
                        continue;
                    }
                    ag.clientes.get(Integer.parseInt(op[1]) - 1).contas.get(Integer.parseInt(op[1])).transferir(recebe,
                            Float.parseFloat(op[3]));
                    ag.clientes.get(Integer.parseInt(op[2]) - 1).contas.get(Integer.parseInt(op[2]))
                            .depositar(Float.parseFloat(op[3]));

                }

                else if (op[0].equalsIgnoreCase("VerCliente")) {
                    JOptionPane.showMessageDialog(null, ag.clientes.get(Integer.parseInt(op[1])));
                }

                else if (op[0].equalsIgnoreCase("show")) {
                    JOptionPane.showMessageDialog(null, ag);
                }

                else if (op[0].equalsIgnoreCase("mensal") || op[0].equalsIgnoreCase("update")) {
                    ag.reaguste();
                } else
                    JOptionPane.showInternalMessageDialog(null, " ㊗ - Opção invalida");
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
