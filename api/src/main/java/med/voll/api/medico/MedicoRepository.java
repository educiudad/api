package med.voll.api.medico;
import org.springframework.data.domain.Page;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
