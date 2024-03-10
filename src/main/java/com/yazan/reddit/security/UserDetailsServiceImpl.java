//package com.yazan.reddit.security;
//
//import com.yazan.reddit.domain.User;
//import com.yazan.reddit.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public UserDetailsServiceImpl(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(email);
//
//        if ( !user.isPresent() ) {
//            throw new UsernameNotFoundException(email);
//        }
//        return user.get();
//    }
//}
