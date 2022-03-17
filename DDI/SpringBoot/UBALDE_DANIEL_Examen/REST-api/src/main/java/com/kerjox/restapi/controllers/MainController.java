package com.kerjox.restapi.controllers;

import com.kerjox.restapi.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
public class MainController {

	private User user = new User();

	@GetMapping("login")
	public ResponseEntity<User> login(String login, String password) {

		user.setLogin(login);
		user.setPassword(password);
		user.setInfo("login success");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("user_info")
	public ResponseEntity<User> gerUserInfo(@RequestBody User payloadUser) {

		user.setAge(payloadUser.getAge());
		user.setSalary(payloadUser.getSalary());
		user.setName(payloadUser.getName());
		user.setAuth_token(payloadUser.getAuth_token());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("get_test_user/{id}")
		public ResponseEntity<User> getTestUser(@PathVariable("id") Integer id, String name, @RequestParam("id") Integer newID) {

		user.setId(newID);
		user.setName(name);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
