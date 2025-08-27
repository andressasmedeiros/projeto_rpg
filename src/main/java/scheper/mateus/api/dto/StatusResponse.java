package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.StatusType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class StatusResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the status.", example = "2001")
    private Long id;

    @Schema(description = "The ID of the character associated with this status.", example = "101")
    private Long characterId;

    @Schema(description = "The type of the status.", example = "ATTACK")
    private StatusType type;

    @Schema(description = "The value of the status (must be >= 0).", example = "75")
    private Integer value;
}
