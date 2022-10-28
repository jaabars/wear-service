package kg.itschoolmegacom.wearservice.repository;

import kg.itschoolmegacom.wearservice.models.entities.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepo extends JpaRepository<Dress, Long> {

  List<Dress> findAllByAvailableIs(boolean available);
}
