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
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequencia", sequenceName = "paciente_sequencia")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequencia")
    private Integer id;

    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(String nome, String sobrenome, Integer idade, String email, List<Consulta> consultas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.email = email;
        this.consultas = consultas;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
