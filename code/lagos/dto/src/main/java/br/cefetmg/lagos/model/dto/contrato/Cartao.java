package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.IntEnum;

@Table(nome = "cartao")
@PrimaryKey(nome = "pk")
public class Cartao extends AbstractDTO<Cartao> implements DTO<Cartao> {
    private Long numero;
    private Bandeira bandeira;

    private Endereco endereco;
    private Usuario usuario;

    private Long id;

    @Column(nome = "numero", tipo = Long.class)
    @NotNull
    @Getter
    public Long getNumero() {
        return numero;
    }

    @Column(nome = "numero", tipo = Long.class)
    @NotNull
    @Setter
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    @Column(nome = "bandeira", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getBandeiraAsInt() {
        return IntEnum.getIntForEnum(getBandeira());
    }

    @Column(nome = "bandeira", tipo = Integer.class)
    @NotNull
    @Setter
    public void setBandeiraWithInt(Integer ord) {
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

    @Column(nome = "endereco__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getEnderecoAsLong() {
        return getRelatedAsLong(getEndereco());
    }

    @Column(nome = "endereco__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setEnderecoWithLong(Long id) {
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

    @Column(nome = "usuario__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getUsuarioAsLong() {
        return getRelatedAsLong(getUsuario());
    }

    @Column(nome = "usuario__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setUsuarioWithLong(Long id) {
        setUsuario(setRelatedWithLong(getUsuario(), id, new Usuario()));
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
