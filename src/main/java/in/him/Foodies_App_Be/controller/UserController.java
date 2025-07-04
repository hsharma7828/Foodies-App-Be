package in.him.Foodies_App_Be.controller;

import in.him.Foodies_App_Be.io.UserRequest;
import in.him.Foodies_App_Be.io.UserResponse;
import in.him.Foodies_App_Be.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
}
