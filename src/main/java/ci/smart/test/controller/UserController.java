package ci.smart.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ci.smart.test.business.UserBusiness;
import ci.smart.test.business.UserBusiness.Request;
import ci.smart.test.business.UserBusiness.Response;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserBusiness userBusiness;


	
}
