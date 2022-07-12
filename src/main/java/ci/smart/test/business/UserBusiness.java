package ci.smart.test.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionAdapterUserTransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.smart.test.entities.User;
import ci.smart.test.repository.UserRepository;
import ci.smart.test.utils.Request;
import ci.smart.test.utils.Response;
import ci.smart.test.utils.dto.UserDto;
import ci.smart.test.utils.transformer.UserTransformer;

@Service
public class UserBusiness {

	@Autowired
	private UserRepository userRepository;
	
//	private Response<UserDto> response;



	//	public UserBusiness(UserRepository userRepository, Response<UserDto> response) {
	//		super();
	//		this.userRepository = userRepository;
	//		this.response = response;
	//	}



	public UserBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Response<UserDto> createUser (Request<UserDto> request) {

		Response<UserDto> response = new Response<UserDto>();

		List<User> items = new ArrayList<>();
		List<UserDto> itemsDto = new ArrayList<>();

		
		try {

			//		for (UserDto userDto : request.getDatas()) {
			//		User userToSaved = userRepository.findByLoginAndPassword
			//				(userDto.getLogin(), userDto.getPassword());
			//		User userSaved = userRepository.save(userToSaved);
			//		return response;
			//	}

			for (UserDto userDto : request.getDatas()) {
				User existingUser = userRepository.findByTelephone(userDto.getTelephone());
				System.out.println(existingUser);
				
				if (existingUser != null) {
					response.setMessage
					("ce telephone appartient deja a un utilisateur");
					response.setHasError(true);
					return response;
				}
				User userToSaved = UserTransformer.INSTANCE.toEntity(userDto);
				items.add(userToSaved);
				itemsDto.add(userDto);
				
			}
			
			if (!items.isEmpty() || items != null) {
				userRepository.saveAll(items);
				
				response.setMessage(" Opération effectuée avec succes, utilisateur enregistré");
				response.setHasError(false);
				response.setItems(itemsDto);
				return response;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return response;
	}

	public Response<UserDto> connexion (Request<UserDto> request) {

		Response<UserDto> response = new Response<UserDto>();
		
		try {

				UserDto userDto = request.getData(); 
				User userExisting = userRepository.findByLoginAndPassword
							(userDto.getLogin(), userDto.getPassword());
				if (userExisting == null) {
					response.setMessage
					("cet utilisateur n'existe pas");
					response.setHasError(true);
					return response;
				}
				UserDto udto = UserTransformer.INSTANCE.toDto(userExisting);
				udto.setPassword(null);
						
				response.setMessage("utilisateur connecté");
				response.setHasError(false);
				response.setItem(udto);
				return response;
								
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	

}
