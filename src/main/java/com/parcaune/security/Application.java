package com.parcaune.security;

import com.parcaune.security.domain.Role;
import com.parcaune.security.domain.User;
import com.parcaune.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Lionel Tonde", "leo", "ne83bfdi19fnvz", new ArrayList<>()));
			userService.saveUser(new User(null, "Simplice Tchoupkoua", "Ice", "u873bfgg10e72e", new ArrayList<>()));
			userService.saveUser(new User(null, "Willie Chieukam", "will", "ow64d92bswd", new ArrayList<>()));
			userService.saveUser(new User(null, "Cedric Mube", "Mubs", "he83ba4geu1b034n", new ArrayList<>()));

			userService.addRoleToUser("leo", "ROLE_USER");
			userService.addRoleToUser("Ice", "ROLE_MANAGER");
			userService.addRoleToUser("Ice", "ROLE_ADMIN");
			userService.addRoleToUser("will", "ROLE_ADMIN");
			userService.addRoleToUser("will", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Mubs", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Mubs", "ROLE_ADMIN");
			userService.addRoleToUser("Mubs", "ROLE_MANAGER");
			userService.addRoleToUser("Mubs", "ROLE_USER");

		};
	}
}
