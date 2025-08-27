package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateCharacterRequest implements Serializable {
    @NotNull
    @Schema(description = "ID of the user owner of the character", example = "1")
    private Long userId;
}
