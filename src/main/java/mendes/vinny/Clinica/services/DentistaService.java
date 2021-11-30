package mendes.vinny.Clinica.services;

import mendes.vinny.Clinica.dao.DentistaDAO;
import mendes.vinny.Clinica.model.Dentista;
import mendes.vinny.Clinica.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.log4j.Logger;

@Service
public class DentistaService {

    private static final Logger logger = Logger.getLogger(ConsultaService.class.getName());

    @Autowired
    private DentistaRepository repository;

    // CREATE
    public Dentista insert(Dentista dentista) {
        logger.info("Dentista criado");
        return repository.save(dentista);
    }
    // READ
    public List<Dentista> buscarTodos(){
        logger.info("Busca por todos os Dentistas");
        return repository.findAll();
    }
    public Dentista buscarPorID(Integer id){
        logger.info("Busca de um dentista pelo ID realizada");
        return repository.getById(id);
    }
    // UPDATE
    public Dentista edit(DentistaDAO dao){
        Dentista dentista = repository.getById(dao.getId());

        dentista.setNome(dao.getNome());
        dentista.setSobrenome(dao.getSobrenome());
        dentista.setMatricula(dao.getMatricula());

        logger.info("Dentista editado");

        repository.save(dentista);
        return dentista;
    }
    // DELETE
    public String delete(Integer id){
        repository.deleteById(id);
        logger.info("Dentista Deletado");
        return "Dentista deletado com sucesso.";
    }


}
