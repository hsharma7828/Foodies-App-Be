package in.him.Foodies_App_Be.service;

import in.him.Foodies_App_Be.entity.UserEntity;
import in.him.Foodies_App_Be.io.UserRequest;
import in.him.Foodies_App_Be.io.UserResponse;
import in.him.Foodies_App_Be.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService{

    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public UserResponse registerUser(UserRequest request) {
        UserEntity newUser = convertToEntity(request);
        newUser = userRepository.save(newUser);
        return convertToResponse(newUser);
    }

    @Override
    public String findByUserId() {
        String loggedInUserEmail = authenticationFacade.getAuthentication().getName();
        UserEntity loggedInUser = userRepository.findByEmail(loggedInUserEmail).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return loggedInUser.getId();
    }

    private UserEntity convertToEntity(UserRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();
    }

    private UserResponse convertToResponse (UserEntity registerdUser) {
        return UserResponse.builder()
                .id(registerdUser.getId())
                .name(registerdUser.getName())
                .email(registerdUser.getEmail())
                .build();
    }
}
