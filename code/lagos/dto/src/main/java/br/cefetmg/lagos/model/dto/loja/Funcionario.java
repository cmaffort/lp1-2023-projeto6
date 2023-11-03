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
import br.cefetmg.lagos.model.dto.permicoes.PermissoesFuncionario;

import java.util.List;

@Table(nome = "funcionario")
public class Funcionario extends AbstractDTO<Funcionario> implements DTO<Funcionario>, PessoaAdapter<Funcionario> {
    private double salario;
    private boolean ativo;
    private TipoFuncionario tipo;

    private Loja loja;

    private Pessoa pessoa;

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesFuncionario.getPermissoesForTipo(tipo);
    }

    @Column(nome = "salario")
    @Getter
    public double getSalario() {
        return salario;
    }

    @Column(nome = "salario")
    @Setter
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Column(nome = "ativo")
    @Getter
    public boolean isAtivo() {
        return ativo;
    }

    @Column(nome = "ativo")
    @Setter
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo_funcionario")
    @Getter
    public int getTipoAsInt() {
        return IntEnum.getIntForEnum(getTipo());
    }

    @Column(nome = "tipo_funcionario")
    @Setter
    public void setTipoWithInt(int ord) {
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

    @Column(nome = "loja__fk")
    @Getter
    public long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk")
    @Setter
    public void setLojaWithLong(long id) {
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

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedAsLong(getPessoa());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setPessoa(setRelatedWithLong(pessoa, id, new Pessoa()));
    }
}
