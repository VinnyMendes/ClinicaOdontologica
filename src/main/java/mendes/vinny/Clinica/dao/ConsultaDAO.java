package mendes.vinny.Clinica.dao;

public class ConsultaDAO {

    private Integer id;
    private String data;
    private String hora;
    private Integer dentistaId;
    private Integer pacienteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Integer dentistaId) {
        this.dentistaId = dentistaId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }
}
