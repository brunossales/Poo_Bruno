import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

public class Medico implements IMedico, IBatePapense {
    private String id;
    private String especi;
    private Collection<IPaciente> pacientes;
    private List<Mensagem> Inbox;

    @Override
    public String getEspecialidade() {
        return this.especi;
    }

    public IPaciente getPaciente(String paciente) {
        for (IPaciente ob : pacientes) {
            if (ob.getId().equals(paciente))
                return ob;
        }
        return null;
    }

    public Medico(String name, String especialidade) {
        this.id = name;
        this.especi = especialidade;
        this.pacientes = new ArrayList<>();
        this.Inbox = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("Med: ").append(id).append(":").append(especi).append(" Pacs: [");
        for (IPaciente obj : pacientes) {
            saida.append(obj.getId() + " ");
        }
        saida.append("]");
        return saida.toString();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void addPaciente(IPaciente paciente) throws Exception {
        if (pacientes.contains(paciente)) {
            throw new Exception("Paciente já existe aqui!!!");
        }
        pacientes.add(paciente);
    }

    @Override
    public void removerPaciente(String idPaciente) throws Exception {
        IPaciente aux = getPaciente(idPaciente);
        if (aux == null) {
            throw new Exception("Paciente não existe!!");
        }
        pacientes.remove(aux);
    }

    @Override
    public Collection<IPaciente> getPacientes() {
        return this.pacientes;
    }

    @Override
    public void sendMessage(Mensagem msg, IBatePapense batePapense) {
        batePapense.addMessage(msg);
    }

    @Override
    public void addMessage(Mensagem msg) {
        this.Inbox.add(msg);

    }

    @Override
    public List<Mensagem> getInbox() {
        List<Mensagem> aux = new ArrayList<>(this.Inbox);
        this.Inbox.clear();
        return aux;
    }

}
