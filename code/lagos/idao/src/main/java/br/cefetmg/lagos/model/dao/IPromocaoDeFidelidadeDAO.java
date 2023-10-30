package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import br.cefetmg.lagos.model.dto.PromocaoDeFidelidade;

public interface IPromocaoDeFidelidadeDAO  {
    
    boolean inserir(PromocaoDeFidelidade promocaoFidelidadde) throws SQLException, ClassNotFoundException;
    
    boolean alterar(PromocaoDeFidelidade promocaoFidelidade) throws SQLException, ClassNotFoundException;
    
    boolean remover(PromocaoDeFidelidade promocaoFidelidade) throws SQLException, ClassNotFoundException;
    
    List<PromocaoDeFidelidade> listar() throws SQLException, ClassNotFoundException;
}
