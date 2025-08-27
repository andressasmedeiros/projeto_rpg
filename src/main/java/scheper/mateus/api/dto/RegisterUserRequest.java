package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class RegisterUserRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Invalid name.")
    @Schema(description = "The name of the user.", example = "My Name")
    private String name;

    @NotBlank(message = "Invalid e-mail.")
    @Email(message = "Invalid e-mail format.")
    @Size(max = 360, message = "E-mail must be at most 360 characters.")
    @Schema(description = "The email address of the user.", example = "email@email.com")
    private String email;

    @NotBlank(message = "Invalid password.")
    @Size(min = 8, message = "Password must be at least 8 characters.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Password must contain upper, lower case letters and a number.")
    @Schema(description = "The password of the user.", example = "password123")
    private String password;
}
