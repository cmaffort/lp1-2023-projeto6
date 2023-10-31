package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.contrato.*;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.*;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Date;
import java.sql.SQLException;

public class TestContratos {
    private static void testPessoa() throws PersistenceException {
        PessoaDAO pessoaDAO = new PessoaDAO();

        for (Pessoa p : pessoaDAO.listar())
            pessoaDAO.remover(p);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("testesssss");
        pessoa.setSobrenome("de paula");
        pessoa.setEmail("pessao@f.con");
        pessoa.setNascimento(Date.valueOf("2008-09-23"));
        pessoa.setTelefone(2123455L);
        pessoaDAO.inserir(pessoa);

        System.out.println(pessoaDAO.consultarPorId(pessoa.getId()));

        for (Pessoa p : pessoaDAO.listar())
            System.out.println(p);
    }

    private static void testPeriodicidade() throws PersistenceException {
        IPeriodicidadeDAO dao = new PeriodicidadeDAO();
        Periodicidade periodicidade = new Periodicidade();
        periodicidade.setPeriodo(2);
        periodicidade.setQuantidadeDiasPorPeriodo(365);

        System.out.println(dao.inserir(periodicidade));
        System.out.println(dao.consultarPorId(periodicidade.getId()));

        for (Periodicidade p : dao.listar())
            System.out.println(p);

        dao.inserir(periodicidade);
        periodicidade.setPeriodo(4);
        dao.alterar(periodicidade);
        dao.remover(periodicidade);
    }

    private static void testEndereco() throws PersistenceException {
        IEnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco endereco = new Endereco();
        endereco.setNumero(1234);
        endereco.setCep(12345678);

        System.out.println(enderecoDAO.inserir(endereco));
        System.out.println(enderecoDAO.consultarPorId(endereco.getId()));

        for (Endereco e : enderecoDAO.listar())
            System.out.println(e);

        enderecoDAO.inserir(endereco);
        endereco.setNumero(234);
        enderecoDAO.alterar(endereco);
        enderecoDAO.remover(endereco);
    }

    private static void testCartao() throws PersistenceException {
        ICartaoDAO cartaoDAO = new CartaoDAO();
        Cartao cartao = new Cartao();
        cartao.setNumero(1243525235432324L);
        cartao.setBandeiraWithInt(1);
        cartao.setEnderecoWithLong(1);
        cartao.setUsuarioWithLong(1);

        System.out.println(cartaoDAO.inserir(cartao));
        cartao = cartaoDAO.consultarPorId(cartao.getId());
        System.out.println(cartao);

        Cartao cartao1 = new Cartao();
        cartao1.setNumero(1243525235432324L);
        cartao1.setBandeiraWithInt(1);
        cartao1.setEnderecoWithLong(1);
        cartao1.setUsuarioWithLong(2);

        cartaoDAO.inserir(cartao1);

        for (Cartao c : cartaoDAO.listar(cartao.getUsuario()))
            System.out.println(c);

        cartaoDAO.inserir(cartao);
        cartao.setNumero(12L);
        cartaoDAO.alterar(cartao);
        cartaoDAO.remover(cartao);
    }

    private static void testUsuario() throws PersistenceException {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNome("José");
        usuario.setSobrenome("Judeu");
        usuario.setNascimento(Date.valueOf("2006-07-15"));
        usuario.setEmail("eduardbh2014@gmail.com");
        usuario.setTelefone(32999781209L);
        usuario.setTipoWithInt(1);
        usuario.setUsername("jew");
        usuario.setSenha("dfssadfouihfrfq$9efwhqsaf");

        usuarioDAO.inserir(usuario);

        System.out.println(usuarioDAO.inserir(usuario));
        System.out.println(usuarioDAO.consultarPorId(usuario.getId()));

        for (Usuario u : usuarioDAO.listar())
            System.out.println(u);

        usuarioDAO.inserir(usuario);
        usuario.setUsername("not");
        usuarioDAO.alterar(usuario);
        usuarioDAO.remover(usuario);
    }

    private static void testLoja() throws PersistenceException, DTOExeption {
        ILojaDAO lojaDAO = new LojaDAO();
        Loja loja = new Loja();
        loja.setUsuario((new UsuarioDAO()).consultarPorId(1L));
        loja.setEndereco((new EnderecoDAO()).consultarPorId(1L));

        System.out.println(lojaDAO.inserir(loja));

        loja = lojaDAO.consultarPorId(1L);

        for (Loja l : lojaDAO.listar())
            System.out.println(l.getInstance(loja));

        lojaDAO.inserir(loja);
        loja.setUsuarioWithLong(2L);
        lojaDAO.alterar(loja);
        lojaDAO.remover(loja);
    }

    private static void testContrato() throws PersistenceException {
        IContratoDAO contratoDAO = new ContratoDAO();
        Contrato contrato = new Contrato();
        contrato.setAtivo(true);
        contrato.setPreco(2500);
        contrato.setNumeroDeLojas(10);
        contrato.setDataDeCriacao(Date.valueOf("2022-10-18"));
        contrato.setPeriodicidadeWithLong(1);

        System.out.println(contratoDAO.inserir(contrato));
        System.out.println(contratoDAO.consultarPorId(contrato.getId()).getManeger().getColumns());

        for (Contrato c : contratoDAO.listar())
            System.out.println(c);

        contratoDAO.inserir(contrato);
        contrato.setNumeroDeLojas(12);
        contratoDAO.alterar(contrato);
        contratoDAO.remover(contrato);
    }

    private static void testContratoAssinado() throws PersistenceException {
        IContratoAssinadoDAO contratoAssinadoDAO = new ContratoAssinadoDAO();
        ContratoAssinado contratoAssinado = new ContratoAssinado();
        contratoAssinado.setVigente(true);
        contratoAssinado.setDataDeContratacao(Date.valueOf("2023-08-18"));
        contratoAssinado.setCancelado(false);
        contratoAssinado.setUsuarioWithLong(1);
        contratoAssinado.setContratoWithLong(1);

        contratoAssinadoDAO.inserir(contratoAssinado);

        Usuario usuario = contratoAssinado.getUsuario();

        contratoAssinado.setUsuarioWithLong(2);

        System.out.println(contratoAssinadoDAO.inserir(contratoAssinado));
        System.out.println(contratoAssinadoDAO.consultarPorId(contratoAssinado.getId()));
        System.out.println(contratoAssinadoDAO.consultarPor(contratoAssinado.getUsuario()));

        for (ContratoAssinado c : contratoAssinadoDAO.listar(usuario))
            System.out.println(c);

        contratoAssinadoDAO.inserir(contratoAssinado);
        contratoAssinado.setCancelado(true);
        contratoAssinadoDAO.alterar(contratoAssinado);
        contratoAssinadoDAO.remover(contratoAssinado);
    }

    private static void testConfiguracoesDeInterface() throws SQLException, PersistenceException {
        IConfiguracoesDeInterfaceDAO configuracoesDeInterfaceDAO = new ConfiguracoesDeInterfaceDAO();
        ConfiguracoesDeInterface configuracoesDeInterface = new ConfiguracoesDeInterface();
        configuracoesDeInterface.setLogo(new SerialBlob("1242".getBytes()));
        configuracoesDeInterface.setCorBase("#000000");
        configuracoesDeInterface.setNomeDaEmpresa("LOSH");
        configuracoesDeInterface.setId(1);

        configuracoesDeInterfaceDAO.inserir(configuracoesDeInterface);

        Usuario usuario = configuracoesDeInterface.getUsuario();

        configuracoesDeInterface.setId(2);

        System.out.println(configuracoesDeInterfaceDAO.inserir(configuracoesDeInterface));
        System.out.println(configuracoesDeInterfaceDAO.consultarPorId(configuracoesDeInterface.getId()));
//        System.out.println(configuracoesDeInterfaceDAO.consultarPor(configuracoesDeInterface.getUsuario()));

        for (ConfiguracoesDeInterface c : configuracoesDeInterfaceDAO.listar(usuario))
            System.out.println(c);

        configuracoesDeInterfaceDAO.remover(configuracoesDeInterface);
        configuracoesDeInterface.setId(2);
        configuracoesDeInterfaceDAO.inserir(configuracoesDeInterface);
        configuracoesDeInterface.setNomeDaEmpresa("onge");
        configuracoesDeInterfaceDAO.alterar(configuracoesDeInterface);
    }

    public static void main(String[] args) throws PersistenceException, DTOExeption, SQLException {
        // Essa classe não realiza testes automatizados. Por enquanto ela é só um playground
        testUsuario();
        testEndereco();
        testCartao();
        testPeriodicidade();
        testContrato();
        testContratoAssinado();
        testConfiguracoesDeInterface();
        testLoja();
    }
}
