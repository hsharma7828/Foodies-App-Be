package in.him.Foodies_App_Be.service;

import in.him.Foodies_App_Be.entity.UserEntity;
import in.him.Foodies_App_Be.io.UserRequest;
import in.him.Foodies_App_Be.io.UserResponse;
import in.him.Foodies_App_Be.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService{

    private  final UserRepository userRepository;

    @Override
    public UserResponse registerUser(UserRequest request) {
        UserEntity newUser = convertToEntity(request);
        newUser = userRepository.save(newUser);
        return convertToResponse(newUser);
    }

    private UserEntity convertToEntity(UserRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
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
