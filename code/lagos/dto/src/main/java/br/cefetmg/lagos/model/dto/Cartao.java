package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Bandeira;

@Table(nome = "cartao")
public class Cartao extends AbstractDTO implements DTO {
    private long numero;
    private Bandeira bandeira;

    private Endereco endereco;
    private Usuario usuario;

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
        return getEnumAsInt(getBandeira());
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
        return getRelatedDTOAsLong(getEndereco());
    }

    @Column(nome = "endereco__fk")
    @Setter
    public void setEnderecoWithLong(long id) {
        setEndereco((Endereco) setRelatedWithLong(getEndereco(), id, new Endereco()));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(nome = "usuario__fk")
    @Getter
    public long getUsuarioAsLong() {
        return getRelatedDTOAsLong(getUsuario());
    }

    @Column(nome = "usuario__fk")
    @Setter
    public void setUsuarioWithLong(long id) {
        setUsuario((Usuario) setRelatedWithLong(getUsuario(), id, new Usuario()));
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
