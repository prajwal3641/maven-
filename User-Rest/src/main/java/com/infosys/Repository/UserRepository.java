package com.infosys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo,Long>{

}
