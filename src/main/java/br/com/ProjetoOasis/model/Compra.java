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
@Table(name="t_mdct_compra")
@EntityListeners(AuditingEntityListener.class)
public class Compra {
    @Id
    @GeneratedValue
    @Column(name="id_compra")
    private Long idCompra;

    @Column(name="qt_compra")
    private Integer quantidade;

    @Column(name="vl_compra")
    private Double valor;

    @Column(name="end_entrega", length = 100)
    private String enderecoEntrega;

}
