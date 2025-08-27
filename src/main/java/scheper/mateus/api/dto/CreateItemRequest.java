package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.ItemType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CreateItemRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Name is required.")
    @Size(max = 24, message = "Name must be at most 24 characters.")
    @Schema(description = "The name of the item.", example = "Iron Sword")
    private String name;

    @NotBlank(message = "Description is required.")
    @Schema(description = "The description of the item.", example = "A sturdy sword made of iron.")
    private String description;

    @NotNull(message = "Type is required.")
    @Schema(description = "The type of the item.", example = "WEAPON")
    private ItemType type;

    @NotNull(message = "Value is required.")
    @Min(value = 1, message = "Value must be greater than 0.")
    @Schema(description = "The value of the item (must be greater than 0).", example = "100")
    private Integer value;
}
