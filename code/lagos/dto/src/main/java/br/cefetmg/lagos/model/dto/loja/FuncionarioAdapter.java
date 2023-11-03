package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

public interface FuncionarioAdapter<DataTransferObject extends FuncionarioAdapter<DataTransferObject>> extends PessoaAdapter<DataTransferObject> {
    Funcionario getFuncionario();

    void setFuncionario(Funcionario funcionario);

    default double getSalario() {
        return getFuncionario().getSalario();
    }

    default void setSalario(double salario) {
        getFuncionario().setSalario(salario);
    }

    default boolean isAtivo() {
        return getFuncionario().isAtivo();
    }

    default void setAtivo(boolean ativo) {
        getFuncionario().setAtivo(ativo);
    }

    default TipoFuncionario getTipo() {
        return getFuncionario().getTipo();
    }

    default void setTipo(TipoFuncionario tipo) {
        getFuncionario().setTipo(tipo);
    }

    default int getTipoAsInt() {
        return getFuncionario().getTipoAsInt();
    }

    default void setTipoWithInt(int ord) {
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
