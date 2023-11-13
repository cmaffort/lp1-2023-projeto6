package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface HistoricoVETAdapter<DataTransferObject extends HistoricoVETAdapter<DataTransferObject>> extends DTO<DataTransferObject> {
    HistoricoVET getHistoricoVET();

    void setHistoricoVET(HistoricoVET historicoVET);

    default TipoHistoricoVET getTipo() {
        return getHistoricoVET().getTipo();
    }

    default void setTipo(TipoHistoricoVET tipo) {
        getHistoricoVET().setTipo(tipo);
    }

    default Integer getTipoAsInt() {
        return getHistoricoVET().getTipoAsInt();
    }

    default void setTipoWithInt(Integer ord) {
        getHistoricoVET().setTipoWithInt(ord);
    }

    default LocalDateTime getData() {
        return getHistoricoVET().getData();
    }

    default void setData(LocalDateTime data) {
        getHistoricoVET().setData(data);
    }

    default Loja getLoja() {
        return getHistoricoVET().getLoja();
    }

    default void setLoja(Loja loja) {
        getHistoricoVET().setLoja(loja);
    }

    default Long getId() {
        return getHistoricoVET().getId();
    }

    default void setId(Long id) {
        getHistoricoVET().setId(id);
    }
}
