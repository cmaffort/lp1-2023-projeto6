package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.util.Date;

public interface HistoricoVETAdapter<DataTransferObject extends HistoricoVETAdapter<DataTransferObject>> extends DTO<DataTransferObject> {
    HistoricoVET getHistoricoVET();

    void setHistoricoVET(HistoricoVET historicoVET);

    default TipoHistoricoVET getTipo() {
        return getHistoricoVET().getTipo();
    }

    default void setTipo(TipoHistoricoVET tipo) {
        getHistoricoVET().setTipo(tipo);
    }

    default int getTipoAsInt() {
        return getHistoricoVET().getTipoAsInt();
    }

    default void setTipoWithInt(int ord) {
        getHistoricoVET().setTipoWithInt(ord);
    }

    default Date getData() {
        return getHistoricoVET().getData();
    }

    default void setData(Date data) {
        getHistoricoVET().setData(data);
    }

    default Loja getLoja() {
        return getHistoricoVET().getLoja();
    }

    default void setLoja(Loja loja) {
        getHistoricoVET().setLoja(loja);
    }

    default long getId() {
        return getHistoricoVET().getId();
    }

    default void setId(long id) {
        getHistoricoVET().setId(id);
    }
}
