package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class LoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Invalid e-mail.")
    @Schema(description = "The email address of the user.", example = "email@email.com")
    private String email;

    @NotBlank(message = "Invalid password.")
    @Schema(description = "The password of the user.", example = "password123")
    private String password;
}
