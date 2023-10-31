package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.contrato.UsuarioDAO;
import br.cefetmg.lagos.model.dao.contrato.IUsuarioDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;

public class CartaoDAO extends AbstractDAO implements ICartaoDAO {
    private static final IUsuarioDAO CONTRATANTE_DAO;
    private static final IEnderecoDAO ENDERECO_DAO;

    static {
        CONTRATANTE_DAO = new UsuarioDAO();
        ENDERECO_DAO = new EnderecoDAO();
    }

    private static IUsuarioDAO getUsuarioDao() {
        return CONTRATANTE_DAO;
    }

    private static IEnderecoDAO getEnderecoDao() {
        return ENDERECO_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new Cartao();
    }

    @Override
    public Long inserir(Cartao cartao) throws PersistenceException {
        return super.inserir(cartao);
    }

    @Override
    public boolean alterar(Cartao cartao) throws PersistenceException {
        return super.alterar(cartao);
    }

    @Override
    public boolean remover(Cartao cartao) throws PersistenceException {
        return super.remover(cartao);
    }

    private Cartao fillFKedDTOs(Cartao cartao) throws PersistenceException {
        IUsuarioDAO usuarioDAO = getUsuarioDao();
        IEnderecoDAO enderecoDAO = getEnderecoDao();

        Usuario usuario = usuarioDAO.consultarPorId(cartao.getUsuarioAsLong());
        Endereco endereco = enderecoDAO.consultarPorId(cartao.getEnderecoAsLong());

        cartao.setUsuario(usuario);
        cartao.setEndereco(endereco);

        return cartao;
    }

    private List<Cartao> fillFKedDTOs(List<Cartao> cartoes) throws PersistenceException {
        for (Cartao cartao : cartoes)
            fillFKedDTOs(cartao);
        return cartoes;
    }

    @Override
    public List<Cartao> listar() throws PersistenceException {
        return fillFKedDTOs((List<Cartao>) super.listar());
    }

    @Override
    public List<Cartao> listar(DTO... related) throws PersistenceException {
        return fillFKedDTOs((List<Cartao>) super.listar(related));
    }

    @Override
    public Cartao consultarPorId(Long id) throws PersistenceException {
        return fillFKedDTOs((Cartao) super.consultarPorId(id));
    }
}
