package ci.smart.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ci.smart.test.business.UserBusiness;
import ci.smart.test.utils.Request;
import ci.smart.test.utils.Response;
import ci.smart.test.utils.dto.UserDto;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserBusiness userBusiness;

	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public Response<UserDto> create(@RequestBody Request<UserDto> request) {

		Response<UserDto> response = new Response<UserDto>();

		try {
			if (request.getDatas().isEmpty()) {
				response.setMessage("liste vide");
				response.setHasError(true);
				return response;
			}
			
		response = userBusiness.createUser(request);

		} catch (Exception e) {
			e.printStackTrace();		
			response.setHasError(true);
			response.setMessage("Erreur rencontrée");
		}
		return response;
	}


	@RequestMapping(value = "/connexion", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
	"application/json" })
public Response<UserDto> connexion(@RequestBody Request<UserDto> request) {

Response<UserDto> response = new Response<UserDto>();

try {

	if (request.getData().getLogin() == null || request.getData().getPassword() == null) {
		response.setMessage("Champs non renseigné");
		response.setHasError(true);
		return response;
	}
	
response = userBusiness.connexion(request);

} catch (Exception e) {
	e.printStackTrace();		
	response.setHasError(true);
	response.setMessage("Erreur rencontrée");
}
return response;
}


	

	
	
}
