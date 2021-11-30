package mendes.vinny.Clinica.services;

import mendes.vinny.Clinica.dao.PacienteDAO;
import mendes.vinny.Clinica.model.Paciente;
import mendes.vinny.Clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.log4j.Logger;

@Service
public class PacienteService {

    private static final Logger logger = Logger.getLogger(ConsultaService.class.getName());

    @Autowired
    private PacienteRepository repository;

    // CREATE
    public Paciente insert(Paciente paciente) {
        logger.info("Paciente criado");
        return repository.save(paciente);
    }
    // READ
    public List<Paciente> buscarTodos(){
        logger.info("Busca por todos os Pacientes");
        return repository.findAll();
    }
    public Paciente buscarPorID(Integer id){
        logger.info("Busca de um Paciente pelo ID realizada");
        return repository.getById(id);
    }
    // UPDATE
    public Paciente edit(PacienteDAO dao){
        Paciente paciente = repository.getById(dao.getId());

        paciente.setNome(dao.getNome());
        paciente.setSobrenome(dao.getSobrenome());
        paciente.setIdade(dao.getIdade());
        paciente.setEmail(dao.getEmail());

        logger.info("Paciente editado");

        repository.save(paciente);
        return paciente;
    }
    // DELETE
    public String delete(Integer id){
        repository.deleteById(id);
        logger.info("Paciente deletado");
        return "Paciente deletado com sucesso.";
    }

}
