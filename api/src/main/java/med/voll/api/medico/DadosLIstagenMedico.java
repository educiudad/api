package med.voll.api.medico;

public record DadosLIstagenMedico(String nome,String email,  String crm, Especialidade especialidade) {

    public DadosLIstagenMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
