package com.lti.fsp.user.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.fsp.dto.UserDTO;
import com.lti.fsp.request.GlobalRequest;
import com.lti.fsp.user.entity.User;

@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping("/testrequest")
	public boolean test(@RequestBody String stringJson) {
		System.out.println(stringJson);
		GlobalRequest globlaRequest = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			globlaRequest = mapper.readValue(stringJson, GlobalRequest.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Global Request is " + globlaRequest);
		return true;
	}
}
