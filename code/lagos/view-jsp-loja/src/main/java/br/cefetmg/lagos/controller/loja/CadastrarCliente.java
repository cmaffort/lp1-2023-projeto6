package br.cefetmg.lagos.controller.loja;

import br.cefetmg.lagos.controller.util.TipoServlet;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.old.ManterCliente;
import br.cefetmg.lagos.util.Pair;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;

public class CadastrarCliente {
    private static TipoServlet getTipoDoPost(){return TipoServlet.JSON_SERVLET;}
    
    public static Pair<String, TipoServlet> doPost(HttpServletRequest request){
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefoneS = request.getParameter("telefone");
        String email = request.getParameter("email");

        Gson gson = new Gson();

        long telefone = Long.parseLong(telefoneS);
        
        Long idLoja = (Long) request.getSession().getAttribute("idLoja");
        
        ManterLoja manterLoja = new ManterLoja();

        Cliente cliente = new Cliente();

        ManterCliente manterCliente = new ManterCliente();

        try {
            cliente.setEmail(email);
            cliente.setSobrenome(sobrenome);
            cliente.setTelefone(telefone);
            cliente.setNome(nome);
            cliente.setLoja(manterLoja.pesquisarPorIdLoja(idLoja));

            if (manterCliente.cadastrar(cliente) == null)
                return new Pair<>(gson.toJson("Não foi possivel cadastrar o cliente"), getTipoDoPost());

            return new Pair<>(gson.toJson("O cliente foi cadastrado com sucesso"), getTipoDoPost());
        } catch (NegocioException | PersistenceException e) {
            return new Pair<>(gson.toJson("Não foi possivel cadastrar o cliente"), getTipoDoPost());
        }
    }
}