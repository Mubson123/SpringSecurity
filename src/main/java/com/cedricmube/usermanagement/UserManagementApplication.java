package com.cedricmube.usermanagement;

import com.cedricmube.usermanagement.domain.Role;
import com.cedricmube.usermanagement.domain.User;
import com.cedricmube.usermanagement.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Cedric Mube", "Mubson123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Eddy Awoukeng", "AwoukEd", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Bertand Dipah", "LeFer", "1234", new ArrayList<>()));

			userService.addRoleToUser("Mubson123", "ROLE_MANAGER");
			userService.addRoleToUser("AwoukEd", "ROLE_ADMIN");
			userService.addRoleToUser("LeFer", "ROLE_USER");
			userService.addRoleToUser("Mubson123", "ROLE_ADMIN");


		};

	}

}
