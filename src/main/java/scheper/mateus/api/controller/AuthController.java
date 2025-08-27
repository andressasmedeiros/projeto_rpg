package scheper.mateus.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import scheper.mateus.api.dto.LoginRequest;
import scheper.mateus.api.dto.RegisterUserRequest;
import scheper.mateus.api.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Register a new user",
            description = "This endpoint allows a new user to register by providing their details.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User registered successfully")
            }
    )
    public void register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User registration details",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterUserRequest.class))
            )
            @RequestBody @Valid RegisterUserRequest registerUserRequest) {
        authService.register(registerUserRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "User login",
            description = "This endpoint allows a user to log in by providing their email and password.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful"),
                    @ApiResponse(responseCode = "401", description = "Invalid email or password")
            }
    )
    public String login(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Login credentials",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoginRequest.class))
            )
            @RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "User logout",
            description = "This endpoint allows a user to log out, invalidating their session.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Logout successful"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    public void logout() {
        authService.logout();
    }
}
