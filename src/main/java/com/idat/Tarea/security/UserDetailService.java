package com.idat.Tarea.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//comparar profesor de la base de datos con el username del token
		if("profesor".equals(username)) {
			//usuario - contraseña - rol
			return new User("profesor", new BCryptPasswordEncoder().encode("123456"), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Usuario no existe "+username);
		}
	}

}
