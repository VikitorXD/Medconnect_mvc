package br.com.ProjetoOasis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="t_mdct_produto")
@EntityListeners(AuditingEntityListener.class)
public class Produto {
    @Id
    @GeneratedValue
    @Column(name="id_produto")
    private Long idProduto;

    @Column(name="nm_produto", length = 80)
    private String nome;

    @Column(name="ds_produto", length = 100)
    private String descricao;

    @Column(name="vl_produto")
    private Double valor;

    @Column(name="nm_marca")
    private String marca;
}
