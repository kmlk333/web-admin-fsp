package com.lti.fsp.user.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.fsp.dto.UserDTO;
import com.lti.fsp.request.GlobalRequest;
import com.lti.fsp.user.entity.User;
import com.lti.fsp.user.services.UserService;
import com.lti.fsp.util.Utils;

@RestController
@RequestMapping("WebUser/v1")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping("/GetUsers")
	public List<User> getUsers() throws Exception {
		System.out.println("in side get users");
		List<User> users = userService.getUsers();
		System.out.println("exist from get users");
		return users;
	}

	@GetMapping("/GetUsers/{id}")
	public User getUser(@PathVariable long id) {
		Optional<User> user = userService.getUser(id);
		return user.get();
	}
	
	@GetMapping("/GetUsers/{userName}/{isDeleted}")
	public User getDeletedUser(@PathVariable String userName, @PathVariable String isDeleted) {
		System.out.println("Inside getDeletedUser");
		return userService.getDeletedUser(userName, Integer.parseInt(isDeleted));
	}

	@PostMapping("/CreateUser")
	public User createUser(@RequestBody String requestJson) {
		
		GlobalRequest globalRequest = Utils.jsonObjectMapper(requestJson);
		System.out.println(globalRequest);
		UserDTO userDTO = globalRequest.getGlobal().getUserData();
		
		User user = userService.createUser(userDTO);
	System.out.println(user);
	return user;
	}

	@PutMapping("/UpdateUser/{id}")
	public User updateUser(@RequestBody String requestJson) {
		
		GlobalRequest globalRequest = Utils.jsonObjectMapper(requestJson);
		System.out.println(globalRequest);
		UserDTO userDTO = globalRequest.getGlobal().getUserData();
		return userService.updateUser(userDTO);
	}

	@DeleteMapping("/DeleteUser/{id}")
	public boolean deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/FindUser/{id}")
	public User findUser(@PathVariable long id) {
		return userService.findUser(id);
	}

	@PutMapping("/LockUser/{id}")
	public User lockUser(@PathVariable long id) {
		return userService.lockUser(id);
	}

	@PutMapping("/UnlockUser/{id}")
	public User unLockUser(@PathVariable long id) {
		return userService.unlockUser(id);
	}
}
