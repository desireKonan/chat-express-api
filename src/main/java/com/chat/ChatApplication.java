package com.chat;
import com.chat.domain.model.Role;
import com.chat.domain.model.User;
import com.chat.migration.data.RolePopulation;
import com.chat.migration.data.UserPopulation;
import com.chat.services.UserService;
import com.chat.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserServiceImpl service) {
		return args -> {
			List<User> users = UserPopulation.getUsers();
			List<Role> roles = RolePopulation.getRoles();
			roles.forEach((role) -> service.saveRole(role));
			users.forEach((user) -> service.saveUser(user));
			users.forEach((user) -> service.addRoleToUser(user.getEmail(), "ROLE_USER"));
		};
	}

}
