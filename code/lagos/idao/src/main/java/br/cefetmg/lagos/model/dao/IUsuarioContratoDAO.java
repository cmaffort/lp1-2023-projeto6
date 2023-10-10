/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

/**
 * @author miguel
 */
public interface IUsuarioContratoDAO extends PessoaDAO {

    boolean inserirUsername(String username);
    
    boolean alterarUsername(String username);
    
    boolean removerUsername(String username);

    String listarUsername();

    boolean inserirSenhna(String senha);
    
    boolean alterarSenha(String senha);
    
    boolean removerSenha(String senha);

    String listarSenha();

    boolean inserirPermissoes(TipoFuncionario[] permissoes);
    
    boolean alterarPermissoes(TipoFuncionario[] permissoes);
    
    boolean removerPersmissoes(TipoFuncionario[] permissoes);

    TipoFuncionario[] listarPermissoes();
    
    boolean inserirPessoa(PessoaDAO pessoa);
    
    boolean alterarPessoa(PessoaDAO pessoa);
    
    boolean removerPessoa(PessoaDAO pessoa);
    
    PessoaDAO listarPessoa();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
