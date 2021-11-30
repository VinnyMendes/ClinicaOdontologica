package mendes.vinny.Clinica.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta {

    @Id
    @SequenceGenerator(name = "consulta_sequencia", sequenceName = "consulta_sequencia")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_sequencia")
    private Integer id;

    private String data;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(String data, String hora, Dentista dentista, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
