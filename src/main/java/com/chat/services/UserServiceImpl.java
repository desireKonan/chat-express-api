package com.chat.services;

import java.util.*;

import javax.transaction.Transactional;
import com.chat.domain.model.Role;
import com.chat.domain.model.User;
import com.chat.repositories.RoleRepository;
import com.chat.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return this.userRepository.findAll();
    }


    @Override
    public User getUser(UUID id) {
        // TODO Auto-generated method stub
        return this.userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        log.info("Utilisateur sauvegardé : {} {}", user.getFirstname() , user.getLastname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findUserByEmail(email);
        Role role = roleRepository.findUserByName(roleName);
        user.getRoles().add(role);
    }


    @Override
    public User findUserByEmail(String email) {
        // TODO Auto-generated method stub
        return this.userRepository.findUserByEmail(email);
    }


    @Override
    public void deleteUser(final UUID id) {
        // TODO Auto-generated method stub
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByEmail(email);
        System.out.println(user);
        if(user == null) {
            log.info("L'utilisateur n'existe pas en base de données !");
            throw new UsernameNotFoundException("L'utilisateur n'existe pas en base de données !");
        } else {
            log.info("Utilisateur en base de données : {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
