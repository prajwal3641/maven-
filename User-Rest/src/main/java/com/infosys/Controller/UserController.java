package com.infosys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.Service.UserService;
import com.infosys.entity.ResponseDto;
import com.infosys.entity.UserInfo;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("{id}")
	public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userid){
		ResponseDto responseDto=userService.getUser(userid);
		return ResponseEntity.ok(responseDto);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo u){
		return new ResponseEntity<UserInfo>(userService.saveUser(u),HttpStatus.OK);
	}
}
