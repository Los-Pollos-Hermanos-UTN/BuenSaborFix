package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.DetallePedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ArticuloInsumoMapper.class, ArticuloManufacturadoMapper.class})
public interface DetallePedidoMapper extends BaseMapper<DetallePedido, DetallePedidoDTO>{
    @Mapping(source = "articulo", target = "articulo", qualifiedByName = "mapArticuloToDTO")
    DetallePedidoDTO toDTO(DetallePedido source);

    @Mapping(source = "articulo", target = "articulo", qualifiedByName = "mapDTOToArticulo")
    DetallePedido toEntity(DetallePedidoDTO source);

    List<DetallePedidoDTO> toDTOsList(List<DetallePedido> source);
    List<DetallePedido> toEntitiesList(List<DetallePedidoDTO> source);

    @Named("mapArticuloToDTO")
    default ArticuloDTO mapArticuloToDTO(Articulo articulo) {
        if (articulo instanceof ArticuloInsumo) {
            return ((ArticuloInsumoMapper) MapperFactory.getMapper(ArticuloInsumoMapper.class)).toDTO((ArticuloInsumo) articulo);
        } else if (articulo instanceof ArticuloManufacturado) {
            return ((ArticuloManufacturadoMapper) MapperFactory.getMapper(ArticuloManufacturadoMapper.class)).toDTO((ArticuloManufacturado) articulo);
        }
        throw new IllegalArgumentException("Unknown Articulo type: " + articulo.getClass().getName());
    }

    @Named("mapDTOToArticulo")
    default Articulo mapDTOToArticulo(ArticuloDTO articuloDTO) {
        if (articuloDTO instanceof ArticuloInsumoDTO) {
            return ((ArticuloInsumoMapper) MapperFactory.getMapper(ArticuloInsumoMapper.class)).toEntity((ArticuloInsumoDTO) articuloDTO);
        } else if (articuloDTO instanceof ArticuloManufacturadoDTO) {
            return ((ArticuloManufacturadoMapper) MapperFactory.getMapper(ArticuloManufacturadoMapper.class)).toEntity((ArticuloManufacturadoDTO) articuloDTO);
        }
        throw new IllegalArgumentException("Unknown ArticuloDTO type: " + articuloDTO.getClass().getName());
    }
}
