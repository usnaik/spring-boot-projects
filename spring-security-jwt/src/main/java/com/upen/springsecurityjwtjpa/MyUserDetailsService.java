package com.upen.springsecurityjwtjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upen.springsecurityjwtjpa.models.MyUserDetails;
import com.upen.springsecurityjwtjpa.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
    
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
//        return new User("foo", "foo", new ArrayList<>());

        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();

    }
}