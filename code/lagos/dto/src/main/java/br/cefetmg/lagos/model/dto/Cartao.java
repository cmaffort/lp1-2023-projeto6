package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.IntEnum;

@Table(nome = "cartao")
public class Cartao extends AbstractDTO<Cartao> implements DTO<Cartao> {
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
        return IntEnum.getIntForEnum(getBandeira());
    }

    @Column(nome = "bandeira")
    @Setter
    public void setBandeiraWithInt(int ord) {
        setBandeira(IntEnum.getEnumForInt(ord, Bandeira.class));
    }

    @Related(nome = "endereco")
    @Getter
    public Endereco getEndereco() {
        return endereco;
    }

    @Related(nome = "endereco")
    @Setter
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Column(nome = "endereco__fk")
    @Getter
    public long getEnderecoAsLong() {
        return getRelatedAsLong(getEndereco());
    }

    @Column(nome = "endereco__fk")
    @Setter
    public void setEnderecoWithLong(long id) {
        setEndereco(setRelatedWithLong(getEndereco(), id, new Endereco()));
    }

    @Related(nome = "usuario")
    @Getter
    public Usuario getUsuario() {
        return usuario;
    }

    @Related(nome = "usuario")
    @Setter
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(nome = "usuario__fk")
    @Getter
    public long getUsuarioAsLong() {
        return getRelatedAsLong(getUsuario());
    }

    @Column(nome = "usuario__fk")
    @Setter
    public void setUsuarioWithLong(long id) {
        setUsuario(setRelatedWithLong(getUsuario(), id, new Usuario()));
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
