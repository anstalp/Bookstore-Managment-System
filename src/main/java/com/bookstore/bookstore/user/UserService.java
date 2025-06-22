package com.bookstore.bookstore.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //register new user
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("User with email " + user.getEmail() + " already exists");
        }

        //Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        //Role by Email
        String email = user.getEmail();
        if (email.endsWith("@book.gr")) {
            user.setRole(UserRole.EMPLOYEE);
        } else if (email.endsWith("@owner.book.gr")) {
            user.setRole(UserRole.OWNER);
        } else {
            user.setRole(UserRole.CUSTOMER);
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + "does not exist"));

        if(name!=null && !name.isEmpty() &&!Objects.equals(user.getName(), name)){
            user.setName(name);
        }

        if(email!=null && !email.isEmpty() &&!Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findByEmail(email);
            if(userOptional.isPresent()){
                throw new IllegalStateException("User with email " + email + " already exists");
            }
            user.setEmail(email);
        }


    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email).or(() -> userRepository.findByName(email));;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Δεν βρέθηκε χρήστης"));
    }

}
