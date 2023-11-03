package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "loja")
public class Loja extends AbstractDTO<Loja> implements DTO<Loja> {
    private Usuario usuario;
    private Endereco endereco;

    private long id;

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
