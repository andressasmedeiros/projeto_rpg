package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.ItemType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ItemResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the item.", example = "1001")
    private Long id;

    @Schema(description = "The name of the item.", example = "Iron Sword")
    private String name;

    @Schema(description = "The description of the item.", example = "A sturdy sword made of iron.")
    private String description;

    @Schema(description = "The type of the item.", example = "WEAPON")
    private ItemType type;

    @Schema(description = "The value of the item (must be greater than 0).", example = "120")
    private Integer value;
}
