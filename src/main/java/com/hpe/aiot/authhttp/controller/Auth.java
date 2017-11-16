package com.hpe.aiot.authhttp.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class Auth {
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> mqttAuth(
			@RequestParam(value="clientid",required=false) String clientid,
			@RequestParam(value="username") String username,
			@RequestParam(value="password") String password) {
		
		System.out.println("auth: " + clientid + " " + username + " |[ " +password);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/superuser", method = RequestMethod.POST)
	public ResponseEntity<?> mqttSuperuser(
			@RequestParam(value="clientid",required=false) String clientid,
			@RequestParam(value="username") String username) {
		
		System.out.println("superuser: " + clientid + " " + username);
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
	
}
