package com.infosys.Service;

import com.infosys.entity.ResponseDto;
import com.infosys.entity.UserInfo;

public interface UserService {
	UserInfo saveUser(UserInfo userInfo);
	ResponseDto getUser(Long userid);
}
