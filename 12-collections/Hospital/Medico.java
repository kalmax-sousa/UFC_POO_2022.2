class Medico implements IMedico{
    String sender;
    String classe;
    TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    public Medico(String sender, String classe);
    public String getId();
    public void addPaciente(IPaciente paciente);
    public void removerPaciente(String idPaciente);
    public Collection<IPaciente> getPacientes();
    public String getClasse();
    public String toString();
}