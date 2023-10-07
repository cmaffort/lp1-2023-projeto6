/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.tipos.Permissoes;

/**
 * @author Aluno
 */
public interface IUsuarioLojaDAO extends IFuncionarioDAO {

    void setUsername(String username);

    String getUsername();

    void setSenha(String senha);

    String getSenha();

    void setPermissoes(Permissoes[] permissoes);

    Permissoes[] getPermissoes();

    long getId();
}
