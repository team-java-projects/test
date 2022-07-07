package ci.smart.test.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ci.smart.test.entities.User;
import ci.smart.test.repository.UserRepository;
import ci.smart.test.utils.dto.UserDto;

@Component
public class UserBusiness {

	@Autowired
	private UserRepository userRepository;

	private Response<UserDto> response;

	public Response<UserDto> createUser (Request<UserDto> request) {
	
 
		for (UserDto userDto : request.getDatas()) {
			User userToSaved = userRepository.findByTelephone
					(userDto.getTelephone());
			if (userToSaved != null) {
				response.setMessage
				("ce telephone appartient deja a un utilisateur");
				response.setHasError(true);
				return response;
			}
			
			User userSaved = userRepository.save(userToSaved);
			return response;
		}
		
//		for (UserDto userDto : request.getDatas()) {
//			User userToSaved = userRepository.findByLoginAndPassword
//					(userDto.getLogin(), userDto.getPassword());
//			User userSaved = userRepository.save(userToSaved);
//			return response;
//		}
		
		return response;
	}


	public class Request<T>  {
		protected T			data;
		protected List<T>	datas;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public List<T> getDatas() {
			return datas;
		}
		public void setDatas(List<T> datas) {
			this.datas = datas;
		}

	}

	public class Response<T> {

		protected List<T> items;
		protected T item;
		protected String message;
		protected boolean	hasError;
		
		public List<T> getItems() {
			return items;
		}
		public void setItems(List<T> items) {
			this.items = items;
		}
		public T getItem() {
			return item;
		}
		public void setItem(T item) {
			this.item = item;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public boolean isHasError() {
			return hasError;
		}
		public void setHasError(boolean hasError) {
			this.hasError = hasError;
		}

	}



}
