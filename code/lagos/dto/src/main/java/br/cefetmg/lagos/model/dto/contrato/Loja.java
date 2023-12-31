package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "loja")
@PrimaryKey(nome = "pk")
public class Loja extends AbstractDTO<Loja> implements DTO<Loja> {
    private Usuario usuario;
    private Endereco endereco;

    private Long id;

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

    @Column(nome = "usuario__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getUsuarioAsLong() {
        return getRelatedAsLong(usuario);
    }

    @Column(nome = "usuario__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setUsuarioWithLong(Long id) {
        usuario = setRelatedWithLong(usuario, id, new Usuario());
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

    @Column(nome = "endereco__fk", tipo = Long.class)
    @Getter
    public Long getEnderecoAsLong() {
        return getRelatedAsLong(endereco);
    }

    @Column(nome = "endereco__fk", tipo = Long.class)
    @Setter
    public void setEnderecoWithLong(Long id) {
        endereco = setRelatedWithLong(endereco, id, new Endereco());
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return id;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
