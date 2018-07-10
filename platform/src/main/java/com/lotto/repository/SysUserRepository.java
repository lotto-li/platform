package com.lotto.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lotto.domain.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer>{
	SysUser findById(Long id);
	
	@Cacheable
	SysUser findByUsernameAndPassword(String username, String password);
	
}
