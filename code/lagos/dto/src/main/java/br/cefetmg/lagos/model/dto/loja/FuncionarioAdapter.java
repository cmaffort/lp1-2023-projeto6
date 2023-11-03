package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

public interface FuncionarioAdapter<DataTransferObject extends FuncionarioAdapter<DataTransferObject>> extends PessoaAdapter<DataTransferObject> {
    Funcionario getFuncionario();

    void setFuncionario(Funcionario funcionario);

    default Double getSalario() {
        return getFuncionario().getSalario();
    }

    default void setSalario(Double salario) {
        getFuncionario().setSalario(salario);
    }

    default Boolean isAtivo() {
        return getFuncionario().isAtivo();
    }

    default void setAtivo(Boolean ativo) {
        getFuncionario().setAtivo(ativo);
    }

    default TipoFuncionario getTipo() {
        return getFuncionario().getTipo();
    }

    default void setTipo(TipoFuncionario tipo) {
        getFuncionario().setTipo(tipo);
    }

    default Integer getTipoAsInt() {
        return getFuncionario().getTipoAsInt();
    }

    default void setTipoWithInt(Integer ord) {
        getFuncionario().setTipoWithInt(ord);
    }

    default Loja getLoja() {
        return getFuncionario().getLoja();
    }

    default void setLoja(Loja loja) {
        getFuncionario().setLoja(loja);
    }

    @Override
    default Pessoa getPessoa() {
        return getFuncionario().getPessoa();
    }

    @Override
    default void setPessoa(Pessoa pessoa) {
        getFuncionario().setPessoa(pessoa);
    }
}
