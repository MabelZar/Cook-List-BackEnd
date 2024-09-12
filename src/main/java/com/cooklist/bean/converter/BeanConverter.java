package com.cooklist.bean.converter;

import java.util.List;

public interface BeanConverter<ENT, DTO> {

	DTO convertToDto(ENT entity);

	ENT convertToEntity(DTO dto);

	List<DTO> convertToDtos(List<ENT> entities);

    List<ENT> convertToEntities(List<DTO> dtos);

}
