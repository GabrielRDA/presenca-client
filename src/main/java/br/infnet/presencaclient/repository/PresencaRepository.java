package br.infnet.presencaclient.repository;

import br.infnet.presencaclient.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
    List<Presenca> findAllByNomeProf(String nomeProf);
}
