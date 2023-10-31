package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "loja")
public class Loja extends AbstractDTO implements DTO {
    private Usuario usuario;
    private Endereco endereco;

    private long id;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
