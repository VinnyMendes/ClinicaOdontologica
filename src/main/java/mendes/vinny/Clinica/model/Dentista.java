package mendes.vinny.Clinica.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "consultas"})
public class Dentista {

    @Id
    @SequenceGenerator(name = "dentista_sequencia", sequenceName = "dentista_sequencia")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentista_sequencia")
    private Integer id;

    private String matricula;
    private String nome;
    private String sobrenome;

    @OneToMany(mappedBy = "dentista")
    private List<Consulta> consultas = new ArrayList<>();

    public Dentista() {
    }

    public Dentista(String matricula, String nome, String sobrenome, List<Consulta> consultas) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.consultas = consultas;
    }

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
