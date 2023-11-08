package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.permicoes.PermissoesTipo;

import java.util.List;

@Table(nome = "funcionario")
@PrimaryKey(nome = "pk")
public class Funcionario extends AbstractDTO<Funcionario> implements DTO<Funcionario>, PessoaAdapter<Funcionario> {
    private Double salario;
    private Boolean ativo;
    private TipoFuncionario tipo;

    private Loja loja;

    private Pessoa pessoa;

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesTipo.getPermissoesForTipo(tipo);
    }

    @Column(nome = "salario", tipo = Double.class)
    @NotNull
    @Getter
    public Double getSalario() {
        return salario;
    }

    @Column(nome = "salario", tipo = Double.class)
    @NotNull
    @Setter
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Column(nome = "ativo", tipo = Boolean.class)
    @NotNull
    @Getter
    public Boolean isAtivo() {
        return ativo;
    }

    @Column(nome = "ativo", tipo = Boolean.class)
    @NotNull
    @Setter
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo_funcionario", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getTipoAsInt() {
        return IntEnum.getIntForEnum(getTipo());
    }

    @Column(nome = "tipo_funcionario", tipo = Integer.class)
    @NotNull
    @Setter
    public void setTipoWithInt(Integer ord) {
        setTipo(IntEnum.getEnumForInt(ord, TipoFuncionario.class));
    }

    @Related(nome = "loja")
    @Getter
    public Loja getLoja() {
        return loja;
    }

    @Related(nome = "loja")
    @Setter
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setLojaWithLong(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
    }

    @Related(nome = "pessoa")
    @Getter
    public Pessoa getPessoa() {
        return pessoa;
    }

    @Related(nome = "pessoa")
    @Setter
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getId() {
        return getRelatedAsLong(getPessoa());
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        setPessoa(setRelatedWithLong(pessoa, id, new Pessoa()));
    }
}
