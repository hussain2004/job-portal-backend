package com.shaik.jobportal.service;

import com.shaik.jobportal.entity.User;
import com.shaik.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaik.jobportal.dto.UserDTO;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.shaik.jobportal.dto.LoginResponse;
import com.shaik.jobportal.service.JwtService;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public User saveUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(
                    passwordEncoder.encode(updatedUser.getPassword())
            );
            existingUser.setRole(updatedUser.getRole());

            return userRepository.save(existingUser);
        }

        return null;
    }
    public String deleteUser(Long id) {

        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }

        return "User not found";
    }
    public UserDTO convertToDTO(User user) {

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
    public List<UserDTO> getAllUsersDTO() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public UserDTO getUserDTOById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return convertToDTO(user);
    }
    public LoginResponse login(String email, String password) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return new LoginResponse("User not found");
        }

        if (passwordEncoder.matches(password, user.getPassword())) {

            String token = jwtService.generateToken(user.getEmail());

            return new LoginResponse(token);
        }

        return new LoginResponse("Invalid Password");
    }
}