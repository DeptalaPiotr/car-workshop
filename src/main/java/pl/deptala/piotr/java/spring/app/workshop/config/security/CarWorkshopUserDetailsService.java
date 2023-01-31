package pl.deptala.piotr.java.spring.app.workshop.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.deptala.piotr.java.spring.app.workshop.repository.UserRepository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class CarWorkshopUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(CarWorkshopUserDetailsService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername(" + username + ")");

        UserEntity userEntity = userRepository.findByUsername(username);
        LOGGER.info("userEntity: " + userEntity);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

//        Set<UserEntity> roles = userEntity.getRoles();
//        String[] roleNames = new String[roles.size()];

//        User user = new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
        UserDetails userDetails = User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
//                .roles(roleNames)
                .roles("USER")
                .build();

        LOGGER.info("loadUserByUsername(..) = " + userDetails);
        return userDetails;
    }


//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
}
