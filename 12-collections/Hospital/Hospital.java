import java.util.TreeMap;

class Hospital {
    private TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    private TreeMap<String, IMedico> medicos = new TreeMap<>();

    public Hospital(){}

    public void removerPaciente(String sender){
        this.pacientes.remove(sender);
    }

    public void removerMedico(String sender){
        this.medicos.remove(sender);
    }

    public void addPaciente(IPaciente paciente){
        this.pacientes.put(paciente.getId(), paciente);
    }

    public void addMedico(IMedico medico){
        this.medicos.put(medico.getId(), medico);
    }
    
    public void vincular(String nomeMedico, String nomePaciente){
        IMedico m = medicos.get(nomeMedico);
        IPaciente p = pacientes.get(nomePaciente);
        if(m.getPacientes().contains(p)){
            System.out.println("fail: paciente já cadastrado");
            return;
        }
        
        for(IMedico med : p.getMedicos()){
            if(med.getClasse().equals(m.getClasse())){
                System.out.println("fail: ja existe outro medico da especialidade " + med.getClasse());
                return;
            }
        }
        
        m.addPaciente(p);
        p.addMedico(m);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String id : this.pacientes.keySet()){
            sb.append(this.pacientes.get(id));
        }
        for(String id : this.medicos.keySet()){
            sb.append(this.medicos.get(id));
        }

        return sb.toString();
    }
}