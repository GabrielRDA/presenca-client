package br.infnet.presencaclient.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Presenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeProf")
    private String nomeProf;

    private String nomeAluno;

    private String statusAluno;

    private String motivo;

    public Presenca(String nomeProf, String nomeAluno, String statusAluno, String motivo){
        this.nomeProf = nomeProf;
        this.nomeAluno = nomeAluno;
        this.statusAluno = statusAluno;
        this.motivo = motivo;
    }
}
