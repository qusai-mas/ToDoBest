package com.example.onlineTeaching.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlineTeaching.models.user;
import com.example.onlineTeaching.service.userService;


@RestController
public class admin {
	@Autowired
	userService uDao;
	
	@PostMapping(
			  value = "/admin/addUser", consumes = "application/json", produces = "application/json")
	public user  addUser(@RequestBody user usr)
	{
		//ResponseEntity<String>
		user n = new  user();
		System.out.println(usr);
		n.setEmail(usr.getEmail());
		n.setname(usr.getname());
	
		n.setPassword(usr.getPassword());
		 uDao.saveUser(n);
		 HttpHeaders httpHeaders = new HttpHeaders();

		 return n;
		
	}
	@GetMapping("/admin/{email}/{password}")
	public user login(@PathVariable(name="email") String email, @PathVariable String password)
	{
		return uDao.login( email, password);
	}
	@GetMapping("/admin/getAll")
	public Collection<user>getAllUsers()
	{
		return uDao.getAllUsers();
	}
	@DeleteMapping("/admin/deleteUser/{id}")
	public void removeById(@RequestParam(name="id") int id)
	{
		uDao.removeUser(id);
	}

	

}
