package com.example.springcore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDAO;
import com.model.User;
import com.service.AppDelegate;

@RestController
@RequestMapping("/myapp")
public class AppController {
	@Autowired
	AppDelegate userDAO;
//	@PostMapping("/addUser")
//	public ResponseEntity<Object> addUser(@RequestBody User user) {
//		 int prevId= userDAO.getAllUsers().getUsers().size();
//		 user.setuId(prevId+1);
//		userDAO.addUser(user);
//		return ResponseEntity.ok("User added");
//	}
	
	@GetMapping("/getUsers")
	public String getUser(
//			@RequestHeader(name="ITASHI",required=true) String headerPersist,
//			@RequestHeader(name="X-COM-LOCATION",defaultValue = "ASIA") String location
			) {
		return userDAO.loadDataFromDataBase();
	}
	
	

}
