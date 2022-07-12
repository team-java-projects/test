package ci.smart.test.utils.transformer;

import java.text.ParseException;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ci.smart.test.entities.*;
import ci.smart.test.utils.dto.*;


@Mapper
	public interface UserTransformer {

		UserTransformer INSTANCE = Mappers.getMapper(UserTransformer.class);

//		@FullTransformerQualifier
		@Mappings({
			@Mapping(source="entity.id", target="id"),
			@Mapping(source="entity.nom", target="nom"),
			@Mapping(source="entity.prenom", target="prenom"),
			@Mapping(source="entity.telephone", target="telephone"),
			@Mapping(source="entity.password", target="password"),
			@Mapping(source="entity.login", target="login"),
})
		UserDto toDto(User entity) throws ParseException;
		
//		@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
//	   List<UserDto> toDtos(List<User> entities) throws ParseException;

		
		@Mappings({
			@Mapping(source="dto.id", target="id"),
			@Mapping(source="dto.nom", target="nom"),
			@Mapping(source="dto.prenom", target="prenom"),
			@Mapping(source="dto.telephone", target="telephone"),
			@Mapping(source="dto.password", target="password"),
			@Mapping(source="dto.login", target="login"),
		})
		
	    User toEntity(UserDto dto) throws ParseException;
		
		
	}

