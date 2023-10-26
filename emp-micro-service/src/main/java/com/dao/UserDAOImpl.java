package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.User;
import com.model.Users;

@Service
public class UserDAOImpl implements UserDAO {
	
	private static Users list = new Users();
	
	static {
		list.getUsers().add(new User(1,"ANK","ank@gmail.com","Hyderabad"));
		list.getUsers().add(new User(2,"ALP","alp@gmail.com","NY"));
		list.getUsers().add(new User(3,"ASH","ash@gmail.com","Ranchi"));
	}

	@Override
	public Users getAllUsers() {
		// TODO Auto-generated method stub
		
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		list.getUsers().add(user);

	}

}
