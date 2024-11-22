package br.com.ProjetoOasis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="t_mdct_contato")
@EntityListeners(AuditingEntityListener.class)
public class Contato {
    @Id
    @GeneratedValue
    @Column(name="id_contato")
    private Long idContato;

    @Column(name="nr_ddi")
    private int ddi;

    @Column(name="nr_ddd")
    private int ddd;

    @Column(name="nr_telefone")
    private Long telefone;
}
