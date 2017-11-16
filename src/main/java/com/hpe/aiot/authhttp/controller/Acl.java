package com.hpe.aiot.authhttp.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.aiot.authhttp.AppName;


@RestController
@RequestMapping("/mqtt")
public class Acl {
	int aclCount = 0;
	
	@Autowired
	AppName appName;
	
	
	@RequestMapping(value = "/acl", method = RequestMethod.GET)
	public ResponseEntity<?> mqttAcl(
			@RequestParam(value="clientid",required=false) String clientid,
			@RequestParam(value="username") String username,
			@RequestParam(value="access") String access,
			@RequestParam(value="topic") String topic,
			@RequestParam(value="ipaddr", required=false) String ipaddr) {
		
		System.out.println("acl: " + clientid + " " + username + " " + access + " " + topic + " " + ipaddr);	
		System.out.println(aclCount++);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}