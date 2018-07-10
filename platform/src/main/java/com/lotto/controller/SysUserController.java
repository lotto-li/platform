package com.lotto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.domain.SysUser;
import com.lotto.repository.SysUserRepository;

@RestController
public class SysUserController {
	@Autowired
	private SysUserRepository sysUserRepository;
	
	@RequestMapping(value = "/createSysUser", method = RequestMethod.POST)
	public void createSysUser() {
		
	}
	
	@RequestMapping(value = "/deleteSysUser", method = RequestMethod.DELETE)
	public void deleteSysUser() {
		
	}
	
	@RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
	public void updateSysUser() {
		
	}
	
	@RequestMapping(value = "/getSysUser", method = RequestMethod.GET)
	public List<SysUser> getSysUser(@RequestParam String username, @RequestParam String password) {
		List<SysUser> users = new ArrayList<SysUser>();
		SysUser user = sysUserRepository.findByUsernameAndPassword(username,password);
		users.add(user);
		return users;
	}

}
