package com.kerjox.restapi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Integer id;
	private String login;
	private String password;
	private String info;
	private Integer age;
	private Integer salary;
	private String name;
	private String auth_token;
}
