package nl.itris.decadeschermen.mysql.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import nl.itris.decadeschermen.controller.dto.UserRegistrationDto;
import nl.itris.decadeschermen.mysql.domain.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
