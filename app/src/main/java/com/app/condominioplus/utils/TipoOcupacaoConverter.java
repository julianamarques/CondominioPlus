package com.app.condominioplus.utils;

import com.app.condominioplus.models.TipoOcupacao;

import io.objectbox.converter.PropertyConverter;

public class TipoOcupacaoConverter implements PropertyConverter<TipoOcupacao, Integer> {
    @Override
    public TipoOcupacao convertToEntityProperty(Integer databaseValue) {
        if (databaseValue == null) {
            return null;
        }

        for (TipoOcupacao tipoOcupacao : TipoOcupacao.values()) {
            if (tipoOcupacao.getCodigo() == databaseValue) {
                return tipoOcupacao;
            }
        }

        return TipoOcupacao.VAZIO;
    }

    @Override
    public Integer convertToDatabaseValue(TipoOcupacao entityProperty) {
        return entityProperty == null ? null : entityProperty.getCodigo();
    }
}
