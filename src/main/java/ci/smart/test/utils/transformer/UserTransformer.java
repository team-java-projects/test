package ci.smart.test.utils.transformer;

import java.text.ParseException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ci.smart.test.entities.User;
import ci.smart.test.utils.dto.UserDto;

@Mapper
	public interface UserTransformer {

		UserTransformer INSTANCE = Mappers.getMapper(UserTransformer.class);

//		@FullTransformerQualifier
//		@Mappings({
//		})
//		UserDto toDto(User entity) throws ParseException;

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

