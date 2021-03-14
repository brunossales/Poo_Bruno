import java.util.*;

interface IPaciente {

    public String getId();

    public String getDiagnostico();

    public void addMedico(IMedico medico) throws Exception;

    public void removerMedico(String idMedico) throws Exception;

    public Collection<IMedico> getMedicos();

}