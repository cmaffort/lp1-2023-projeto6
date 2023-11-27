package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.contrato.*;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ManterContrato extends AbstractManter<Contrato> implements IManterContrato {
    @Override
    protected IContratoDAO getDAO() {
        return new ContratoDAO();
    }

    @Override
    protected Contrato getDTOInstance() {
        return new Contrato();
    }

    @Override
    public Long cadastrar(Contrato contrato) throws PersistenceException, NegocioException {
        if (contrato.isAtivo() == null)
            contrato.setAtivo(true);

        if (contrato.getDataDeCriacao() == null)
            contrato.setDataDeCriacao(Date.valueOf(LocalDate.now()));

        return super.cadastrar(contrato);
    }

    @Override
    public List<Contrato> pesquisarPorContratante(Usuario contratante) throws NegocioException, PersistenceException {
        assertIdIsNotNull(contratante.getId());
        return getDAO().filtrarRelated(contratante);
    }

    public List<Contrato> pesquisarPorAtivo() throws NegocioException, PersistenceException, DTOExeption {
        try{
            Contrato contratoAtivo = getDTOInstance().getInstance(Map.of("ativo", true));

            return filtrar(contratoAtivo, "ativo");
        }catch (DTOExeption dtoExeption) {
            throw new RuntimeException(dtoExeption.getMessage(), dtoExeption);
        } catch (IndexOutOfBoundsException | NegocioException e) {
            throw new NegocioException("Nenhum contrato existente");
        }
    }
}
