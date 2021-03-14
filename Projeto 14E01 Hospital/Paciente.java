import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

public class Paciente implements IPaciente, IBatePapense {
    private String id;
    private String diagnostico;
    private Collection<IMedico> Medicos;
    private List<Mensagem> Inbox;

    public Paciente(String id, String diag) {
        this.id = id;
        this.diagnostico = diag;
        this.Medicos = new ArrayList<>();
        this.Inbox = new ArrayList<>();
    }

    public IMedico getmed(String especialidade) {
        for (IMedico obj : Medicos) {
            if (obj.getEspecialidade().equals(especialidade))
                return obj;
        }
        return null;
    }

    public IMedico getNome(String id) {
        for (IMedico obj : Medicos) {
            if (obj.getId().equals(id))
                return obj;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("Pac: ").append(id).append(":").append(diagnostico).append(" Meds: [");
        for (IMedico obj : Medicos) {
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
    public void addMedico(IMedico medico) throws Exception {
        IMedico aux = getmed(medico.getEspecialidade());
        if (aux != null)
            throw new Exception("Já existe médico com essa especialidade aqui mah!!!");

        Medicos.add(medico);
    }

    @Override
    public void removerMedico(String idMedico) throws Exception {
        IMedico aux = getNome(idMedico);
        if (aux == null)
            throw new Exception("Não existe este médico");

        Medicos.remove(aux);
    }

    @Override
    public Collection<IMedico> getMedicos() {
        return this.Medicos;
    }

    @Override
    public String getDiagnostico() {
        return this.diagnostico;
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
