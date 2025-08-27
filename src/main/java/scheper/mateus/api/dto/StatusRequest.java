package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.StatusType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class StatusRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Status type is required.")
    @Schema(description = "The type of the status.", example = "HP")
    private StatusType type;

    @NotNull(message = "Value is required.")
    @Min(value = 0, message = "Value must be greater than or equal to 0.")
    @Schema(description = "The value of the status (must be >= 0).", example = "150")
    private Integer value;
}
