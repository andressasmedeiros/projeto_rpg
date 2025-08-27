package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class EquipmentResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the equipment.", example = "2001")
    private Long id;

    @Schema(description = "The ID of the helmet item equipped.", example = "101")
    private Long helmetId;

    @Schema(description = "The ID of the armor item equipped.", example = "102")
    private Long armorId;

    @Schema(description = "The ID of the legs item equipped.", example = "103")
    private Long legsId;

    @Schema(description = "The ID of the boots item equipped.", example = "104")
    private Long bootsId;

    @Schema(description = "The ID of the weapon item equipped.", example = "105")
    private Long weaponId;

    @Schema(description = "The ID of the shield item equipped.", example = "106")
    private Long shieldId;
}
