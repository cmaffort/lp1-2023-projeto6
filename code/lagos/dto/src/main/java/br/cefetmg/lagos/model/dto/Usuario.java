 package br.cefetmg.lagos.model.dto;

 import br.cefetmg.lagos.model.dto.tipos.Permissoes;

 import java.util.List;

 public class Usuario extends Pessoa implements DTO {
    private List<Permissoes> permicoes;
    private String username;
    private String senha;

    private long id;

     public List<Permissoes> getPermicoes() {
         return permicoes;
     }

     public void setPermicoes(List<Permissoes> permicoes) {
         this.permicoes = permicoes;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getSenha() {
         return senha;
     }

     public void setSenha(String senha) {
         this.senha = senha;
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
