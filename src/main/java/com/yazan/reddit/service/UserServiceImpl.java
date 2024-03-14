package com.yazan.reddit.service;

import com.yazan.reddit.domain.User;
import com.yazan.reddit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        // take the password from the form and encode
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        // confirm password
        user.setConfirmPassword(secret);

        // assign a role to this user
        user.addRole(roleService.findByName("ROLE_USER"));

        // disable the user
        user.setEnabled(false);

        // save user
        save(user);


        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users) {
        for(User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

}