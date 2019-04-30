package com.codecool.springbootregister.security.services;

import com.codecool.springbootregister.model.User;
import com.codecool.springbootregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = null;
		try {
			user = userRepository.findByUsername(username).orElseThrow(
					() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return UserPrinciple.build(user);


	}
}