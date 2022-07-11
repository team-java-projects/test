package ci.smart.test.business;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ci.smart.test.entities.User;
import ci.smart.test.repository.UserRepository;
import ci.smart.test.utils.Request;
import ci.smart.test.utils.Response;
import ci.smart.test.utils.dto.UserDto;
import ci.smart.test.utils.transformer.UserTransformer;

@Service
public class UserBusiness {


	private UserRepository userRepository;
	private Response<UserDto> response;



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

		List<User> items = new ArrayList<>();

		
		try {

			//		for (UserDto userDto : request.getDatas()) {
			//		User userToSaved = userRepository.findByLoginAndPassword
			//				(userDto.getLogin(), userDto.getPassword());
			//		User userSaved = userRepository.save(userToSaved);
			//		return response;
			//	}

			for (UserDto userDto : request.getDatas()) {
				User userToSaved = userRepository.findByTelephone
						(userDto.getTelephone());
				if (userToSaved != null) {
					response.setMessage
					("ce telephone appartient deja a un utilisateur");
					response.setHasError(true);
					return response;
				}
				
				items.add(userToSaved);
				
			}
			
			if (!items.isEmpty() || items != null)
			userRepository.saveAll(items);
			
			response.setMessage("user sauvegardé");;
			response.setHasError(false);
			response.setItems(null);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return response;
	}


}
