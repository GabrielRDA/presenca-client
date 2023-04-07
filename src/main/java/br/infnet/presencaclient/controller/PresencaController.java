package br.infnet.presencaclient.controller;

import br.infnet.presencaclient.model.Presenca;
import br.infnet.presencaclient.services.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class PresencaController {

    @Autowired
    PresencaService presencaService;

    @PostMapping("marcarPresenca")
    public ResponseEntity<Map<String, Object>> marcarPresenca(@RequestParam String nomeProf, String nomeAluno){
        Presenca presenca = new Presenca(nomeProf,nomeAluno,"Presente","-");
        presencaService.salvarPresenca(presenca);
        System.out.println("Presença marcada para o aluno: " + nomeAluno);
        return ResponseEntity.ok(Map.of("Presenca",presenca));
    }

    @PostMapping("marcarAusencia")
    public ResponseEntity<Map<String, Object>> marcarAusencia(@RequestParam String nomeProf, String nomeAluno, String motivo){
        Presenca presenca = new Presenca(nomeProf,nomeAluno,"Ausente",motivo);
        presencaService.salvarPresenca(presenca);
        System.out.println("Ausencia Marcada para o aluno:" + nomeAluno);
        return ResponseEntity.ok(Map.of("Presenca",presenca));
    }

    @PostMapping("marcarAtraso")
    public ResponseEntity<Map<String, Object>> marcarAtraso(@RequestParam String nomeProf, String nomeAluno, String motivo){
        Presenca presenca = new Presenca(nomeProf,nomeAluno,"Atrasado",motivo);
        presencaService.salvarPresenca(presenca);
        System.out.println("Atraso Marcado para o aluno:" + nomeAluno);
        return ResponseEntity.ok(Map.of("Presenca",presenca));
    }

    @GetMapping("procurarPresencaPorProf")
    public ResponseEntity<Map<String, Object>> procurarListaPresencaPorProf(@RequestParam String nomeProf){
        List<Presenca> listPresenca = presencaService.getByNomeProf(nomeProf);
        if(listPresenca.isEmpty()){
            return ResponseEntity.ok(Map.of("Message:","Não existe nenhuma presença lançada por esse professor: " + nomeProf));
        }
        return ResponseEntity.ok(Map.of("Presenças",listPresenca));
    }
}

