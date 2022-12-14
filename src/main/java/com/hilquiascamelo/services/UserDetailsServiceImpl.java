package com.hilquiascamelo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hilquiascamelo.dao.UserRepository;
import com.hilquiascamelo.models.Users;
import com.hilquiascamelo.security.UserValidator;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

 
 @Autowired
 UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     Users user = userRepository.findByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException(email);
        }

        return new UserValidator(user.getIdUsers(), user.getEmail(), user.getPassword(), user.getProfile());
    }
    
}
