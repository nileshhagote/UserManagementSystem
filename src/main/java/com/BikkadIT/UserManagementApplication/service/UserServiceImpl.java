package com.BikkadIT.UserManagementApplication.service;

import org.springframework.stereotype.Service;

import com.BikkadIT.UserManagementApplication.binding.LoginForm;
import com.BikkadIT.UserManagementApplication.entities.UserAccountEntity;
import com.BikkadIT.UserManagementApplication.repositories.UserAccountRepository;

@Service
public class UserServiceImpl implements UserServiceI{
	
	private UserAccountRepository userAccountRepository;
	
	@Override
	public String loginCheck(LoginForm loginform) {
		UserAccountEntity userAccountEntity	=userAccountRepository.findByEmailAndPassword(loginform.getEmail(), loginform.getPassword());
		
		if(userAccountEntity !=null) {
			
			String accStatus = userAccountEntity.getAccStatus();
				if(accStatus.equals("LOCKED")) {
				return "Your Account is locked";
				
			}else { 
				return "Login successful. Welcome to Bikkad IT";
				
			}
			
		}else {
			return "Creditional Are Invalid";
		}
		
	}
	

}
