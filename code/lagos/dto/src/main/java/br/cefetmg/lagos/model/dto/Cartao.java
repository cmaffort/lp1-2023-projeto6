package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Contratante;
import br.cefetmg.lagos.model.dto.enums.Bandeira;

@Table(nome = "cartao")
public class Cartao extends AbstractDTO implements DTO {
    private long numero;
    private Bandeira bandeira;

    private Endereco endereco;
    private Contratante contratante;

    private long id;

    @Column(nome = "numero")
    @Getter
    public long getNumero() {
        return numero;
    }

    @Column(nome = "numero")
    @Setter
    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    @Column(nome = "bandeira")
    @Getter
    public int getBandeiraAsInt() {
        return getBandeira().ordinal();
    }

    @Column(nome = "bandeira")
    @Setter
    public void setBandeiraWithInt(int ord) {
        setBandeira(Bandeira.get(ord));
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Column(nome = "endereco__fk")
    @Getter
    public long getEnderecoAsLong() {
        return getEndereco().getId();
    }

    @Column(nome = "endereco__fk")
    @Setter
    public void setEnderecoWithLong(long id) {
        if (endereco == null)
            endereco = new Endereco();
        endereco.setId(id);
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    @Column(nome = "usuario__fk")
    @Getter
    public long getContratanteAsLong() {
        return getContratante().getId();
    }

    @Column(nome = "usuario__fk")
    @Setter
    public void setContratanteWithLong(long id) {
        if (contratante == null)
            contratante = new Contratante();
        contratante.setId(id);
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return id;
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        this.id = id;
    }
}
