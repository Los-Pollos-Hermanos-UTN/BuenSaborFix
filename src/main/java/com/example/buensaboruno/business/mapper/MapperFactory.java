package com.example.buensaboruno.business.mapper;

import org.mapstruct.factory.Mappers;

public class MapperFactory {
    public static <T> T getMapper(Class<T> mapperClass) {
        return Mappers.getMapper(mapperClass);
    }
}
