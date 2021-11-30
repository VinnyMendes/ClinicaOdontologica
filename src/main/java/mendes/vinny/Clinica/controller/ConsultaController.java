package mendes.vinny.Clinica.controller;

import mendes.vinny.Clinica.dao.ConsultaDAO;
import mendes.vinny.Clinica.model.Consulta;
import mendes.vinny.Clinica.services.ConsultaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    private static final Logger logger = Logger.getLogger(ConsultaService.class.getName());

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<Consulta> postConsulta(@RequestBody ConsultaDAO dao){

        try {
            return ResponseEntity.ok(service.insert(dao));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getConsultaPorPaciente(){
        try {
            return ResponseEntity.ok(service.buscarConsultas());
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaByID(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarPorID(id));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Consulta> putConsulta(@RequestBody ConsultaDAO dao){
        try {
            return ResponseEntity.ok(service.edit(dao));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsulta(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.delete(id));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
