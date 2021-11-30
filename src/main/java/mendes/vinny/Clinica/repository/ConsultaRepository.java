package mendes.vinny.Clinica.repository;

import mendes.vinny.Clinica.model.Consulta;
import mendes.vinny.Clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
