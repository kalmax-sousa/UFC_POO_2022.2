class Hospital {
    private TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    private TreeMap<String, IMedico> medicos = new TreeMap<>();
    public Hospital();
    public void removerPaciente(String sender);
    public void removerMedico(String sender);
    public void addPaciente(IPaciente paciente);
    public void addMedico(IMedico medico);
    public void vincular(String nomeMedico, String nomePaciente);
    public String toString();
}