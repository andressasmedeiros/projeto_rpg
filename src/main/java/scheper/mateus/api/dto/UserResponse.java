package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class UserResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the user.", example = "12345")
    private Long id;

    @Schema(description = "The name of the user.", example = "My Name")
    private String name;

    @Schema(description = "The email address of the user.", example = "email@email.com")
    private String email;

    @Schema(description = "The ID of the user's current character", example = "10")
    private Long currentCharacterId;

    @Schema(description = "The roles of the user.", example = "['ADMIN', 'USER', 'SUPPORT']")
    private List<String> roles;

    @Schema(description = "The status of the user.", example = "true")
    private boolean active;

}
