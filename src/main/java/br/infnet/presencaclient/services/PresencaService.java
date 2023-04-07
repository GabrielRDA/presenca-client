package br.infnet.presencaclient.services;

import br.infnet.presencaclient.model.Presenca;
import br.infnet.presencaclient.repository.PresencaRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresencaService {
    @Autowired
    PresencaRepository presencaRepository;

    public Optional<Presenca> getById(Long id){
        return presencaRepository.findById(id);
    }
    @Timed(value = "salvando_presenca", description = "Verficando o tempo de execução para a função salvarPresenca()")
    public void salvarPresenca(Presenca presenca){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        presencaRepository.save(presenca);
    }

    @Counted(value = "buscando_prof", description = "Verficando a quantidade de chamdas da função getByNomeProf()")
    public List<Presenca> getByNomeProf(String nomeProf){
        return presencaRepository.findAllByNomeProf(nomeProf);
    }

}
