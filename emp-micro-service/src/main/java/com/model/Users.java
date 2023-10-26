package com.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


public class Users {
	
	List<User> users;

	public List<User> getUsers() {
		if(users == null) {
			users = new ArrayList<>();
		}
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Users() {
		super();
	}

	public Users(List<User> users) {
		super();
		this.users = users;
	}
	

}
