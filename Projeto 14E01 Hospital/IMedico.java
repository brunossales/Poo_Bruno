import java.util.*;

interface IMedico {

    public String getId();

    public String getEspecialidade();

    public void addPaciente(IPaciente paciente) throws Exception;

    public void removerPaciente(String idPaciente) throws Exception;

    public Collection<IPaciente> getPacientes();
}