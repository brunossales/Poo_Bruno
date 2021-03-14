import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Hospital controller = new Hospital();
        while (true) {
            String[] op = JOptionPane.showInputDialog(null, "Digite os seguintes comandos:\n"
                    + "\t'Sair', para encerrar a execução\n" + "\t'AddMedico', junto com o: nome - especialidade\n"
                    + "\t'AddPaciente', junto com o: nome - diagnostico\n" + "\t'RemMedico', junto com: nome\n"
                    + "\t'RemPaciente', junto com: nome\n" + "\t'Vincular', junto com: Nome_Medico - Nome_Paciente\n"
                    + "\t'showAll', para ver tudo\n" + "\t'SendMessage', id_enviando - id_recebe - mensagem\n"
                    + "\t'GetInbox', junto com: nome\n").split(" ");
            try {
                if (op[0].equalsIgnoreCase("sair"))
                    break;

                else if (op[0].equalsIgnoreCase("addmedico"))
                    controller.addMedico(new Medico(op[1], op[2]));

                else if (op[0].equalsIgnoreCase("addpaciente"))
                    controller.addPaciente(new Paciente(op[1], op[2]));

                else if (op[0].equalsIgnoreCase("RemMedico"))
                    controller.rmMedico(op[1]);

                else if (op[0].equalsIgnoreCase("RemPaciente"))
                    controller.rmPaciente(op[1]);

                else if (op[0].equalsIgnoreCase("vincular"))
                    controller.vincular(op[1], op[2]);

                else if (op[0].equalsIgnoreCase("showAll"))
                    JOptionPane.showMessageDialog(null, controller.showAll());

                else if (op[0].equalsIgnoreCase("sendMessage")) {
                    StringBuilder saida = new StringBuilder();
                    for (int i = 3; i < op.length; i++)
                        saida.append(op[i]).append(" ");

                    controller.sendMessage(op[1], op[2], new Mensagem(op[1], saida.toString()));
                }

                else if (op[0].equalsIgnoreCase("GetInbox"))
                    JOptionPane.showMessageDialog(null, controller.getInbox(op[1]));

                else
                    JOptionPane.showMessageDialog(null, "Opção invalida 🤨 ");

            } catch (NullPointerException y) {
                JOptionPane.showMessageDialog(null, y.toString() + "null cara");
            } catch (Exception z) {
                JOptionPane.showMessageDialog(null, z.toString());
            }
        }
    }
}
