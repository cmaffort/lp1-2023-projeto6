package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.IEnderecoDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;

public class LojaDAO extends AbstractDAO implements ILojaDAO {
    private static final EnderecoDAO ENDERECO_DAO;
    private static final UsuarioDAO USUARIO_DAO;
    
    static {
        ENDERECO_DAO = new EnderecoDAO();
        USUARIO_DAO = new UsuarioDAO();
    }
    
    private static EnderecoDAO getEnderecoDao() {
        return ENDERECO_DAO;
    }
    
    private static UsuarioDAO getUsuarioDao() {
        return USUARIO_DAO;
    }
    
    @Override
    protected DTO getDTO() {
        return new Loja();
    }

    @Override
    public Long inserir(Loja loja) throws PersistenceException {
        return super.inserir(loja);
    }

    @Override
    public boolean alterar(Loja loja) throws PersistenceException {
        return super.alterar(loja);
    }

    @Override
    public boolean remover(Loja loja) throws PersistenceException {
        return super.remover(loja);
    }

    private Loja fillFKedDTOs(Loja Loja) throws PersistenceException {
        IUsuarioDAO usuarioDAO = getUsuarioDao();
        IEnderecoDAO enderecoDAO = getEnderecoDao();

        Usuario usuario = usuarioDAO.consultarPorId(Loja.getUsuarioAsLong());
        Endereco endereco = enderecoDAO.consultarPorId(Loja.getEnderecoAsLong());

        Loja.setUsuario(usuario);
        Loja.setEndereco(endereco);

        return Loja;
    }

    private List<Loja> fillFKedDTOs(List<Loja> cartoes) throws PersistenceException {
        for (Loja Loja : cartoes)
            fillFKedDTOs(Loja);
        return cartoes;
    }

    @Override
    public List<Loja> listar() throws PersistenceException {
        return fillFKedDTOs((List<Loja>) super.listar());
    }

    @Override
    public List<Loja> listar(DTO... related) throws PersistenceException {
        return fillFKedDTOs((List<Loja>) super.listar(related));
    }

    @Override
    public Loja consultarPorId(Long id) throws PersistenceException {
        return fillFKedDTOs((Loja) super.consultarPorId(id));
    }
}
