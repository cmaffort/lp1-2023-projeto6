package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.IManterEndereco;
import br.cefetmg.lagos.model.service.IManterPeriodicidade;
import br.cefetmg.lagos.model.service.ManterEndereco;
import br.cefetmg.lagos.model.service.ManterPeriodicidade;
import br.cefetmg.lagos.model.service.loja.IManterUsuarioLoja;
import br.cefetmg.lagos.model.service.loja.ManterUsuarioLoja;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InitDefault {
    public static void init() throws PersistenceException, NegocioException, DTOExeption {
        IManterUsuario manterUsuario = new ManterUsuario();

        Usuario usuario1 = new Usuario();
        usuario1.setNome("José");
        usuario1.setSobrenome("Judeu");
        usuario1.setNascimento(Date.valueOf("1990-07-15"));
        usuario1.setEmail("eduardbh2014@gmail.com");
        usuario1.setTelefone(32999781209L);
        usuario1.setTipo(TipoUsuario.CONTRATANTE);
        usuario1.setUsername("jew");
        usuario1.setSenha("dfssadfouihfrfq$9efwhqsaf");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("User");
        usuario2.setSobrenome("Segundo");
        usuario2.setNascimento(Date.valueOf("1993-07-15"));
        usuario2.setEmail("eduardbh2014@gmail.com");
        usuario2.setTelefone(32999781209L);
        usuario2.setTipo(TipoUsuario.CONTRATANTE);
        usuario2.setUsername("another");
        usuario2.setSenha("dfssadfouihfrfq$9efwhqsaf");

        Usuario usuario3 = new Usuario();
        usuario3.setNome("New");
        usuario3.setSobrenome("Tird");
        usuario3.setNascimento(Date.valueOf("1900-07-15"));
        usuario3.setEmail("thetirssdf@gmail.com");
        usuario3.setTelefone(32999781209L);
        usuario3.setTipo(TipoUsuario.CONTRATANTE);
        usuario3.setUsername("anotherone");
        usuario3.setSenha("dfssadfouihfrfq$9efwhqsaf");

        manterUsuario.cadastrar(usuario2);
        manterUsuario.cadastrar(usuario1);
        usuario1.setSenha("dfssadfouihfrfq$9efwhqsaf");

        manterUsuario.cadastrar(usuario3);

        System.out.println(manterUsuario.autenticar(usuario1));

        IManterPeriodicidade manterPeriodicidade = new ManterPeriodicidade();

        Periodicidade periodicidade = new Periodicidade();
        periodicidade.setPeriodo(2);
        periodicidade.setQuantidadeDiasPorPeriodo(365);

        manterPeriodicidade.cadastrar(periodicidade);

        IManterContrato manterContrato = new ManterContrato();

        Contrato contrato1 = new Contrato();
        contrato1.setPreco(2500.0);
        contrato1.setNumeroDeLojas(10);
        contrato1.setDataDeCriacao(Date.valueOf("2018-10-18"));
        contrato1.setPeriodicidade(periodicidade);

        Contrato contrato2 = new Contrato();
        contrato2.setPreco(7000.0);
        contrato2.setNumeroDeLojas(6);
        contrato2.setDataDeCriacao(Date.valueOf("2022-11-11"));
        contrato2.setPeriodicidade(periodicidade);

        manterContrato.cadastrar(contrato1);
        manterContrato.cadastrar(contrato2);
        
        IManterContratoAssinado manterContratoAssinado = new ManterContratoAssinado();

        ContratoAssinado contratoAssinado1 = new ContratoAssinado();
        contratoAssinado1.setDataDeContratacao(Date.valueOf("2018-12-18"));
        contratoAssinado1.setUsuario(usuario1);
        contratoAssinado1.setContrato(contrato1);

        ContratoAssinado contratoAssinado2 = new ContratoAssinado();
        contratoAssinado2.setUsuario(usuario1);
        contratoAssinado2.setContrato(contrato2);

        ContratoAssinado contratoAssinado3 = new ContratoAssinado();
        contratoAssinado3.setUsuario(usuario2);
        contratoAssinado3.setContrato(contrato2);

        manterContratoAssinado.cadastrar(contratoAssinado1);
        contratoAssinado1.setCancelado(true);
        manterContratoAssinado.alterar(contratoAssinado1);
        manterContratoAssinado.cadastrar(contratoAssinado2);
        manterContratoAssinado.cadastrar(contratoAssinado3);

        IManterEndereco manterEndereco = new ManterEndereco();

        Endereco endereco1 = new Endereco();
        endereco1.setCep(12234234);
        endereco1.setNumero(12);

        Endereco endereco2 = endereco1.getInstance(endereco1);

        manterEndereco.cadastrar(endereco1);
        manterEndereco.cadastrar(endereco2);

        IManterLoja manterLoja = new ManterLoja();

        Loja loja = new Loja();
        loja.setEndereco(endereco1);
        loja.setUsuario(usuario1);

        Loja loja1 = new Loja();
        loja1.setEndereco(endereco2);
        loja1.setUsuario(usuario1);

        Loja loja2 = new Loja();
        loja2.setEndereco(endereco2);
        loja2.setUsuario(usuario3);

        manterLoja.cadastrar(loja);
        manterLoja.cadastrar(loja1);
        manterLoja.cadastrar(loja2);

        IManterUsuarioLoja manterUsuarioLoja = new ManterUsuarioLoja();

        UsuarioLoja chefe1 = new UsuarioLoja();
        chefe1.setUsername("cef");
        chefe1.setSenha("Top#$dawe32SENHAAA");
        chefe1.setSalario(2343.0);
        chefe1.setAtivo(true);
        chefe1.setTipo(TipoFuncionario.CHEFE);
        chefe1.setLoja(loja);
        chefe1.setNome("Chefioto");
        chefe1.setNascimento(Date.valueOf("2000-09-14"));
        chefe1.setEmail("chefe@gmail.com");

        UsuarioLoja chefe2 = new UsuarioLoja();
        chefe2.setUsername("ce4f");
        chefe2.setSenha("Top#$dawe32SENHAAA");
        chefe2.setSalario(2343.0);
        chefe2.setAtivo(true);
        chefe2.setTipo(TipoFuncionario.CHEFE);
        chefe2.setLoja(loja);
        chefe2.setNome("Chefioto2");
        chefe2.setNascimento(Date.valueOf("2000-09-14"));
        chefe2.setEmail("chefe2@gmail.com");

        manterUsuarioLoja.cadastrar(chefe1);
        manterUsuarioLoja.cadastrar(chefe2);

        System.out.println("Todos os usuarios:");
        System.out.println(manterUsuario.pesquisarTodos().stream().map(Usuario::toString)
                .collect(Collectors.joining("\n")));

        System.out.println();

        System.out.println("Todos os contratos:");
        System.out.println(manterContrato.pesquisarTodos().stream().map(Contrato::toString)
                .collect(Collectors.joining("\n")));

        System.out.println();

        System.out.println("Todos os contratos do usuario1:");
        System.out.println(manterContrato.pesquisarPorContratante(usuario1).stream().map(Contrato::toString)
                .collect(Collectors.joining("\n")));

        System.out.println();

        System.out.println("Todos os contratos do usuario2:");
        System.out.println(manterContrato.pesquisarPorContratante(usuario2).stream().map(Contrato::toString)
                .collect(Collectors.joining("\n")));;

        System.out.println();

        System.out.println("Todos os contratos assinados:");
        System.out.println(manterContratoAssinado.pesquisarTodos().stream().map(ContratoAssinado::toString)
                .collect(Collectors.joining("\n")));

        System.out.println();

        System.out.println("Todos os contratos assinados do usuario1:");
        System.out.println(manterContratoAssinado.pesquisarPorContratante(usuario1).stream().map(ContratoAssinado::toString)
                .collect(Collectors.joining("\n")));

        System.out.println();

        System.out.println("Todos os contratos assinados do usuario2:");
        System.out.println(manterContratoAssinado.pesquisarPorContratante(usuario2).stream().map(ContratoAssinado::toString)
                .collect(Collectors.joining("\n")));
    }

    public static void main(String[] args) throws PersistenceException, NegocioException, MissingDataExeption, DTOExeption {
        init();
        IManterUsuario manterUsuario = new ManterUsuario();
        System.out.println(manterUsuario.pesquisarPorId(1L).getPermicoes());
    }
}
