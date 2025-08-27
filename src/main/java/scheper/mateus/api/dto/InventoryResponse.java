package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class InventoryResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the inventory.", example = "501")
    private Long id;

    @Schema(description = "The number of slots in the inventory.", example = "24")
    private Integer slots;

    @Schema(description = "The list of items in the inventory.")
    private List<ItemResponse> itemIds;
}
