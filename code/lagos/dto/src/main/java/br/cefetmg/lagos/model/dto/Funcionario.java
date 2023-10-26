package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.util.PermissoesFuncionario;

import java.util.List;

public class Funcionario extends Pessoa implements DTO {
    private Double salario;
    private Boolean ativo;
    private TipoFuncionario tipo;

    private Loja loja;

    private long id;

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesFuncionario.getPermissoesForTipo(tipo);
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
