package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.permicoes.PermissoesFuncionario;

import java.util.List;

@Table(nome = "funcionario")
public class Funcionario extends Pessoa implements DTO {
    private double salario;
    private boolean ativo;
    private TipoFuncionario tipo;

    private Loja loja;

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
        return getTipo().ordinal();
    }

    @Column(nome = "tipo_funcionario")
    @Setter
    public void setTipoWithInt(int ord) {
        setTipo(TipoFuncionario.get(ord));
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
