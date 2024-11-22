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
@Table(name="t_mdct_cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @SequenceGenerator(name = "cliente", sequenceName = "seq_mi_cliente", allocationSize = 1)
    @Column(name="id_cliente")
    private Long idCliente;

    @Column(name="nm_cliente")
    private String nome;

    @Column(name="nr_cpf")
    private Long cpf;

    @Column(name="nm_rg")
    private String rg;

    @Column(name="ds_email", length = 80)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_cliente", referencedColumnName = "id_endereco_cliente")
    private Endereco endereco;
}
