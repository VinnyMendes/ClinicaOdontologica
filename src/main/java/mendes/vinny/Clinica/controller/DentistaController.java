package mendes.vinny.Clinica.controller;

import mendes.vinny.Clinica.dao.DentistaDAO;
import mendes.vinny.Clinica.model.Dentista;
import mendes.vinny.Clinica.services.ConsultaService;
import mendes.vinny.Clinica.services.DentistaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentista")
public class DentistaController {

    private static final Logger logger = Logger.getLogger(ConsultaService.class.getName());

    @Autowired
    private DentistaService service;

    @PostMapping
    public ResponseEntity<Dentista> postDentista(@RequestBody Dentista dentista){
        try {
            return ResponseEntity.ok(service.insert(dentista));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentista(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.delete(id));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dentista>> getDentistas(){
        try {
            return ResponseEntity.ok(service.buscarTodos());
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> getDentistaByID(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(service.buscarPorID(id));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Dentista> putDentista(@RequestBody DentistaDAO dao){
        try {
            return ResponseEntity.ok(service.edit(dao));
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }
}