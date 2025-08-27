package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UpdateUserRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Size(max = 360, message = "Name must be at most 360 characters.")
    @Schema(description = "The updated name of the user.", example = "John Updated")
    private String name;

    @Email(message = "Invalid e-mail format.")
    @Size(max = 360, message = "Email must be at most 360 characters.")
    @Schema(description = "The updated email address of the user.", example = "new.email@email.com")
    private String email;

    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
    @Schema(description = "The updated password of the user (hashed on save).", example = "newPassword123")
    private String password;
}
