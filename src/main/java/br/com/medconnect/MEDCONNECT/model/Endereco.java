package br.com.medconnect.MEDCONNECT.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="t_mdct_endereco_cliente")
@EntityListeners(AuditingEntityListener.class)
public class Endereco {
    @Id
    @GeneratedValue
    @Column(name="id_endereco_cliente")
    private Long idEnderecoCliente;

    @Column(name="nr_logradouro")
    private int numeroLogradouro;

    @Column(name="ds_complemento_numero", length = 30)
    private String complementoNumero;

    @Column(name="nm_bairro", length = 45)
    private String nomeBairro;

    @Column(name="nm_zona_bairro", length = 20)
    private String zona;

    @Column(name="nm_cidade", length = 60)
    private String nomeCidade;

    @Column(name="cd_ibge")
    private Integer codigoIBGE;

    @Column(name="nr_ddd")
    private Integer ddd;

    @Column(name="sg_estado", length = 2)
    private String sigla;

    @Column(name="nm_estado", length = 30)
    private String nomeEstado;

    @Column(name="nm_logradouro", length = 100)
    private String nomeLogradouro;

    @Column(name="nr_cep")
    private int cep;


    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
}
