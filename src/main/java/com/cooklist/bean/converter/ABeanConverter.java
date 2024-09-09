package com.cooklist.bean.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;

public abstract class ABeanConverter<ENT, DTO> implements BeanConverter<ENT, DTO> {

	protected abstract void populateDto(DTO dto, ENT entity);

	protected abstract void populateEntity(ENT entity, DTO dto);

	protected abstract DTO getNewDto();

	protected abstract ENT getNewEntity();

	@Override
	public DTO convertToDto(ENT entity) {

		DTO dto = null;

		if (Objects.nonNull(entity)) {
			dto = getNewDto();
			populateDto(dto, entity);
		}

		return dto;
	}

	@Override
	public ENT convertToEntity(DTO dto) {

		ENT entity = null;

		if (Objects.nonNull(dto)) {
			entity = getNewEntity();
			populateEntity(entity, dto);
		}

		return entity;
	}

	@Override
	public List<DTO> convertToDtos(List<ENT> entities) {

		List<DTO> dtos = null;

		if (CollectionUtils.isNotEmpty(entities)) {

			dtos = new ArrayList<DTO>();

			for (ENT entity : entities) {

				DTO dto = convertToDto(entity);

				if (Objects.nonNull(dto)) {
					dtos.add(dto);
				}

			}

		}

		return dtos;
	}

	@Override
	public List<ENT> convertToEntities(List<DTO> dtos) {

		List<ENT> entities = null;

		if (CollectionUtils.isNotEmpty(dtos)) {

			entities = new ArrayList<ENT>();

			for (DTO dto : dtos) {

				ENT entity = convertToEntity(dto);

				if (Objects.nonNull(entity)) {
					entities.add(entity);
				}

			}

		}

		return entities;
	}

}
