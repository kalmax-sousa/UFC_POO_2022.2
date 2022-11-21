class Paciente implements IPaciente {
    protected String sender;
    protected String diagnostico;
    protected TreeMap<String, IMedico> medicos = new TreeMap<>();
    public Paciente(String sender, String diagnostico);
    public String getId();
    public void addMedico(IMedico medico);
    public void removerMedico(String idMedico);
    public Collection<IMedico> getMedicos();
    public String getDiagnostico();
    public String toString();
}