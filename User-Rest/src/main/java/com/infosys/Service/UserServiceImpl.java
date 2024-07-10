package com.infosys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.Repository.UserRepository;
import com.infosys.entity.DepartmentsDto;
import com.infosys.entity.ResponseDto;
import com.infosys.entity.UserInfo;
import com.infosys.entity.UserInfoDto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserInfo saveUser(UserInfo userInfo) {
		return repository.save(userInfo);
	}

	@Override
	public ResponseDto getUser(Long userid) {
		ResponseDto responseDto = new ResponseDto();
		UserInfo user = repository.findById(userid).get();
		UserInfoDto userdto=mapToUser(user);
		ResponseEntity<DepartmentsDto> responseEntity=restTemplate.getForEntity("http://localhost:8081/api/departments/"+user.getDepartmentid(),DepartmentsDto.class);
		DepartmentsDto departmentsDto=responseEntity.getBody();
		responseDto.setUserInfoDto(userdto);
		responseDto.setDepartmentsDto(departmentsDto);
		return responseDto;
	}
	private UserInfoDto mapToUser(UserInfo user) {
		UserInfoDto userdto=new UserInfoDto();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setLastName(user.getLastName());
		userdto.setEmail(user.getEmail());
		return userdto;
	}

}
