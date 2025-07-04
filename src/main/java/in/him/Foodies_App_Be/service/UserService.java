package in.him.Foodies_App_Be.service;

import in.him.Foodies_App_Be.io.UserRequest;
import in.him.Foodies_App_Be.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);
}
