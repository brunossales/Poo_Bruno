import java.util.*;

public class Hospital {
    private Map<String, Paciente> pacientes;
    private Map<String, Medico> medicos;

    public Hospital() {
        this.medicos = new TreeMap<>();
        this.pacientes = new TreeMap<>();
    }

    public Map<String, Paciente> getPacientes() {
        return pacientes;
    }

    public Map<String, Medico> getMedicos() {
        return medicos;
    }

    public void addPaciente(Paciente paciente) throws Exception {
        if (this.pacientes.containsKey(paciente.getId()))
            throw new Exception("Já existe este paciente aqui man, confia!!");

        pacientes.put(paciente.getId(), paciente);
    }

    public void addMedico(Medico med) throws Exception {
        if (this.medicos.containsKey(med.getId()))
            throw new Exception("Este médico já está aqui!!");

        medicos.put(med.getId(), med);
    }

    public void rmMedico(String med) throws Exception {
        if (!this.medicos.containsKey(med))
            throw new Exception("Médico não está aqui!!");

        medicos.remove(med);
    }

    public void rmPaciente(String idPaciente) throws Exception {
        if (!this.pacientes.containsKey(idPaciente))
            throw new Exception("Paciente não está aqui");

        pacientes.remove(idPaciente);
    }

    public void vincular(String NomeMedico, String NomePaciente) throws Exception {
        if (!this.pacientes.containsKey(NomePaciente))
            throw new Exception("Paciente não existe!!");

        if (!this.medicos.containsKey(NomeMedico))
            throw new Exception("Médico não existe!!");

        this.pacientes.get(NomePaciente).addMedico(this.medicos.get(NomeMedico));
        this.medicos.get(NomeMedico).addPaciente(this.pacientes.get(NomePaciente));
    }

    public String showAll() {
        StringBuilder saida = new StringBuilder();
        for (Map.Entry<String, Paciente> aux : pacientes.entrySet()) {
            saida.append(aux.getValue()).append("\n");
        }
        for (Map.Entry<String, Medico> aux : medicos.entrySet()) {
            saida.append(aux.getValue()).append("\n");
        }
        return saida.toString();
    }

    public void sendMessage(String sender, String receiver, Mensagem msg) throws Exception {
        if (this.medicos.containsKey(sender)) {
            if (!this.pacientes.containsKey(receiver))
                throw new Exception("Médico até que existe, mas esse paciente ai não!!");

            this.medicos.get(sender).sendMessage(msg, this.pacientes.get(receiver));
            return;
        } else if (this.pacientes.containsKey(sender)) {
            if (!this.medicos.containsKey(receiver))
                throw new Exception("Paciente até que existe, mas o médico ai não!!");

            this.pacientes.get(sender).sendMessage(msg, this.medicos.get(receiver));
            return;
        }
        throw new Exception("Não tem é nenhum dos dois");

    }

    public List<Mensagem> getInbox(String id) {
        if (this.medicos.containsKey(id))
            return this.medicos.get(id).getInbox();
        else if (this.pacientes.containsKey(id))
            return this.pacientes.get(id).getInbox();

        return null;
    }
}
