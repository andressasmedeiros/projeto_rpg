package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CharacterResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the character.", example = "101")
    private Long id;

    @Schema(description = "The unique identifier of the user who owns the character.", example = "12")
    private Long userId;

    @Schema(description = "The unique identifier of the inventory linked to the character.", example = "55")
    private Long inventoryId;

    @Schema(description = "The unique identifier of the equipment linked to the character.", example = "77")
    private Long equipmentId;
}
