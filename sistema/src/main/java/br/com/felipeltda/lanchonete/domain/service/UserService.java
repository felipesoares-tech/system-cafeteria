package br.com.felipeltda.lanchonete.domain.service;

import br.com.felipeltda.lanchonete.domain.model.User;
import br.com.felipeltda.lanchonete.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    UserRepository userRepository;


    public User create(User user) {
        User existUser = userRepository.findByUsername(user.getUsername());

        if(existUser != null){
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
