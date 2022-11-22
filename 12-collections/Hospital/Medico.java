import java.util.TreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class Medico implements IMedico{
    protected String sender;
    protected String classe;
    protected Map<String, IPaciente> pacientes = new TreeMap<>();

    public Medico(String sender, String classe){
        this.sender = sender;
        this.classe = classe;
    }

    public String getId(){
        return this.sender;
    }

    public void addPaciente(IPaciente paciente){
        this.pacientes.put(paciente.getId(), paciente);
    }

    public void removerPaciente(String idPaciente){
        this.pacientes.remove(idPaciente);
    }

    public Collection<IPaciente> getPacientes(){
        ArrayList<IPaciente> list = new ArrayList<IPaciente>();
        for(String id : this.pacientes.keySet()){
            list.add(this.pacientes.get(id));
        }
        
        return list;
    }

    public String getClasse(){
        return this.classe;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        String pc = "";
        Iterator<Map.Entry<String, IPaciente>> it = pacientes.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, IPaciente> entry = it.next(); 
            pc += entry.getValue().getId();
            
            if(it.hasNext()){
                pc += ", ";
            }
        }
        
        String name = this.sender + ":" + this.classe;
        sb.append(String.format("Med: %-16s Pacs: [%s]\n", name, pc));

        return sb.toString();
    }
}