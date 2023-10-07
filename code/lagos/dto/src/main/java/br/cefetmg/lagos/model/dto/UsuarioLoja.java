package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.Permissoes;

import java.util.List;

public class UsuarioLoja extends Funcionario implements DTO {
    private List<Permissoes> permicoes;
    private String username;
    private String senha;

    private long id;
}
